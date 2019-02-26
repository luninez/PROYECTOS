package com.example.inmobiliaria.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.inmobiliaria.Funcionalidades.Util;
import com.example.inmobiliaria.R;
import com.example.inmobiliaria.fragment.PisosFragment;
import com.example.inmobiliaria.lisener.OnListPisosInteractionListener;
import com.example.inmobiliaria.models.Piso;

public class MainActivity extends AppCompatActivity
  implements NavigationView.OnNavigationItemSelectedListener, OnListPisosInteractionListener {

  private Fragment f;
  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    toolbar = findViewById(R.id.toolbar);

    toolbar.setTitle("Pisos");
    setSupportActionBar(toolbar);

    getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.contenedor, new PisosFragment(), "pisosFragment")
            .commit();

    mostrarInfoUsuarioMenu();
  }

  public void mostrarInfoUsuarioMenu(){
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    View headerView = navigationView.getHeaderView(0);

    ImageView imageView = headerView.findViewById(R.id.picture);
    TextView name = headerView.findViewById(R.id.userName);
    TextView email = headerView.findViewById(R.id.userEmail);

    name.setText(Util.getNombreUser(MainActivity.this));
    email.setText(Util.getEmailUser(MainActivity.this));

    Glide.with(this).load(Util.getPhotoUser(MainActivity.this)).apply(RequestOptions.circleCropTransform()).into(imageView);

  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

    int count = getSupportFragmentManager().getBackStackEntryCount();

    if (count == 0) {
      super.onBackPressed();
    }else{
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
    // Handle navigation view item clicks here.
    int id = item.getItemId();


    if (id == R.id.nav_poner_anuncio) {

      ((PisosFragment) f).setTipoPeticion(id);

    } else if (id == R.id.nav_mapa) {

      ((PisosFragment) f).setTipoPeticion(id);

    } else {
      f = new PisosFragment();
      ((PisosFragment) f).setTipoPeticion(id);
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);

    if(f != null){
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
}
