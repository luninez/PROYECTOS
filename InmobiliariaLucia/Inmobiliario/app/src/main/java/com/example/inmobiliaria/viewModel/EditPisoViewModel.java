package com.example.inmobiliaria.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.Toast;

import com.example.inmobiliaria.Enum.TipoAutenticacion;
import com.example.inmobiliaria.Retrofit.Generator.ServiceGenerator;
import com.example.inmobiliaria.Retrofit.Services.PropertyService;
import com.example.inmobiliaria.Retrofit.Util;
import com.example.inmobiliaria.models.Property;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EditPisoViewModel extends AndroidViewModel {

    public EditPisoViewModel(@NonNull Application application) {
        super(application);
    }

    public void editProperty(Property p, String persona_id, final DialogInterface dialog) {
        PropertyService pService = ServiceGenerator.createService(PropertyService.class, Util.getToken(getApplication().getApplicationContext()), TipoAutenticacion.JWT);
        Call<Property> call = pService.edit(persona_id, p);

        call.enqueue(new Callback<Property>() {
            @Override
            public void onResponse(Call<Property> call, Response<Property> response) {
                if (response.isSuccessful()) {
                    dialog.dismiss();
                } else {
                    Toast.makeText(getApplication().getApplicationContext(), "Error al editar", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Property> call, Throwable t) {
                Toast.makeText(getApplication().getApplicationContext(), "Error al editar", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
