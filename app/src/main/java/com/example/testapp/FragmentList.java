package com.example.testapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FragmentList extends Fragment {

    RecyclerView recList;
    RecipeAdapter adapter;
    RecyclerView.LayoutManager manager;
    ArrayList<recipe> recipes;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recList = view.findViewById(R.id.list);

        MainActivity activity = (MainActivity)getActivity();

        adapter = new RecipeAdapter(activity.getRecipes());
        manager = new LinearLayoutManager(getActivity());
        recList.setAdapter(adapter);

        recList.setLayoutManager(manager);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_fragment,container,false);
    }
}
