package com.example.inmobiliaria.Retrofit.Services;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

import com.example.inmobiliaria.Retrofit.Responses.AuthoRegisterResponse;
import com.example.inmobiliaria.models.Register;

public interface AuthoRegisterService {

    @POST("/auth")
    Call<AuthoRegisterResponse> login (@Header("Authorization") String authorizacion);

    @POST("/users")
    Call<AuthoRegisterResponse> register(@Body Register registro);
}
