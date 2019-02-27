package com.example.inmobiliaria.Funcionalidades.Services;

import com.example.inmobiliaria.Funcionalidades.Responses.UserResponse;
import com.example.inmobiliaria.models.Piso;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PisoService {

    @GET("/property")
    Call<List<Piso>> getPisos();

    @POST("/property")
    Call<Piso> addOne(@Body Piso piso);


}
