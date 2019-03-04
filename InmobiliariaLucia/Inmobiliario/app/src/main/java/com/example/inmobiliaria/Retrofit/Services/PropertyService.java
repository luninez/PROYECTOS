package com.example.inmobiliaria.Retrofit.Services;

import com.example.inmobiliaria.Retrofit.Responses.ResponseContainer;
import com.example.inmobiliaria.Retrofit.Responses.ResponseContainerOneRow;
import com.example.inmobiliaria.models.Property;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface PropertyService {

    final String BASE_URL = "/properties";

    @GET(BASE_URL)
    Call<ResponseContainer<Property>> listProperties(@QueryMap Map<String, String> options);

    @GET(BASE_URL+"/auth")
    Call<ResponseContainer<Property>> listPropertiesAuth(@QueryMap Map<String, String> options);

    @GET(BASE_URL)
    Call<ResponseContainer<Property>> listGeo(@Query("near") String near);

    @GET(BASE_URL + "/mine")
    Call<ResponseContainer<Property>> getMine();

    @GET(BASE_URL + "/fav")
    Call<ResponseContainer<Property>> getFavs();

    @GET(BASE_URL + "/{id}")
    Call<ResponseContainerOneRow<Property>>getOne(@Path("id") String id);

    @POST(BASE_URL)
    Call<Property> create (@Body Property property);

    @POST(BASE_URL+"/fav/{id}")
    Call<Property> addFav (@Path("id") String id);

    @PUT(BASE_URL + "/{id}")
    Call<Property> edit(@Path("id") String id, @Body Property edited);

    @DELETE(BASE_URL + "/{id}")
    Call<Property> delete(@Path("id") String id);

    @DELETE(BASE_URL + "/fav/{id}")
    Call<Property> deleteFav(@Path("id") String id);


}
