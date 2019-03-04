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
import com.example.inmobiliaria.models.Property;
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

        title = view.findViewById(R.id.piso_add_title);
        description = view.findViewById(R.id.piso_add_description);
        price = view.findViewById(R.id.piso_add_price);
        rooms = view.findViewById(R.id.piso_add_rooms);
        size = view.findViewById(R.id.piso_add_size);
        categoryID = view.findViewById(R.id.piso_add_spinner_category);
        address = view.findViewById(R.id.piso_add_address);
        zipCode = view.findViewById(R.id.piso_add_zipCode);
        city = view.findViewById(R.id.piso_add_city);
        province = view.findViewById(R.id.piso_add_province);
        loc = view.findViewById(R.id.piso_add_loc);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Añadir piso")
                .setPositiveButton("Añadir", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        String titleAdd = title.getText().toString();
                        String descriptionAdd = description.getText().toString();
                        int priceAdd = Integer.parseInt(price.getText().toString());
                        int roomsAdd = Integer.parseInt(rooms.getText().toString());
                        int sizeAdd = Integer.parseInt(size.getText().toString());
                        String categoryAdd = categoryID.getText().toString();
                        String addressAdd = address.getText().toString();
                        String zipCodeAdd = zipCode.getText().toString();
                        String cityAdd = city.getText().toString();
                        String provinceAdd = province.getText().toString();
                        String locAdd = loc.getText().toString();

                        Property property = new Property(titleAdd, descriptionAdd, priceAdd, roomsAdd, sizeAdd, categoryAdd, addressAdd, zipCodeAdd, provinceAdd, cityAdd, locAdd);
                        mViewModel.addPiso(property, dialog);

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
