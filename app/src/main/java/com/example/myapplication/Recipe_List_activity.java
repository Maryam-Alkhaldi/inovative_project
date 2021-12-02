package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class Recipe_List_activity extends AppCompatActivity {
    ListView recipeListView;
    String[] recipes;
    String[] times;
    String[] prices;
    String[] categories = {"Trending", "Breakfast", "Lunch", "Dinner", "Dessert", "Snack"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        Intent intent = getIntent();
        int index = -1;
        String rn = intent.getStringExtra("category name");
        TextView recipeName = (TextView) findViewById(R.id.categoryName11);
        recipeName.setText(rn);
        for(int i=0; i< categories.length;i++){
            if(rn.equals(categories[i])){
                index=i;
            }
        }
        assert index>-1;

        Resources res = getResources();
        recipeListView = (ListView) findViewById(R.id.recipe_listview);
        recipes = getRecipes(index);
        times = getTimes(index);
        prices = getPrices(index);

        ItemAdapter itemAdapter = new ItemAdapter(this, recipes, prices, times);
        recipeListView.setAdapter(itemAdapter);

        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i , long l){
                Intent showRecipeActivty = new Intent(getApplicationContext(), RecipeActivity.class);
                String recipeName = recipes[i];
                showRecipeActivty.putExtra("recipes", recipes);
                showRecipeActivty.putExtra("recipe name",recipeName);
                startActivity(showRecipeActivty);
            }

        });

    }
    private String[] getRecipes(int index){
        switch(index){
            case 0: return getResources().getStringArray(R.array.t_recipes);
            case 1: return getResources().getStringArray(R.array.b_recipes);
            case 2: return getResources().getStringArray(R.array.l_recipes);
            case 3: return getResources().getStringArray(R.array.dn_recipes);
            case 4: return getResources().getStringArray(R.array.ds_recipes);
            case 5: return getResources().getStringArray(R.array.s_recipes);
        }
        return null;
    }
    private String[] getPrices(int index){
        switch(index){
            case 0: return getResources().getStringArray(R.array.t_prices);
            case 1: return getResources().getStringArray(R.array.b_prices);
            case 2: return getResources().getStringArray(R.array.l_prices);
            case 3: return getResources().getStringArray(R.array.dn_prices);
            case 4: return getResources().getStringArray(R.array.ds_prices);
            case 5: return getResources().getStringArray(R.array.s_prices);
        }
        return null;
    }

    private String[] getTimes(int index){
        switch(index){
            case 0: return getResources().getStringArray(R.array.t_time);
            case 1: return getResources().getStringArray(R.array.b_time);
            case 2: return getResources().getStringArray(R.array.l_time);
            case 3: return getResources().getStringArray(R.array.dn_time);
            case 4: return getResources().getStringArray(R.array.ds_time);
            case 5: return getResources().getStringArray(R.array.s_time);
        }
        return null;
    }
}