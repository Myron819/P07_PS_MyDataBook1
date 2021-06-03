package rp.edu.sg;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

//TODO:Done by Shufang

public class AboutUsFragment extends Fragment {

    ImageView ivPicture;
    TextView tvAuthors, tvModule;


    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_us, container, false);


        tvAuthors = view.findViewById(R.id.tvAuthor);
        tvModule = view.findViewById(R.id.tvModule);
        ivPicture = view.findViewById(R.id.ivPicture);

        tvAuthors.setText("Created by: Dana White");
        tvModule.setText("President of the Ultimate Fighting Championship (UFC)");
        String imageUrl = "https://u2v2u3t5.stackpathcdn.com/wp-content/uploads/2015/07/dana-white-twitter.jpg";
        Picasso.with(getContext()).load(imageUrl).placeholder(R.drawable.ajax_loader).error(R.drawable.error).into(ivPicture);


        return view;
    }

}