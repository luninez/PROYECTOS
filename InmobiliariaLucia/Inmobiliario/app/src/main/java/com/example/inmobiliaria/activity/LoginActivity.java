package com.example.inmobiliaria.activity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inmobiliaria.Retrofit.Generator.ServiceGenerator;
import com.example.inmobiliaria.Retrofit.Responses.AuthoRegisterResponse;
import com.example.inmobiliaria.Retrofit.Services.AuthoRegisterService;
import com.example.inmobiliaria.Retrofit.Util;
import com.example.inmobiliaria.R;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button btnLogin, btnRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        email = findViewById(R.id.emailLogin);
        password = findViewById(R.id.passwordLogin);

        btnLogin = findViewById(R.id.btnLogin);
        btnRegistrar = findViewById(R.id.btnLoginRegistro);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegistroActivity.class));
            }
        });

        doLogin();
    }

    public void onLoginSuccess(Call<AuthoRegisterResponse> call, Response<AuthoRegisterResponse> response) {
        Util.setData(LoginActivity.this, response.body().getToken(), response.body().getUser());

        startActivity(new Intent(LoginActivity.this, DashboardActivity.class));
        finish();
    }

    public final void onLoginFail() {
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

        builder.setIcon(R.drawable.ic_cancel);
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });

        builder.setMessage(R.string.login_error)
                .setTitle(R.string.error);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void doLogin() {

        btnLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Comprobando...");
                progressDialog.show();

                String emailTxt = email.getText().toString();
                String passwordTxt = password.getText().toString();

                String credentials = Credentials.basic(emailTxt, passwordTxt);

                AuthoRegisterService loginService = ServiceGenerator.createService(AuthoRegisterService.class);

                Call<AuthoRegisterResponse> call = loginService.login(credentials);
                call.enqueue(new Callback<AuthoRegisterResponse>() {
                    @Override
                    public void onResponse(final Call<AuthoRegisterResponse> call, final Response<AuthoRegisterResponse> response) {
                        if (response.isSuccessful()) {
                            Runnable progressRunnable = new Runnable() {
                                @Override
                                public void run() {
                                    progressDialog.cancel();
                                    onLoginSuccess(call, response);
                                }
                            };

                            Handler pdCanceller = new Handler();
                            pdCanceller.postDelayed(progressRunnable, 2000);
                        } else {
                            progressDialog.cancel();
                            onLoginFail();
                        }
                    }

                    @Override
                    public void onFailure(Call<AuthoRegisterResponse> call, Throwable t) {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}

