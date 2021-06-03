package rp.edu.sg;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

//TODO:Done by Shufang
public class VaccinationFragment extends Fragment {
    Button btnEditVaccination;
    TextView tvDisplayVaccination;
    EditText etData;


    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);

        btnEditVaccination = view.findViewById(R.id.btnEdit);
        tvDisplayVaccination = view.findViewById(R.id.tvData);
        etData = view.findViewById(R.id.etData);

        btnEditVaccination.setOnClickListener(v -> {
            LayoutInflater inflater1 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater1.inflate(R.layout.edit_dialog, null);

            final EditText etData = viewDialog.findViewById(R.id.etData);

            AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
            myBuilder.setView(viewDialog);
            myBuilder.setTitle("Edit Vaccination");

            String preloadMessage = tvDisplayVaccination.getText().toString();
            etData.setText(preloadMessage);

            myBuilder.setPositiveButton("OK", (dialog, which) -> {
                String message = etData.getText().toString();
                tvDisplayVaccination.setText(message);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putString("Vaccination", message);
                prefEdit.apply();
            });
            myBuilder.setNegativeButton("CANCEL", null);
            AlertDialog myDialog = myBuilder.create();
            myDialog.show();
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String currentMessage = prefs.getString("Vaccination", "");
        tvDisplayVaccination.setText(currentMessage);
    }
}