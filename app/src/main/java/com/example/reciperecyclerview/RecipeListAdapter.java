package com.example.reciperecyclerview;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private List<Recipe> recipes;
    private OnItemClickListener listener;

    public RecipeListAdapter(List<Recipe> recipes, OnItemClickListener listener) {
        this.recipes = recipes;
        this.listener = listener;
    }


    //onCreateViewHolder方法，返回ViewHolder对象
    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //通过LayoutInflater加载器将XML布局文件实例化为相应的视图对象
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe, parent, false);
        return new RecipeViewHolder(itemView);
    }


    /*
    * 在RecyclerView.Adapter中，position参数表示视图项在列表中的位置。该值由RecyclerView在调用onBindViewHolder方法时自动传入。

当调用onBindViewHolder方法时，
* RecyclerView会根据当前滚动的位置和可见的视图项数量来确定要绑定数据的视图项位置。它会按需调用onBindViewHolder方法，
* 确保只有当前可见的视图项才会被绑定数据，从而提高性能和内存效率。

在实际使用中，你无需手动传入position值，
* 而是在onBindViewHolder方法中使用它来获取对应位置的数据，或者根据位置执行特定的操作。
* 通过该参数，你可以根据不同的位置来处理不同的数据和逻辑，从而实现列表项的个性化展示和交互
    *

    * */
    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder holder, int position) {
        //从数据源中获取指定位置的数据
        Recipe currentRecipe = recipes.get(position);
        holder.recipeNameTextView.setText(currentRecipe.getName());
        holder.recipeDescriptionTextView.setText(currentRecipe.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(currentRecipe);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder {
        TextView recipeNameTextView;
        TextView recipeDescriptionTextView;
//创建一个RecipeViewHolder内部类
        public RecipeViewHolder(View itemView) {
            super(itemView);
            recipeNameTextView = itemView.findViewById(R.id.recipeNameTextView);
            recipeDescriptionTextView = itemView.findViewById(R.id.recipeDescriptionTextView);
        }
    }

    //创建一个OnItemClickListener内部接口
    public interface OnItemClickListener {
        void onItemClick(Recipe recipe);
    }
}
