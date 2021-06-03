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

// TODO: Done by zizou
public class BiographyFragment extends Fragment {

    Button btnEditBiography;
    TextView tvBiography;
    EditText etEdit;


    public BiographyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_biography, container, false);

        tvBiography = view.findViewById(R.id.tvBiography);
        btnEditBiography = view.findViewById(R.id.btnEditBiography);
        etEdit = view.findViewById(R.id.etEdit);

        btnEditBiography.setOnClickListener(v -> {
            LayoutInflater inflater1 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater1.inflate(R.layout.edit_dialog, null);

            final EditText etEdit = viewDialog.findViewById(R.id.etEdit);

            AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
            myBuilder.setView(viewDialog);
            myBuilder.setTitle("Edit Biography");
            String preloadMessage = tvBiography.getText().toString();
            etEdit.setText(preloadMessage);
            myBuilder.setPositiveButton("OK", (dialog, which) -> {
                String message = etEdit.getText().toString();
                tvBiography.setText(message);

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor prefEdit = prefs.edit();
                prefEdit.putString("Biography", message);
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
        String currMessage = prefs.getString("Biography", "");
        tvBiography.setText(currMessage);
    }
}