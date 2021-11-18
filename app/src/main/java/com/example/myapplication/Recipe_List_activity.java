package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Recipe_List_activity extends AppCompatActivity {
    ListView recipeListView;
    String[] recipes;
    String[] times;
    String[] prices;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        Resources res = getResources();
        recipeListView = (ListView) findViewById(R.id.recipe_listview);
        recipes = res.getStringArray(R.array.recipes);
        times = res.getStringArray(R.array.time);
        prices = res.getStringArray(R.array.price);

        ItemAdapter itemAdapter = new ItemAdapter(this, recipes, prices, times);
        recipeListView.setAdapter(itemAdapter);

        recipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i , long l){
                Intent showRecipeActivty = new Intent(getApplicationContext(), RecipeActivity.class);
                showRecipeActivty.putExtra("ingredient",i);
                startActivity(showRecipeActivty);
            }
        });


    }
}