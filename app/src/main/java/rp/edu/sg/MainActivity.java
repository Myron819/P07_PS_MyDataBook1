package rp.edu.sg;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    // TODO: Task 1 - Implementing ListView in Navigation Drawer | by Myron
    static String[] drawerItems;
    static DrawerLayout drawerLayout;
    static ListView drawerList;
    ArrayAdapter<String> aa;
    String currentTitle;
    ActionBar ab;
    static ActionBarDrawerToggle drawerToggle;

    // TODO: Task 1 - Implementing ListView in Navigation Drawer | by Myron
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);

        drawerItems = new String[]{"Biography", "Vaccination", "Anniversary", "About Us"};
        ab = getSupportActionBar();

        aa = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1, drawerItems);
        drawerList.setAdapter(aa);

        // Set the list's click listener
        drawerList.setOnItemClickListener((arg0, arg1, position, arg3) -> {

            Fragment fragment = null;
            String msg = "";
            switch (position) {

                case 0:
                    fragment = new BiographyFragment();
                    break;

                case 1:
                    fragment = new VaccinationFragment();
                    break;

                case 2:
                    fragment = new AnniversaryFragment();
                    break;

                case 3:
                    fragment = new AboutUsFragment();

                    break;
            }

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction trans = fm.beginTransaction();
            assert fragment != null;
            trans.replace(R.id.content_frame, fragment);
            trans.commit();

            // Highlight the selected item,
            //  update the title, and close the drawer
            drawerList.setItemChecked(position, true);
            currentTitle = drawerItems[position];
            ab.setTitle(currentTitle);
            drawerLayout.closeDrawer(drawerList);
        });

        //ToDo Opening and Closing Drawer with ActionBar Title. Done by Zuhaili
        currentTitle = this.getTitle().toString();

        drawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout,      /* DrawerLayout object */
                R.string.drawer_open, /* "open drawer" description */
                R.string.drawer_close /* "close drawer" description */
        ) {

            /** Would be called when a drawer has completely closed */
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                ab.setTitle(currentTitle);
            }

            /** Would be called when a drawer has completely open */
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ab.setTitle("Make a selection");
            }
        };

        // Set the drawer toggle as the DrawerListener
        drawerLayout.addDrawerListener(drawerToggle);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync toggle state so the indicator is shown properly.
        //  Have to call in onPostCreate()
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
