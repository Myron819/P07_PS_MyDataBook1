package rp.edu.sg;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    // TODO: Task 1 - Implementing ListView in Navigation Drawer | by Myron
    private String[] drawerItems;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    ArrayAdapter<String> aa;
    String currentTitle;
    ActionBar ab;

    // TODO: Task 1 - Implementing ListView in Navigation Drawer | by Myron
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        drawerList = findViewById(R.id.left_drawer);

        drawerItems = new String[]{"Bio", "Vaccination", "Anniversary"};
        ab = getSupportActionBar();

        aa = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_activated_1, drawerItems);
        drawerList.setAdapter(aa);

        // Set the list's click listener
        drawerList.setOnItemClickListener((arg0, arg1, position, arg3) -> {

            Fragment fragment = null;
            if (position == 0)
                fragment = new BiographyFragment();
            else if (position == 1)
                fragment = new VaccinationFragment();
            else if (position == 2)
                fragment = new AnniversaryFragment();

            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction trans = fm.beginTransaction();
            trans.replace(R.id.content_frame, fragment);
            trans.commit();

            // Highlight the selected item,
            //  update the title, and close the drawer
            drawerList.setItemChecked(position, true);
            currentTitle = drawerItems[position];
            ab.setTitle(currentTitle);
            drawerLayout.closeDrawer(drawerList);
        });
    }
}
