package rp.edu.sg;

<<<<<<< HEAD:app/src/main/java/rp/edu/sg/BiographyFragment.java
=======
import android.app.Dialog;
import android.content.DialogInterface;
>>>>>>> origin/master:app/src/main/java/rp/edu/sg/BioFragment.java
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

public class BiographyFragment extends Fragment {
    TextView tvBio;
    Button btnFragBioEdit;
    View v;
    FloatingActionButton btnBioSearch;
    EditText etDialog;

    //ToDo Done by Zuhaili

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_biography, container, false);

        tvBio = v.findViewById(R.id.tvBio);
        btnFragBioEdit = v.findViewById(R.id.btnFragBioEdit);
//        btnBioSearch = view.findViewById(R.id.btnBioSearch);


        btnFragBioEdit.setOnClickListener(v -> {
            AlertDialog.Builder mybuilder = new AlertDialog.Builder(getActivity());
            mybuilder.setTitle("Edit bio");
            mybuilder.setCancelable(false);
            mybuilder.setView(inflater.inflate(R.layout.bio_edit_dialog, null))
<<<<<<< HEAD:app/src/main/java/rp/edu/sg/BiographyFragment.java
                    .setPositiveButton("ok", (dialog, which) -> {
                        String message = etDialog.getText().toString();
                        Log.d("dialog", etDialog.getText().toString());
                        tvBio.setText(message);

=======
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Dialog d = (Dialog) dialog;
                            etDialog = d.findViewById(R.id.etDialogBox);
                            String message = etDialog.getText().toString();
                            Log.d("dialog", etDialog.getText().toString());
                            tvBio.setText(message);

                        }
>>>>>>> origin/master:app/src/main/java/rp/edu/sg/BioFragment.java
                    });
            mybuilder.setNeutralButton("Cancel", null);
            AlertDialog myDialog = mybuilder.create();
            myDialog.show();

        });


        return v;
    }
}