package rp.edu.sg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class BioFragment extends Fragment {
    TextView tvBio;
    Button btnFragBioEdit;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.biofragment, container, false);

        tvBio = v.findViewById(R.id.tvBio);
        btnFragBioEdit = v.findViewById(R.id.btnFragBioEdit);

        btnFragBioEdit.setOnClickListener(v -> {

        });
        return v;
    }
}