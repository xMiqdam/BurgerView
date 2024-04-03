package com.example.burgerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.burgerview.Liga.LigaIngrris;
import com.example.burgerview.Liga.LigaItalia;
import com.example.burgerview.Liga.ligaspanyol;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

      showLigaInggris();

        drawerLayout = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.open_drawer, R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.ligaInggris) {
                    showLigaInggris();
                } else if (itemId == R.id.ligaSpanyol) {
                    showLigaSpanyol();
                }else if (itemId == R.id.ligaitalia) {
                    showLigaItalia();
                } else{
                  showProfile();
                }


                drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    private void showLigaInggris() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new LigaIngrris())
                .commit();

        getSupportActionBar().setTitle("Liga Inggris");
    }
    private void showLigaSpanyol() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new ligaspanyol())
                .commit();

        getSupportActionBar().setTitle("Liga Spanyol");
    }
    private void showLigaItalia() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new LigaItalia())
                .commit();

        getSupportActionBar().setTitle("Liga Italia");
    }

    private void showProfile() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, new profile())
                .commit();

        getSupportActionBar().setTitle("Profile");
    }

}
