package rp.edu.sg;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class BiographyFragment extends Fragment {

    Button btnEdit;


    public BiographyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_biography, container, false);
        TextView tvData = (TextView) view.findViewById(R.id.tvData);
        btnEdit = view.findViewById(R.id.btnEdit);
        View viewDialog = inflater.inflate(R.layout.edit_dialog, null);
        EditText etData = (EditText) viewDialog.findViewById(R.id.etData);
        LayoutInflater inflater1 = (LayoutInflater) getContext().
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        btnEdit.setOnClickListener(view1 -> {
            AlertDialog.Builder myBuilder = new AlertDialog.Builder(getContext());
            myBuilder.setTitle("Edit Biography");
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