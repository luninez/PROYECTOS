package com.example.inmobiliaria.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inmobiliaria.Funcionalidades.Generator.ServiceGenerator;
import com.example.inmobiliaria.Funcionalidades.Responses.AuthoRegisterResponse;
import com.example.inmobiliaria.Funcionalidades.Services.AuthoRegisterService;
import com.example.inmobiliaria.Funcionalidades.Util;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.models.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {

    private EditText nombre, email, contrasenia, comprobacionContrasenia;
    private Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        nombre = findViewById(R.id.nombreRegistro);
        email = findViewById(R.id.emailRegistro);
        contrasenia = findViewById(R.id.passwordRegsitro);
        comprobacionContrasenia = findViewById(R.id.comprobacionPasswordRegistro);

        btnRegistro = findViewById(R.id.btnRegistro);

        doRegister();

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistroActivity.this, RegistroActivity.class));
            }
        });

    }

    public void onRegisterSuccess(Call<AuthoRegisterResponse> call, Response<AuthoRegisterResponse> response) {
        Util.setData(RegistroActivity.this, response.body().getToken(), response.body().getUser());

        startActivity(new Intent(RegistroActivity.this, MainActivity.class));
        finish();
    }

    public void onRegisterFail(int tipoError) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistroActivity.this);

        builder.setIcon(R.drawable.ic_cancel);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.setMessage(tipoError)
                .setTitle(R.string.error);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void doRegister() {

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(RegistroActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Registrando...");
                progressDialog.show();

                String name = nombre.getText().toString().trim();
                String correo = email.getText().toString().trim();
                String password = contrasenia.getText().toString().trim();
                String comprobacionPassword = comprobacionContrasenia.getText().toString().trim();

                if(password.length() < 6){
                    onRegisterFail(R.string.register_contraseña_no_segura);
                }

                if(!password.equals(comprobacionPassword)){
                    onRegisterFail(R.string.register_contraseña_incorrecta);
                }
            }
        });
    }

    public void crearUsuarioNuevo(Register registro, final ProgressDialog progressDialog){
        AuthoRegisterService service = ServiceGenerator.createService(AuthoRegisterService.class);

        Call<AuthoRegisterResponse> registerResponseCall = service.register(registro);

        registerResponseCall.enqueue(new Callback<AuthoRegisterResponse>() {

            @Override
            public void onResponse(Call<AuthoRegisterResponse> call, Response<AuthoRegisterResponse> response) {

                if (response.isSuccessful()) {
                    progressDialog.dismiss();
                    onRegisterSuccess(call, response);

                } else {
                    progressDialog.dismiss();
                    onRegisterFail(R.string.error);
                }
            }

            @Override
            public void onFailure(Call<AuthoRegisterResponse> call, Throwable t) {
                Log.e("NetworkFail", t.getMessage());
                Toast.makeText(RegistroActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
            }
        });
    }

}