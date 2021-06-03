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

// TODO: Done by Jun Kai
public class AnniversaryFragment extends Fragment {

    TextView tvAnniversary;
    Button btnAnniversaryEdit;
    EditText etAnniDialog;

    // loating action buttons are used for a special type of
    // promoted action. They are distinguished by a circled icon floating
    // above the UI and have special motion behaviors related to morphing,
    // launching, and the transferring anchor point.
    FloatingActionButton fabAnninversarySearch;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_anniversary, container, false);
        tvAnniversary = view.findViewById(R.id.tvAnniversary);
        btnAnniversaryEdit = view.findViewById(R.id.btnAnniversaryEdit);
        fabAnninversarySearch = view.findViewById(R.id.fabAnninversarySearch);

        btnAnniversaryEdit.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Edit Anniversary");
            builder.setCancelable(false);
            builder.setView(inflater.inflate(R.layout.edit_dialog, null)).setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Dialog d = (Dialog) dialog;
                    etAnniDialog = d.findViewById(R.id.etDialogBox);
                    String message = etAnniDialog.getText().toString();
                    Log.d("dialog", etAnniDialog.getText().toString());
                    tvAnniversary.setText(message);

                }
            });
            builder.setNeutralButton("Cancel", null);
            AlertDialog myDialog = builder.create();
            myDialog.show();
        });
        return view;
    }
}
