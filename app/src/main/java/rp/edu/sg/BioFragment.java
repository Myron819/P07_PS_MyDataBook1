package rp.edu.sg;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BioFragment extends Fragment {
    TextView tvBio;
    Button btnFragBioEdit;
    View v;
    FloatingActionButton btnBioSearch;
    EditText etDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.biofragment, container, false);

        tvBio = v.findViewById(R.id.tvBio);
        btnFragBioEdit = v.findViewById(R.id.btnFragBioEdit);
//        btnBioSearch = view.findViewById(R.id.btnBioSearch);
        etDialog = v.findViewById(R.id.etDialogBox);

        btnFragBioEdit.setOnClickListener(v -> {
            AlertDialog.Builder mybuilder = new AlertDialog.Builder(getActivity());
            mybuilder.setTitle("Edit bio");
            mybuilder.setCancelable(false);
            mybuilder.setView(inflater.inflate(R.layout.bio_edit_dialog, null))
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
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
}