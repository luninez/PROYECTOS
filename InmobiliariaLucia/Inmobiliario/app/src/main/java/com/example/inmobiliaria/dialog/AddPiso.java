package com.example.inmobiliaria.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.models.Piso;
import com.example.inmobiliaria.viewModel.AddPisoViewModel;

public class AddPiso extends DialogFragment {

    private AddPisoViewModel mViewModel;
    private DialogInterface.OnDismissListener onDismissListener;
    private View view;

    private EditText title, description, price, rooms, size, categoryID, address, zipCode, city, province, loc;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener){
        this.onDismissListener = onDismissListener;
    }

    public static AddPiso newInstance() {
        return new AddPiso();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddPisoViewModel.class);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.add_piso_fragment, null);

        //Asociar los editText

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Añadir piso")
                .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {

                        Piso piso = new Piso();
                        mViewModel.addPiso(piso, dialog);

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
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
