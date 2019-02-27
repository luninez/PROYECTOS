package com.example.inmobiliaria.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.inmobiliaria.Funcionalidades.Util;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.dialog.AddPiso;
import com.example.inmobiliaria.fragment.PisosFragment;
import com.example.inmobiliaria.lisener.OnListPisosInteractionListener;
import com.example.inmobiliaria.models.Piso;

public class DashboardActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, OnListPisosInteractionListener {

    private Fragment f;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.nav_view);

        toolbar = findViewById(R.id.toolbar);
        fab = findViewById(R.id.fab);

        toolbar.setTitle("Pisos");
        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor, new PisosFragment(), "pisosFragment")
                .commit();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddPiso f = AddPiso.newInstance();
                f.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("mainFragment");
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.detach(currentFragment);
                        fragmentTransaction.attach(currentFragment);
                        fragmentTransaction.commit();
                    }
                });
                FragmentManager fm = getSupportFragmentManager();
                f.show(fm, "AñadirPiso");
            }
        });

        navigationView.setNavigationItemSelectedListener(this);
        ocultarItemMenu();
        mostrarInfoUsuarioMenu();
    }

    public void ocultarItemMenu() {
        Menu items = navigationView.getMenu();
        if (Util.getToken(DashboardActivity.this) == null) {
            items.findItem(R.id.nav_pisos_favoritos).setVisible(false);
            items.findItem(R.id.nav_poner_anuncio).setVisible(false);
            items.findItem(R.id.nav_mis_anuncios).setVisible(false);
            items.findItem(R.id.nav_logout).setVisible(false);
            items.findItem(R.id.nav_perfil);
        } else {
            items.findItem(R.id.nav_login).setVisible(false);
        }
    }

    public void mostrarInfoUsuarioMenu() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        View headerView = navigationView.getHeaderView(0);

        ImageView imageView = headerView.findViewById(R.id.picture);
        TextView name = headerView.findViewById(R.id.userName);
        TextView email = headerView.findViewById(R.id.userEmail);

        name.setText(Util.getNombreUser(DashboardActivity.this));
        email.setText(Util.getEmailUser(DashboardActivity.this));

        Glide.with(this).load(Util.getPhotoUser(DashboardActivity.this)).apply(RequestOptions.circleCropTransform()).into(imageView);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        f = null;

        if (id == R.id.nav_login) {

            fab.hide();
            toolbar.setTitle("Iniciar Sesión");
            startActivity(new Intent(DashboardActivity.this, LoginActivity.class));
            finish();

        } else if (id == R.id.nav_perfil) {

            fab.hide();
            toolbar.setTitle("Perfil");
            startActivity(new Intent(DashboardActivity.this, InfoPerfilActivity.class));
            finish();

        } else if (id == R.id.nav_poner_anuncio) {

            fab.hide();
            toolbar.setTitle("Publicar anuncio");
            Toast.makeText(this, "AUN NO", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_mapa) {

            fab.hide();
            toolbar.setTitle("Mapa");
            Toast.makeText(this, "AUN NO", Toast.LENGTH_SHORT).show();

        } else if (id == R.id.nav_logout) {
            Util.clearSharedPreferences(DashboardActivity.this);

            Intent i = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(i);
            finish();

        } else {
            f = new PisosFragment();
            ((PisosFragment) f).setTipoPeticion(id);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        if (f != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, f, "pisosFragment").commit();
            return true;
        }

        return true;
    }

    //METODOS ONCLICK LISTA DE PISOS

    @Override
    public void onFavoritePisoClick(Piso p) {

    }

    @Override
    public void onCallPisoClick(Piso p) {

    }

    @Override
    public void onInfoPisoClick(Piso p) {

    }

    @Override
    public void onEditPisoClick(Piso p) {

    }

    @Override
    public void onAddPsioClick(Piso p) {

    }

    @Override
    public void onDeletePisoClick(Piso p) {

    }
}
