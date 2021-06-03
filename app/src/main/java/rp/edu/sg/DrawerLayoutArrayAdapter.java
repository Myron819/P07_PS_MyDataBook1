package rp.edu.sg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerLayoutArrayAdapter extends ArrayAdapter<String> {
    Context context;
    ArrayList<String> drawerList;
    int resource;
    TextView textView;
    ImageView imageView;


    public DrawerLayoutArrayAdapter(Context context, int resource, ArrayList<String> drawerList) {
        super(context, resource, drawerList);
        this.drawerList = drawerList;
        this.context = context;
        this.resource = resource;
    }

    @SuppressLint("CutPasteId")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.row, parent, false);

        textView = rowView.findViewById(R.id.tv);

        String CurrentDrawer = drawerList.get(position);

        textView.setText(CurrentDrawer);

        imageView = rowView.findViewById(R.id.iv);
        if (position == 0) {
            imageView.setImageResource(android.R.drawable.ic_dialog_info);
        } else if (position == 1) {
            imageView.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (position == 2) {
            imageView.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else if (position == 3) {
            imageView.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }
}
