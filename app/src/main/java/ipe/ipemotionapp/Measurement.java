package ipe.ipemotionapp;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class Measurement extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Button change;
    private UiModeManager uiModeManager;
    private ActionBar supportActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurement);

        if(savedInstanceState == null) {
            Log.d("CLICK", "@@@@ MODE_NIGHT_AUTO");
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if(toolbar != null)
            toolbar.setNavigationIcon(R.mipmap.ic_launcher);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        uiModeManager = (UiModeManager)getSystemService(Context.UI_MODE_SERVICE);
        if(uiModeManager != null) {
            int mode = uiModeManager.getNightMode();
            switch (mode) {
                case UiModeManager.MODE_NIGHT_YES:
                    Log.d("MEASUR", "@@@@ MODE_NIGHT_YES");
                    break;
                case UiModeManager.MODE_NIGHT_NO:
                    Log.d("MEASUR", "@@@@ MODE_NIGHT_NO");
                    break;

                case UiModeManager.MODE_NIGHT_AUTO:
                    Log.d("MEASUR", "@@@@ MODE_NIGHT_AUTO");
                    break;
            }
        }
        change = (Button) findViewById(R.id.button);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(uiModeManager != null) {
                   int mode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
                    switch (mode) {
                        case Configuration.UI_MODE_NIGHT_NO:
                            Log.d("CLICK", "@@@@ UI_MODE_NIGHT_NO");
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            recreate();
                            break;
                        case Configuration.UI_MODE_NIGHT_YES:
                            Log.d("CLICK", "@@@@ UI_MODE_NIGHT_YES");
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            recreate();
                            break;

                        case Configuration.UI_MODE_NIGHT_UNDEFINED:
                            Log.d("CLICK", "@@@@ UI_MODE_NIGHT_UNDEFINED");
                            break;
                    }
                }

                //uiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);


            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d("CLICK", "@@@@ onConfigurationChanged");
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
        getMenuInflater().inflate(R.menu.measurement, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CLICK", "@@@@ onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CLICK", "@@@@ onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CLICK", "@@@@ onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CLICK", "@@@@ onDestroy");
    }
}
