package rp.edu.sg;

import android.app.Dialog;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.biofragment, container, false);

        tvBio = v.findViewById(R.id.tvBio);
        btnFragBioEdit = v.findViewById(R.id.btnFragBioEdit);
//        btnBioSearch = view.findViewById(R.id.btnBioSearch);

        btnFragBioEdit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Edit Bio");
            builder.setView(inflater.inflate(R.layout.bio_edit_dialog, null))
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Dialog d = (Dialog) dialog;
                            EditText etDialog = d.findViewById(R.id.etDialog);
                            Log.d("dialog", etDialog.getText().toString());
                            tvBio.setText(etDialog.getText().toString());
                            dialog.dismiss();
                        }
                    }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Log.d("dialog", "onClick: cancel");
                    dialog.cancel();
                }
            });
            builder.create().show();

        });
        return v;
    }
}