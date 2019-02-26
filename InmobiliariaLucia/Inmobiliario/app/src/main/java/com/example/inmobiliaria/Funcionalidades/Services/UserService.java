package com.example.inmobiliaria.Funcionalidades.Services;

import com.example.inmobiliaria.Funcionalidades.Responses.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("users/{id")
    Call<UserResponse> userById(@Path("id") String id);

}
