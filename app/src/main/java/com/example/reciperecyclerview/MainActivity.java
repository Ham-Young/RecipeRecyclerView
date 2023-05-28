package com.example.reciperecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeListAdapter.OnItemClickListener {
    private RecyclerView recipeRecyclerView;
    private RecipeListAdapter recipeAdapter;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化菜谱数据
        initRecipeData();

        // 初始化RecyclerView和Adapter
        recipeRecyclerView = findViewById(R.id.recipeRecyclerView);
        recipeAdapter = new RecipeListAdapter(recipeList, this);
        recipeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recipeRecyclerView.setAdapter(recipeAdapter);
    }

    private void initRecipeData() {
        recipeList = new ArrayList<>();
        recipeList.add(new Recipe("鱼香肉丝", "鱼香肉丝没有鱼",
                "鱼香肉丝是一道常见川菜。鱼香味，是四川菜肴主要传统味型之一。" +
                        "成菜：色泽棕红，咸鲜酸甜兼备，葱姜蒜香浓郁，其味是调味品调制而成。" +
                        "此法源出于四川民间独具特色的烹鱼调味方法，而今已广泛用于川味的熟菜中", R.drawable.yxrs));
        recipeList.add(new Recipe("蚂蚁上树", "蚂蚁上树没有蚂蚁",
                "蚂蚁上树通常由粉丝（或者粉条）、肉末为主料，辅以胡萝卜、姜、葱、豆瓣酱等辅料制作而成。" +
                        "成菜后，口味清淡，爽滑美味，色泽红亮，食之别有风味" ,R.drawable.myss));
        recipeList.add(new Recipe("夫妻肺片", "夫妻肺片没有肺",
                "常以牛头皮、牛心、牛舌、牛肚、牛肉为主料，进行卤制，而后切片。再配以辣椒油、花椒面等辅料制成红油浇在上面。" +
                        "其制作精细，色泽美观，质嫩味鲜，麻辣浓香，非常适口",R.drawable.fqfp));
        recipeList.add(new Recipe("宫爆鸡丁", "宫爆鸡丁是川菜系中的传统名菜",
                "宫保鸡丁选用鸡肉为主料，佐以花生米、辣椒等辅料烹制而成；红而不辣、辣而不猛、香辣味浓、肉质滑脆；" +
                        "其入口鲜辣，鸡肉的鲜嫩可以配合花生的香脆",R.drawable.fqfp));
        recipeList.add(new Recipe("地三鲜", "地三鲜是一道东北传统名菜",
                "地三鲜制作材料是三种地里时令新鲜的食材：茄子、土豆和青椒。" +
                        "它不仅在于鲜浓的味道、天然绿色的食材，更胜于它涵盖多种食材的营养，" +
                        "让三味非常普通的食材做成鲜爽无比的佳肴",R.drawable.dsx));
        recipeList.add(new Recipe("红烧猪蹄", "红烧猪蹄是一道传统的名菜，也是一道比较常见的家常菜",
                "这道菜以猪蹄为主要食材，这道菜味道可口，营养价值丰富，" +
                        "具有美容养颜、抗衰老、促进生长、改善冠心病等功效，此菜虽营养丰富，" +
                        "但动脉硬化和高血压病患者应当慎食",R.drawable.hszt));
    }

    @Override
    public void onItemClick(Recipe recipe) {
        Intent intent = new Intent(this, RecipeDetailsActivity.class);
        intent.putExtra("recipeDetial", recipe.getText());
        intent.putExtra("recipeImageResId",recipe.getImageResId());
        startActivity(intent);
    }
}
