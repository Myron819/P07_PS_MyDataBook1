package rp.edu.sg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AnniversaryFragment extends Fragment {
    TextView tvAnniversary;
    Button btnFragAnniversaryEdit;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_anniversary, container, false);

        tvAnniversary = v.findViewById(R.id.tvAnniversary);
        btnFragAnniversaryEdit = v.findViewById(R.id.btnFragAnniversaryEdit);

        btnFragAnniversaryEdit.setOnClickListener(v -> {

        });
        return v;
    }
}