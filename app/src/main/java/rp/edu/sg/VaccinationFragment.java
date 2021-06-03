package rp.edu.sg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

//TODO:Done by Shufang

public class VaccinationFragment extends Fragment {

    TextView tvVaccination;
    Button btnVaccinationEdit;
    FloatingActionButton fabVaccinationSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);
        tvVaccination = view.findViewById(R.id.tvVaccination);
        btnVaccinationEdit = view.findViewById(R.id.btnVaccinationEdit);
        fabVaccinationSearch = view.findViewById(R.id.fabVaccinationSearch);

        btnVaccinationEdit.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            builder.setTitle("Edit Vaccination");

            builder.setView(inflater.inflate(R.layout.edit_dialog, null))

                    .setPositiveButton(R.string.ok, (dialog, which) -> {

                        Dialog d = (Dialog) dialog;
                        EditText etDialog = d.findViewById(R.id.etDialogBox);
                        tvVaccination.setText(etDialog.getText().toString());
                        dialog.dismiss();

                    }).setNegativeButton(R.string.cancel, (dialog, which) -> {

                Log.d("dialog", "onClick: cancel");
                dialog.cancel();
            });
            builder.create().show();

        });
        return view;
    }



    // Fetch the stored data in onResume()
    // Because this is what will be called
    // when the app opens again
    @Override
    public void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = this.getActivity().getSharedPreferences("vaccinationPrefs", Context.MODE_PRIVATE);

        String vaccination = sh.getString("vaccination", "");

        // Setting the fetched data
        // in the EditTexts
        tvVaccination.setText(vaccination);
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
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("VaccinationPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("vaccination", tvVaccination.getText().toString());
        myEdit.apply();
    }
}