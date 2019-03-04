package com.example.inmobiliaria.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.viewModel.DeletePisoViewModel;

public class DeletePiso extends DialogFragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_ID_PISO = "piso";
    private DeletePisoViewModel mViewModel;

    private DialogInterface.OnDismissListener onDismissListener;

    private View view;
    private TextView nombre;
    private String argTitle, argIdPiso;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public static DeletePiso newInstance() {
        return new DeletePiso();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DeletePisoViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            argTitle = getArguments().getString(ARG_TITLE);
            argIdPiso = getArguments().getString(ARG_ID_PISO);
        }
    }

    public static DeletePiso newInstance(String id, String nombre) {
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, nombre);
        args.putString(ARG_ID_PISO, id);

        DeletePiso fragment = new DeletePiso();
        fragment.setArguments(args);

        return fragment;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.delete_piso_fragment, null);

        nombre = view.findViewById(R.id.piso_delete_name);

        nombre.setText(argTitle);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Eliminar a: ")

                .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {

                    public void onClick(final DialogInterface dialog, int id) {
                        String nombreEditado = nombre.getText().toString();

                        mViewModel.deletePiso(nombreEditado,argIdPiso, dialog);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });


        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }
}
