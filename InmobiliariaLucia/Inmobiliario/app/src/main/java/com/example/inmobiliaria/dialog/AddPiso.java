package com.example.inmobiliaria.dialog;

import android.app.AlertDialog;
import android.app.Application;
import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.inmobiliaria.Enum.TipoAutenticacion;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.Retrofit.Generator.ServiceGenerator;
import com.example.inmobiliaria.Retrofit.Responses.ResponseContainer;
import com.example.inmobiliaria.Retrofit.Services.CategoryService;
import com.example.inmobiliaria.Retrofit.Services.PropertyService;
import com.example.inmobiliaria.Retrofit.Util;
import com.example.inmobiliaria.activity.DashboardActivity;
import com.example.inmobiliaria.models.Category;
import com.example.inmobiliaria.models.Property;
import com.example.inmobiliaria.viewModel.AddPisoViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPiso extends DialogFragment {

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
    private AddPisoViewModel mViewModel;
    private DialogInterface.OnDismissListener onDismissListener;
    private View view;

    private EditText title, description, price, rooms, size, categoryID, address, zipCode, city, province, loc;
    private Spinner spinnerPisos;
    private ArrayAdapter<String> categorias;
    private List<Category> listcategory;
    private List<String> lista;


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

        spinnerPisos = view.findViewById(R.id.piso_add_spinner_category);

        cargarSpinner();

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

    public static AddPiso newInstance(Property p) {
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

        AddPiso fragment = new AddPiso();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        if (onDismissListener != null) {
            onDismissListener.onDismiss(dialog);
        }
    }

}
