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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inmobiliaria.Enum.TipoAutenticacion;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.Retrofit.Generator.ServiceGenerator;
import com.example.inmobiliaria.Retrofit.Responses.ResponseContainer;
import com.example.inmobiliaria.Retrofit.Services.CategoryService;
import com.example.inmobiliaria.Retrofit.Util;
import com.example.inmobiliaria.models.Category;
import com.example.inmobiliaria.models.Property;
import com.example.inmobiliaria.viewModel.EditPisoViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPiso extends DialogFragment {

    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";
    private static final String ARG_PRICE = "price";
    private static final String ARG_ROOMS = "rooms";
    private static final String ARG_SIZE = "size";
    private static final String ARG_ADDRESS = "address";
    private static final String ARG_CITY = "city";
    private static final String ARG_ZIPCODE = "zipCode";
    private static final String ARG_CATEGORYID = "categoryId";
    private static final String ARG_PROVINCE = "province";
    private static final String ARG_LOC = "loc";
    private static final String ARG_ID_PISO = "id_piso";
    private EditPisoViewModel mViewModel;

    private DialogInterface.OnDismissListener onDismissListener;

    private View view;
    private EditText title, description, price, rooms, size, address, city, zipCode, categoryId, province, loc;
    private String argid, argtitle, argdescription, argprice, argrooms, argsize, argaddress, argcity, argzipCode, argcategoryId, argprovince, argloc;

    private Spinner spinnerPisos;
    private ArrayAdapter<String> categorias;
    private List<Category> listcategory;
    private List<String> lista;

    public void setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        this.onDismissListener = onDismissListener;
    }

    public static EditPiso newInstance() {
        return new EditPiso();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(EditPisoViewModel.class);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            argid = getArguments().getString(ARG_ID_PISO);
            argtitle = getArguments().getString(ARG_TITLE);
            argdescription = getArguments().getString(ARG_DESCRIPTION);
            argprice = getArguments().getString(ARG_PRICE);
            argrooms = getArguments().getString(ARG_ROOMS);
            argsize = getArguments().getString(ARG_SIZE);
            argcategoryId = getArguments().getString(ARG_CATEGORYID);
            argaddress = getArguments().getString(ARG_ADDRESS);
            argcity = getArguments().getString(ARG_CITY);
            argprovince = getArguments().getString(ARG_PROVINCE);
            argzipCode = getArguments().getString(ARG_ZIPCODE);
            argloc = getArguments().getString(ARG_LOC);
        }
    }

    public static EditPiso newInstance(Property p) {
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, p.getTitle());
        args.putString(ARG_DESCRIPTION, p.getDescription());
        args.putString(ARG_PRICE, Double.toString(p.getPrice()));
        args.putString(ARG_ROOMS, Integer.toString(p.getRooms()));
        args.putString(ARG_SIZE, Double.toString(p.getSize()));
        args.putString(ARG_CATEGORYID, p.getCategoryId());
        args.putString(ARG_ADDRESS, p.getAddress());
        args.putString(ARG_PROVINCE, p.getProvince());
        args.putString(ARG_ZIPCODE, p.getZipCode());
        args.putString(ARG_CITY, p.getCity());
        args.putString(ARG_LOC, p.getLoc());

        EditPiso fragment = new EditPiso();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        LayoutInflater inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.edit_piso_fragment, null);

        title = view.findViewById(R.id.piso_edit_title);
        description = view.findViewById(R.id.piso_edit_description);
        price = view.findViewById(R.id.piso_edit_price);
        rooms = view.findViewById(R.id.piso_edit_rooms);
        size = view.findViewById(R.id.piso_edit_size);
        categoryId = view.findViewById(R.id.piso_edit_spinner_category);
        address = view.findViewById(R.id.piso_edit_address);
        province = view.findViewById(R.id.piso_edit_province);
        zipCode = view.findViewById(R.id.piso_edit_zipCode);
        city = view.findViewById(R.id.piso_edit_city);
        loc = view.findViewById(R.id.piso_edit_loc);

        spinnerPisos = view.findViewById(R.id.piso_edit_spinner_category);

        title.setText(argtitle);
        description.setText(argdescription);
        price.setText(argprice);
        rooms.setText(argrooms);
        size.setText(argsize);
        categoryId.setText(argcategoryId);
        address.setText(argaddress);
        province.setText(argprovince);
        zipCode.setText(argzipCode);
        city.setText(argcity);
        loc.setText(argloc);

        cargarSpinner();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage("Editar persona: ")

                .setPositiveButton(R.string.edit, new DialogInterface.OnClickListener() {

                    public void onClick(final DialogInterface dialog, int id) {

                        Property property = new Property(title.getText().toString(),
                                description.getText().toString(),
                                Double.parseDouble(price.getText().toString()),
                                Integer.parseInt(rooms.getText().toString()),
                                Double.parseDouble(size.getText().toString()),
                                categoryId.getText().toString(),
                                address.getText().toString(),
                                zipCode.getText().toString(),
                                city.getText().toString(),
                                province.getText().toString(),
                                loc.getText().toString()
                                );
                        mViewModel.editProperty(property,argid, dialog);
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

    public void cargarSpinner() {

        CategoryService categoryService = ServiceGenerator.createService(CategoryService.class, Util.getToken(this.getActivity()), TipoAutenticacion.JWT);
        Call<ResponseContainer<Category>> call = categoryService.getOne(Util.getUserId(getActivity()));

        call.enqueue(new Callback<ResponseContainer<Category>>() {
            @Override
            public void onResponse(Call<ResponseContainer<Category>> call, Response<ResponseContainer<Category>> response) {
                if (response.isSuccessful()) {

                    listcategory = response.body().getRows();

                    // listcategory.add("Categorias");
                    for (int i=0;i<listcategory.size();i++){
                        lista.add(listcategory.get(i).getName());
                    }

                    categorias = new ArrayAdapter<>(getContext(),android.R.layout.simple_spinner_item, lista);
                    categorias.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

                } else {
                    Toast.makeText(getContext(), "Error al obtener datos", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseContainer<Category>> call, Throwable t) {

                Toast.makeText(getContext(), "Error de conexión", Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

}
