package com.example.inmobiliaria.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.inmobiliaria.Retrofit.Generator.ServiceGenerator;
import com.example.inmobiliaria.Retrofit.Services.PropertyService;
import com.example.inmobiliaria.models.Property;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPisoViewModel extends AndroidViewModel {
    public AddPisoViewModel(@NonNull Application application){
        super(application);
    }

    public void addPiso(Property property, final DialogInterface dialog){
        PropertyService propertyService = ServiceGenerator.createService(PropertyService.class);
        Call<Property> call = propertyService.create(property);

        call.enqueue(new Callback<Property>() {
            @Override
            public void onResponse(Call<Property> call, Response<Property> response) {
                if(response.isSuccessful()){
                    dialog.dismiss();
                }else{
                    Toast.makeText(getApplication().getApplicationContext(), "Error al añadir", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Property> call, Throwable t) {
                Toast.makeText(getApplication().getApplicationContext(), "Error de conexcion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
