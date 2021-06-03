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
    ArrayList<String> drawerlist;
    int resource;
    TextView name;
    ImageView iv;


    public DrawerLayoutArrayAdapter(Context context, int resource, ArrayList<String> drawerlist) {
        super(context, resource, drawerlist);
        this.drawerlist = drawerlist;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.row, parent, false);
        name = (TextView) rowView.findViewById(R.id.tvName);

        String pos = drawerlist.get(position);

        name.setText(pos);

        iv = rowView.findViewById(R.id.lv);

        if (position == 0) {
            iv.setImageResource(android.R.drawable.ic_dialog_info);
        } else if (position == 1) {
            iv.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (position == 2) {
            iv.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else if (position == 3) {
            iv.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }
}
