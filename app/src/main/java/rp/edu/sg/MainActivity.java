package rp.edu.sg;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    ActionBar actionBar;
    FloatingActionButton fabMain;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        actionBar = getSupportActionBar();
        fabMain = findViewById(R.id.fabMain);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);

        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(item -> {
            Fragment fragment = null;
            String message = "";


            switch (item.getItemId()) {
                case R.id.menuItemBiography:
                    fragment = new BiographyFragment();
                    message = "Biography";
                    break;
                case R.id.menuItemVaccination:
                    fragment = new VaccinationFragment();
                    message = "Vaccination";
                    break;
                case R.id.menuItemAnniversary:
                    fragment = new AnniversaryFragment();
                    message = "Anniversary";
                    break;
                case R.id.menuItemAboutUs:
                    fragment = new AboutUsFragment();
                    message = "About Us";
                    break;
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            assert fragment != null;
            transaction.replace(R.id.frameLayout, fragment);
            transaction.commit();
            actionBar.setTitle(message);
            drawerLayout.closeDrawers();
            return true;
        });

        //TODO: Floating Button. Done By Zuhaili
        fabMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action
                drawerLayout.openDrawer(navigationView);

            }
        });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}