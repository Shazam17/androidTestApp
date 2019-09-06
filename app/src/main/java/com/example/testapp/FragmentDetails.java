package com.example.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class FragmentDetails extends Fragment {


    private int pos;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pos = getArguments().getInt("pos");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_frag, container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MainActivity activity = (MainActivity)getActivity();

        TextView name = view.findViewById(R.id.name_details);
        TextView desc = view.findViewById(R.id.desc_details);
        name.setText(activity.getRecipes().get(pos).getName());
        desc.setText(activity.getRecipes().get(pos).getName());

        ImageView img = view.findViewById(R.id.img_detail);
        Glide
                .with(getContext())
                .load(activity.getRecipes().get(pos).getImages().get(0))
                .into(img);
    }
}
