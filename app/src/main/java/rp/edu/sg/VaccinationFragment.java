package rp.edu.sg;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

//TODO:Done by Shufang
public class VaccinationFragment extends Fragment {

    Button btnEdit;

    public VaccinationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vaccination, container, false);
        btnEdit = view.findViewById(R.id.btnEdit);

        final TextView tvData = (TextView) view.findViewById(R.id.tvData);

        LayoutInflater inflater1 = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View viewDialog = inflater.inflate(R.layout.edit_dialog, null);

        final EditText etData = (EditText) viewDialog.findViewById(R.id.etData);

        btnEdit.setOnClickListener(view1 -> {
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(getContext());
            myBuilder.setTitle("Edit Anniversaty");
            myBuilder.setView(viewDialog);
            myBuilder.setCancelable(false);
            myBuilder.setNegativeButton("Cancel", null);
            myBuilder.setPositiveButton("Ok", (dialogInterface, i) -> {
                String data = etData.getText().toString();
                tvData.setText(data);
            });

            AlertDialog myDialog = myBuilder.create();
            myDialog.show();

        });

        return view;
    }
}