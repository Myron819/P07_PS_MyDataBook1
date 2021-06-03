package rp.edu.sg;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
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

    // Fetch the stored data in onResume()
    // Because this is what will be called
    // when the app opens again
    @Override
    public void onResume() {
        super.onResume();

        // Fetching the stored data
        // from the SharedPreference
        SharedPreferences sh = this.getActivity().getSharedPreferences("AnniversaryPrefs", Context.MODE_PRIVATE);

        String anniversary = sh.getString("anniversary", "");

        // Setting the fetched data
        // in the EditTexts
        tvAnniversary.setText(anniversary);
    }

    // Store the data in the SharedPreference
    // in the onPause() method
    // When the user closes the application
    // onPause() will be called
    // and data will be stored
    @Override
    public void onPause() {
        super.onPause();

        // Creating a shared pref object
        // with a file name "MySharedPref"
        // in private mode
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("AnniversaryPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("anniversary", tvAnniversary.getText().toString());
        myEdit.apply();
    }
}
