package rp.edu.sg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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

// TODO: Done by Zizou
public class BiographyFragment extends Fragment {

    TextView tvBio;
    Button btnBioEdit;
    FloatingActionButton btnBioSearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biography, container, false);
        tvBio = view.findViewById(R.id.tvBiography);
        btnBioEdit = view.findViewById(R.id.btnBiographyEdit);
        btnBioSearch = view.findViewById(R.id.fabBiographySearch);

        btnBioEdit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Edit Bio");
            builder.setView(inflater.inflate(R.layout.bio_edit_dialog, null))
                    .setPositiveButton(R.string.ok, (dialog, which) -> {
                        Dialog d = (Dialog) dialog;
                        EditText etDialog = d.findViewById(R.id.etDialogBox);
                        Log.d("dialog", etDialog.getText().toString());
                        tvBio.setText(etDialog.getText().toString());
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