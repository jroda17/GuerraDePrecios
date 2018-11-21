package com.example.alumno.guerra_de_precios;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigation();

    }

    private void initNavigation() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabPrincipal = (FloatingActionButton) findViewById(R.id.fab_filter);

        fabPrincipal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();

                //animacion del fab que despliega
                Animation animRotate = android.view.animation.AnimationUtils.loadAnimation(view.getContext(),  R.anim.rotate_clockwise);
                animRotate.setDuration(100L);
                view.startAnimation(animRotate);

                //obtengo los botones
                final FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.fab_worse);
                final FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab_best);

                //muestro los botones
                if (fab1.getVisibility() == View.VISIBLE){

                    //animacion de cierre
                    Animation animClose = android.view.animation.AnimationUtils.loadAnimation(fab1.getContext(),  R.anim.fab_close);
                    animClose.setDuration(250L);
                    fab1.startAnimation(animClose);
                    fab2.startAnimation(animClose);

                    fab1.setVisibility(View.INVISIBLE);
                    fab2.setVisibility(View.INVISIBLE);
                }else{

                    //animacion de apertura
                    Animation animOpen = android.view.animation.AnimationUtils.loadAnimation(fab1.getContext(),  R.anim.fab_open);
                    animOpen.setDuration(300L);
                    fab1.startAnimation(animOpen);
                    fab2.startAnimation(animOpen);

                    fab1.setVisibility(View.VISIBLE);
                    fab2.setVisibility(View.VISIBLE);
                }

                //onlick para que se oculten los botones
                View noButtonZone = findViewById(R.id.no_button_zone);
                noButtonZone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Animation animClose = android.view.animation.AnimationUtils.loadAnimation(fab1.getContext(),  R.anim.fab_close);
                        animClose.setDuration(250L);
                        fab1.startAnimation(animClose);
                        fab2.startAnimation(animClose);

                        fab1.setVisibility(View.INVISIBLE);
                        fab2.setVisibility(View.INVISIBLE);
                    }
                });

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            //hacer algo aca?
            return true;
        } else if (id == R.id.action_close_session) {

            //esto listo
            cerrarSesion();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_places) {
            // Handle the camera action
        } else if (id == R.id.nav_new_place) {

        } else if (id == R.id.nav_map) {

        } else if (id == R.id.nav_help) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void cerrarSesion() {
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
        sharedPreferences.edit().clear().commit();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        MainActivity.this.startActivity(intent);
        MainActivity.this.finish();
    }
}