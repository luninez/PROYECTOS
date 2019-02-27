package com.example.inmobiliaria.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.example.inmobiliaria.Funcionalidades.Generator.ServiceGenerator;
import com.example.inmobiliaria.Funcionalidades.Services.PisoService;
import com.example.inmobiliaria.models.Piso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddPisoViewModel extends AndroidViewModel {
    public AddPisoViewModel(@NonNull Application application){
        super(application);
    }

    public void addPiso(Piso piso, final DialogInterface dialog){
        PisoService pisoService = ServiceGenerator.createService(PisoService.class);
        Call<Piso> call = pisoService.addOne(piso);

        call.enqueue(new Callback<Piso>() {
            @Override
            public void onResponse(Call<Piso> call, Response<Piso> response) {
                if(response.isSuccessful()){
                    dialog.dismiss();
                }else{
                    Toast.makeText(getApplication().getApplicationContext(), "Error al añadir", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Piso> call, Throwable t) {
                Toast.makeText(getApplication().getApplicationContext(), "Error de conexcion", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
