package com.example.inmobiliaria.Funcionalidades.Services;

import com.example.inmobiliaria.Funcionalidades.Responses.UserResponse;
import com.example.inmobiliaria.models.Piso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PisoService {

    @GET("/pisos")
    Call<List<Piso>> getPisos();

}
