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

// TODO: Done by Jun Kai
public class AnniversaryFragment extends Fragment {

    Button btnEditAnniversary;
    TextView tvAnniversary;
    EditText etData;


    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anniversary, container, false);

        btnEditAnniversary = view.findViewById(R.id.btnEditAnniversary);
        tvAnniversary = view.findViewById(R.id.tvAnniversary);
        etData = view.findViewById(R.id.etEdit);

        btnEditAnniversary.setOnClickListener(v -> {
            LayoutInflater inflater1 = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View viewDialog = inflater1.inflate(R.layout.edit_dialog, null);

            final EditText etData = viewDialog.findViewById(R.id.etEdit);

            AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
            myBuilder.setView(viewDialog);
            myBuilder.setTitle("Edit Anniversary");
            String preparedMessage = tvAnniversary.getText().toString();
            etData.setText(preparedMessage);
            
            
            myBuilder.setPositiveButton("OK", (dialog, which) -> {
                String message = etData.getText().toString();
                tvAnniversary.setText(message);

                SharedPreferences SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
                SharedPreferences.Editor prefEdit = SharedPreferences.edit();
                prefEdit.putString("Anniversary", message);
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
        SharedPreferences SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String currentMessage = SharedPreferences.getString("Anniversary","");
        tvAnniversary.setText(currentMessage);
    }
}