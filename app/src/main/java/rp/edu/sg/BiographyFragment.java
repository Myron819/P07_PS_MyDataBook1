package rp.edu.sg;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BiographyFragment extends Fragment {
    TextView tvBio;
    Button btnFragBioEdit;
    View v;
    FloatingActionButton btnBioSearch;
    EditText etDialog;
    private DrawerLayout drawerLayout;

    //ToDo Done by Zuhaili

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_biography, container, false);

        drawerLayout = v.findViewById(R.id.drawerLayout);
        tvBio = v.findViewById(R.id.tvBiography);
        btnFragBioEdit = v.findViewById(R.id.btnBiographyEdit);
//        btnBioSearch = view.findViewById(R.id.btnBioSearch);
        FloatingActionButton fab = v.findViewById(R.id.fabBiographySearch);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //action
                //if you need open the slide:
//                drawerLayout.openDrawer(Gravity.LEFT);

                //if you need close the slide
//                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });



        btnFragBioEdit.setOnClickListener(v -> {
            AlertDialog.Builder mybuilder = new AlertDialog.Builder(getActivity());
            mybuilder.setTitle("Edit Bio");
            mybuilder.setCancelable(false);
            mybuilder.setView(inflater.inflate(R.layout.edit_dialog, null)).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Dialog d = (Dialog) dialog;
                            etDialog = d.findViewById(R.id.etDialogBox);
                            String message = etDialog.getText().toString();
                            Log.d("dialog", etDialog.getText().toString());
                            tvBio.setText(message);

                        }
                    });
            mybuilder.setNeutralButton("Cancel", null);
            AlertDialog myDialog = mybuilder.create();
            myDialog.show();

        });


        return v;
    }


    // Fetch the stored data in onResume()
    // Because this is what will be called
    // when the app opens again
    @Override
    public void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = this.getActivity().getSharedPreferences("biographyPrefs", Context.MODE_PRIVATE);

        String biography = sh.getString("biography", "");

        // Setting the fetched data
        // in the EditTexts
        tvBio.setText(biography);
    }

    // Store the data in the SharedPreference
    // in the onPause() method
    // When the user closes the application
    // onPause() will be called
    // and data will be stored
    @Override
    public void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("BiographyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("biography", tvBio.getText().toString());
        myEdit.apply();
    }
}