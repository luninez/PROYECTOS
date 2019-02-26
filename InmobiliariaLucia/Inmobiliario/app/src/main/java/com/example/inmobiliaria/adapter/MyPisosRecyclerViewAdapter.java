package com.example.inmobiliaria.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.lisener.OnListPisosInteractionListener;
import com.example.inmobiliaria.models.Piso;

import java.util.List;

public class MyPisosRecyclerViewAdapter extends RecyclerView.Adapter<MyPisosRecyclerViewAdapter.ViewHolder> {

    private final List<Piso> mValues;
    private final OnListPisosInteractionListener mListener;
    private Context ctx;

    public MyPisosRecyclerViewAdapter(Context ctx, int layout, List<Piso> items, OnListPisosInteractionListener listener) {
        mValues = items;
        mListener = listener;
        this.ctx = ctx;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_pisos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.direccion.setText(holder.mItem.getAddress());
        holder.precio.setText(String.valueOf(holder.mItem.getPrice()));
        holder.habitaciones.setText(holder.mItem.getRooms());
        holder.mCuadrados.setText(String.valueOf(holder.mItem.getSize()));

        //Click favorite
        holder.btnFav.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.onFavoritePisoClick(holder.mItem);
            }
        });

        //Click llamar
        holder.btnCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.onCallPisoClick(holder.mItem);
            }
        });

        //Click info
        holder.btnInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mListener.onInfoPisoClick(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView direccion;
        public final TextView precio;
        public final TextView habitaciones;
        public final TextView mCuadrados;
        public final ImageView btnFav;
        public final ImageView btnCall;
        public final ImageView btnInfo;
        public Piso mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            direccion = view.findViewById(R.id.piso_item_direccion);
            precio = view.findViewById(R.id.piso_item_precio);
            habitaciones = view.findViewById(R.id.piso_item_habitaciones);
            mCuadrados = view.findViewById(R.id.piso_item_mcuadrados);

            btnFav = view.findViewById(R.id.btn_favorite);
            btnCall = view.findViewById(R.id.btn_call);
            btnInfo = view.findViewById(R.id.btn_info);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + direccion.getText() + "'";
        }
    }
}
