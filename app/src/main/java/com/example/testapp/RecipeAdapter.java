package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeHolder> {


    private ArrayList<recipe> recipes;


    public interface OnItemClickListener{
        void onItemClick(RecipeHolder holder, int position);
    }

    private OnItemClickListener onItemClickListener;




    public class RecipeHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView desc;
        int position;
        public RecipeHolder(View v){
            super(v);
            name = v.findViewById(R.id.name);
            desc = v.findViewById(R.id.desc);
        }

    }


    public RecipeAdapter(ArrayList<recipe> recipelist, OnItemClickListener listener){
        this.recipes = recipelist;
        this.onItemClickListener = listener;
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
    public void onBindViewHolder(@NonNull final RecipeAdapter.RecipeHolder holder, final int position) {
            holder.name.setText(recipes.get(position).getName());
            holder.desc.setText(recipes.get(position).getDescription());

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(holder,position);
                }
            });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }
}
