package com.example.inmobiliaria.fragment;

import android.annotation.SuppressLint;
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
import com.example.inmobiliaria.Retrofit.Generator.ServiceGenerator;
import com.example.inmobiliaria.Retrofit.Responses.ResponseContainer;
import com.example.inmobiliaria.Retrofit.Responses.UserResponse;
import com.example.inmobiliaria.Retrofit.Services.PropertyService;
import com.example.inmobiliaria.Retrofit.Services.UserService;
import com.example.inmobiliaria.Retrofit.Util;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapter.MyPisosRecyclerViewAdapter;
import com.example.inmobiliaria.lisener.OnListPisosInteractionListener;
import com.example.inmobiliaria.models.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListPisosInteractionListener mListener;
    private MyPisosRecyclerViewAdapter adapter;
    private Context ctx;
    private List<Property> properties = new ArrayList<>();
    Property property;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipe;
    Map<String, String> options = new HashMap<>();

    private int tipoPeticion;

    private UserResponse userResponse;



    public PropertyFragment() { }

    public void setTipoPeticion(int tipoPeticion){
        this.tipoPeticion = tipoPeticion;
    }

    @SuppressLint("ValidFragment")
    public PropertyFragment(Map<String,String> options){
        this.options = options;
    }

    public static PropertyFragment newInstance(int columnCount) {
        PropertyFragment fragment = new PropertyFragment();
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

            options.put("near", "-6.0071807999999995,37.3803677");
            options.put("max_distance","1000000000000");

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
        PropertyService propertyService = ServiceGenerator.createService(PropertyService.class, Util.getToken(this.getActivity()), TipoAutenticacion.JWT);
        Call<ResponseContainer<Property>> call = propertyService.listProperties(options);

        call.enqueue(new Callback<ResponseContainer<Property>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Property>> call, Response<ResponseContainer<Property>> response) {
                if (response.isSuccessful()) {
                    adapter = new MyPisosRecyclerViewAdapter(ctx, R.layout.fragment_pisos, response.body().getRows(), mListener);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseContainer<Property>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void cargarMisPisosAnunciados(final RecyclerView recyclerView) {
        PropertyService propertyService = ServiceGenerator.createService(PropertyService.class, Util.getToken(this.getActivity()), TipoAutenticacion.JWT);
        Call<ResponseContainer<Property>> call = propertyService.listProperties(options);

        call.enqueue(new Callback<ResponseContainer<Property>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Property>> call, Response<ResponseContainer<Property>> response) {
                if (response.isSuccessful()) {
                    adapter = new MyPisosRecyclerViewAdapter(ctx, R.layout.fragment_pisos, response.body().getRows(), mListener);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseContainer<Property>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void cargarPisos(final RecyclerView recyclerView) {
        PropertyService propertyService = ServiceGenerator.createService(PropertyService.class);
        Call<ResponseContainer<Property>> call = propertyService.listProperties(options);

        call.enqueue(new Callback<ResponseContainer<Property>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Property>> call, Response<ResponseContainer<Property>> response) {
                if (response.isSuccessful()) {
                    adapter = new MyPisosRecyclerViewAdapter(ctx, R.layout.fragment_pisos, response.body().getRows(), mListener);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseContainer<Property>> call, Throwable t) {
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
