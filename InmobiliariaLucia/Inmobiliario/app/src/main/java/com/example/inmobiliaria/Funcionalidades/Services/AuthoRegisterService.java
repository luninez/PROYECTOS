package com.example.inmobiliaria.Funcionalidades.Services;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import com.example.inmobiliaria.Funcionalidades.Responses.AuthoRegisterResponse;
import com.example.inmobiliaria.models.Register;

public interface AuthoRegisterService {

    @POST("/auth")
    Call<AuthoRegisterResponse> login (@Header("Athorization") String authorizacion);

    @POST("/users")
    Call<AuthoRegisterResponse> register(@Body Register registro);
}
