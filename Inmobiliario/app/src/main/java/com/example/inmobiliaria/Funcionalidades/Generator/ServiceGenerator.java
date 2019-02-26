package com.example.inmobiliaria.Funcionalidades.Generator;

import com.example.inmobiliaria.Enum.TipoAutenticacion;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL = "";
    private static final String MASTER_KEY = " ";

    public static String jwToken = null;

    public static Retrofit.Builder builder = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = null;
    private static TipoAutenticacion tipoActual = null;
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    private static OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

    public static <S> S createService (Class<S> serviceClass) {
        return createService(serviceClass, null, TipoAutenticacion.SIN_AUTENTICACION);
    }

    public static <S> S createService(Class<S> serviceClass, String userName, String userPassword){
        if(!(userName.isEmpty() || userPassword.isEmpty())){
            String credentials = Credentials.basic(userName, userPassword);
            return createService(serviceClass, credentials, TipoAutenticacion.BASIC);
        }
        return createService(serviceClass, null, TipoAutenticacion.SIN_AUTENTICACION);
    }

    public static <S> S createService(Class<S> serviceClass, final String authToken, final TipoAutenticacion tipo){
        if (retrofit == null || tipoActual != tipo) {
            clientBuilder.interceptors().clear();
            clientBuilder.addInterceptor(loggingInterceptor);
            clientBuilder.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    Request request = original.newBuilder()
                            .header("User-Agent", "InmobiliariaApi")
                            .header("Accept", "application/json")
                            .method(original.method(), original.body())
                            .build();
                    return chain.proceed(request);
                }
            });

            if (tipo == TipoAutenticacion.SIN_AUTENTICACION || tipo == TipoAutenticacion.BASIC){
                clientBuilder.addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request original = chain.request();
                        HttpUrl originalUrl = original.url();

                        HttpUrl url = originalUrl.newBuilder()
                                .addQueryParameter("access_token", MASTER_KEY)
                                .build();

                        Request request = original.newBuilder()
                                .url(url)
                                .build();
                        return chain.proceed(request);
                    }
                });
            }

            if (authToken != null){
               clientBuilder.addInterceptor(new Interceptor() {
                   @Override
                   public Response intercept(Chain chain) throws IOException {
                       Request original = chain.request();

                       String token = null;

                       if (tipo == TipoAutenticacion.JWT && !authToken.startsWith("Bearer ")) {
                           token = "Bearer " + authToken;
                       }else{
                           token = authToken;
                       }

                       Request request = original.newBuilder()
                               .header("Authorization", token)
                               .build();

                       return chain.proceed(request);
                   }
               });
            }
            tipoActual = tipo;

            builder.client(clientBuilder.build());
            retrofit = builder.build();
        }
        return retrofit.create(serviceClass);
    }

}
