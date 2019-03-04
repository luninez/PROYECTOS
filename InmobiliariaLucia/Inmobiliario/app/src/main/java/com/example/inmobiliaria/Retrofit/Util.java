package com.example.inmobiliaria.Retrofit;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.constraint.ConstraintLayout;

import com.example.inmobiliaria.models.User;

public class Util {

    public static void setData(Context ctx, String token, User user){

        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("token", token);
        editor.putString("idUser", user.getId());
        editor.putString("emailUser", user.getEmail());
        editor.putString("nombreUser", user.getName());
        editor.putString("fotoUser", user.getPicture());
        editor.commit();
    }

    public static String getToken(Context ctx){
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("token", null);
    }

    public static String getUser(Context ctx){
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("user", null);
    }

    public static String getUserId(Context ctx){
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("idUser", null);
    }

    public static String getEmailUser(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("emailUser", null);

    }

    public static String getNombreUser(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("nombreUser",null);
    }

    public static String getRole(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("roleUser",null);
    }

    public static String getPhotoUser(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        return prefs.getString("fotoUser", null);
    }

    public static void clearSharedPreferences(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
    }

}
