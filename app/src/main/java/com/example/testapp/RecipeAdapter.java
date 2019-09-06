package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {



    class RecipeHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView desc;
        public RecipeHolder(View v){
            super(v);
            name = v.findViewById(R.id.name);
            desc = v.findViewById(R.id.desc);
        }

    }



    @NonNull
    @Override
    public RecipeAdapter.RecipeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View v = LayoutInflater.from(parent.getContext())
               .inflate(R.layout.recipe_item, parent, false);

       RecipeHolder holder = new RecipeHolder(v);

       return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.RecipeHolder holder, int position) {
            holder.name.setText("name");
            holder.desc.setText("desc");
    }

    @Override
    public int getItemCount() {
        return 6;
    }
}
