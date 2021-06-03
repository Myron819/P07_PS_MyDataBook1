package rp.edu.sg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DrawerLayoutArrayAdapter extends ArrayAdapter {

    final Context context;
    final String[] values;

    public DrawerLayoutArrayAdapter(@NonNull Context context, int resource, Context context1, String[] values) {
        super(context, resource);
        this.context = context1;
        this.values = values;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.row, parent, false);

        TextView tvCat = rowView.findViewById(R.id.tvCategory);
        ImageView iv = rowView.findViewById(R.id.imageView);

        tvCat.setText(values[position]);

        String pos = values[position];

        if (pos.startsWith("Bio")) {
            iv.setImageResource(android.R.drawable.ic_dialog_info);
        } else if (pos.startsWith("Anni")) {
            iv.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else if (pos.startsWith("Vacc")) {
            iv.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (pos.startsWith("About")) {
            iv.setImageResource(android.R.drawable.star_big_on);
        }

        return rowView;
    }
}