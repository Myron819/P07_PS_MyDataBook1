package rp.edu.sg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class VaccinationFragment extends Fragment {
    TextView tvVaccination;
    Button btnFragVaccinationEdit;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.vaccinationfragment, container, false);

        tvVaccination = v.findViewById(R.id.tvVaccination);
        btnFragVaccinationEdit = v.findViewById(R.id.btnFragVaccinationEdit);

        btnFragVaccinationEdit.setOnClickListener(v -> {

        });
        return v;
    }
}