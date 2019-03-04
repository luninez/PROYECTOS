package com.example.inmobiliaria.Retrofit.Services;

import com.example.inmobiliaria.Retrofit.Responses.ResponseContainer;
import com.example.inmobiliaria.models.Category;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CategoryService {

    final String BASE_URL = "/categories";

    @GET(BASE_URL)
    Call<ResponseContainer<Category>> listCategories();

    @GET(BASE_URL+"/{id}")
    Call<Category> getOne(@Path("id") String id);

}
