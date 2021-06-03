package rp.edu.sg;

import android.app.AlertDialog;
import android.app.Dialog;
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
}