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

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.adapter.MyPisosRecyclerViewAdapter;
import com.example.inmobiliaria.lisener.OnListPisosInteractionListener;

public class PisosFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private OnListPisosInteractionListener mListener;
    private MyPisosRecyclerViewAdapter adapter;
    private Context ctx;
    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipe;

    public PisosFragment() { }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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


    public void cargarDatos(final RecyclerView recyclerView) {
//        UserService userService = ServiceGenerator.createService(UserService.class, Util.getToken(this.getActivity()), TipoAutenticacion.JWT);
//        Call<OneUserResponse> call = userService.oneUserById(Util.getUserId(this.getActivity()));
//
//        call.enqueue(new Callback<OneUserResponse>() {
//            @Override
//            public void onResponse(Call<OneUserResponse> call, Response<OneUserResponse> response) {
//                if (response.isSuccessful()) {
//                    adapter = new MyPersonasRecyclerViewAdapter(ctx, R.layout.fragment_personas, response.body().getPersonas(), mListener);
//                    recyclerView.setAdapter(adapter);
//                } else {
//                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<OneUserResponse> call, Throwable t) {
//
//
//                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
//            }
//        });
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
        cargarDatos(recyclerView);
    }

}
