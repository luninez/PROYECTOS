package com.example.inmobiliaria.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.inmobiliaria.Enum.TipoAutenticacion;
import com.example.inmobiliaria.Funcionalidades.Generator.ServiceGenerator;
import com.example.inmobiliaria.Funcionalidades.Responses.UserResponse;
import com.example.inmobiliaria.Funcionalidades.Services.PisoService;
import com.example.inmobiliaria.Funcionalidades.Services.UserService;
import com.example.inmobiliaria.Funcionalidades.Util;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapter.MyPisosRecyclerViewAdapter;
import com.example.inmobiliaria.lisener.OnListPisosInteractionListener;
import com.example.inmobiliaria.models.Piso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PisosFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListPisosInteractionListener mListener;
    private MyPisosRecyclerViewAdapter adapter;
    private Context ctx;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipe;

    private int tipoPeticion;

    private UserResponse userResponse;

    public PisosFragment() { }

    public void setTipoPeticion(int tipoPeticion){
        this.tipoPeticion = tipoPeticion;
    }

    public static PisosFragment newInstance(int columnCount) {
        PisosFragment fragment = new PisosFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pisos_list, container, false);

        swipe = view.findViewById(R.id.swipePisos);
        swipe.setColorSchemeResources(R.color.azulSwipe, R.color.rojoSwipe);

        if (view instanceof SwipeRefreshLayout) {
            Context context = view.getContext();

            recyclerView = view.findViewById(R.id.list_pisos);
            recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            //PETICION A LA API
            if (tipoPeticion == R.id.nav_pisos_favoritos){
                cargarPisosFavoritos(recyclerView);
            } else if (tipoPeticion == R.id.nav_mis_anuncios){
                cargarMisPisosAnunciados(recyclerView);
            } else if (tipoPeticion == R.id.nav_buscar_piso){
                cargarPisos(recyclerView);
            }

        }

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        actualizarDatos();
                        swipe.setRefreshing(false);
                    }
                }, 3000);
            }


        });

        return view;
    }

    public void cargarPisosFavoritos(final RecyclerView recyclerView) {
        UserService userService = ServiceGenerator.createService(UserService.class, Util.getToken(this.getActivity()), TipoAutenticacion.JWT);
        Call<UserResponse> call = userService.userById(Util.getUserId(this.getActivity()));

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    adapter = new MyPisosRecyclerViewAdapter(ctx, R.layout.fragment_pisos, response.body().getPisosFavoritos(), mListener);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void cargarMisPisosAnunciados(final RecyclerView recyclerView) {
        UserService userService = ServiceGenerator.createService(UserService.class, Util.getToken(this.getActivity()), TipoAutenticacion.JWT);
        Call<UserResponse> call = userService.userById(Util.getUserId(this.getActivity()));

        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    adapter = new MyPisosRecyclerViewAdapter(ctx, R.layout.fragment_pisos, response.body().getPisosAnuncios(), mListener);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void cargarPisos(final RecyclerView recyclerView) {
        PisoService pisoService = ServiceGenerator.createService(PisoService.class, Util.getToken(this.getActivity()), TipoAutenticacion.JWT);
        Call<List<Piso>> call = pisoService.getPisos();

        call.enqueue(new Callback<List<Piso>>() {
            @Override
            public void onResponse(Call<List<Piso>> call, Response<List<Piso>> response) {
                if (response.isSuccessful()) {
                    adapter = new MyPisosRecyclerViewAdapter(ctx, R.layout.fragment_pisos, response.body(), mListener);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Piso>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListPisosInteractionListener) {
            mListener = (OnListPisosInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void actualizarDatos(){
        cargarPisosFavoritos(recyclerView);
        cargarMisPisosAnunciados(recyclerView);
    }

}
