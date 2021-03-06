package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class RecipeActivity extends AppCompatActivity {
    ListView ingredientsListView;
    ListView instructionListView;
    ListView notesView;
    ListView commentsView;
    Button favButton;
    String[] recipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        Intent intent = getIntent();
        recipes = intent.getStringArrayExtra("recipes");
        int index = -1;
        String rn = intent.getStringExtra("recipe name");
        for(int i=0; i< recipes.length;i++){
            if(rn.equals("coming soon")){
                index=4;
            }
            else if(rn.equals(recipes[i])){
                index=i;
            }
        }

        assert index>-1;
        TextView recipeName = (TextView) findViewById(R.id.recipeName1);
        recipeName.setText(rn);

        ingredientsListView = (ListView) findViewById(R.id.ingredient_list);
        IngredientAdapter ingredientAdapter = new IngredientAdapter(index);
        ingredientsListView.setAdapter(ingredientAdapter);

        instructionListView = (ListView) findViewById(R.id.instruction_list);
        InstructionAdapter instructionAdapter = new InstructionAdapter(index);
        instructionListView.setAdapter(instructionAdapter);

        notesView = (ListView) findViewById(R.id.notes_list);
        NotesAdapter notesAdapter = new NotesAdapter(index);
        notesView.setAdapter(notesAdapter);

        commentsView = (ListView) findViewById(R.id.comments_list);
        CommentsAdapter commentsAdapter = new CommentsAdapter(index);
        commentsView.setAdapter(commentsAdapter);

        favButton = (Button) findViewById(R.id.fav_button);
        favButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code to add recipe if to database
                Intent showRecipeFavorites = new Intent(getApplicationContext(), Favorites_activity.class);
                showRecipeFavorites.putExtra("recipe name",rn);
                startActivity(showRecipeFavorites);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RecipeActivity.this, UploadActivity.class));
            }
        });

    }

    private String[] getIngredients(int index){
        switch(index){
            case 0: return getResources().getStringArray(R.array.cc_ingredients);
            case 1: return getResources().getStringArray(R.array.pa_ingredients);
            case 2: return getResources().getStringArray(R.array.ft_ingredients);
            case 3: return getResources().getStringArray(R.array.bs_ingredients);
            case 4: return getResources().getStringArray(R.array.cs_ingredients);
        }
        return null;
    }

    private String[] getInstructions(int index){
        switch(index){
            case 0: return getResources().getStringArray(R.array.cc_Instructions);
            case 1: return getResources().getStringArray(R.array.pa_instructions);
            case 2: return getResources().getStringArray(R.array.ft_instructions);
            case 3: return getResources().getStringArray(R.array.bs_instructions);
            case 4: return getResources().getStringArray(R.array.cs_instructions);
        }
        return null;
    }

    private String[] getNotes(int index){
        switch(index){
            case 0: return getResources().getStringArray(R.array.cc_notes);
            case 1: return getResources().getStringArray(R.array.pa_notes);
            case 2: return getResources().getStringArray(R.array.ft_notes);
            case 3: return getResources().getStringArray(R.array.bs_notes);
            case 4: return getResources().getStringArray(R.array.cs_notes);
        }
        return null;
    }


    private class IngredientAdapter extends BaseAdapter {
        String[] ingredients;

        public IngredientAdapter(int index){
            ingredients = getIngredients(index);
        }
        @Override
        public int getCount() {
            return ingredients.length;
        }

        @Override
        public Object getItem(int position) {
            return ingredients[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.ingredient_item_layout, null);
            RadioButton ingredientview = (RadioButton) view.findViewById(R.id.ingredient_button);
            ingredientview.setText(ingredients[position]);
            return view;
        }
    }

    private class InstructionAdapter extends BaseAdapter {
        String[] instructions;

        public InstructionAdapter(int index){
            instructions = getInstructions(index);
        }
        @Override
        public int getCount() {
            return instructions.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.instruction_layout, null);
            RadioButton instructionView = (RadioButton) view.findViewById(R.id.instruction_button);
            instructionView.setText(instructions[position]);
            return view;
        }
    }
    private class NotesAdapter extends BaseAdapter {
        String[] notes;

        public NotesAdapter(int index){
            notes = getNotes(index);
        }
        @Override
        public int getCount() {
            return notes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.note_layout, null);
            TextView noteView = (TextView) view.findViewById(R.id.note_text);
            noteView.setText(notes[position]);
            return view;
        }
    }
    private class CommentsAdapter extends BaseAdapter {
        String[] comments;

        public CommentsAdapter(int index){
            comments = getNotes(index);
        }
        @Override
        public int getCount() {
            return comments.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.comment_layout, null);
            TextView commentView = (TextView) view.findViewById(R.id.comment_text);
            commentView.setText(comments[position]);
            return view;
        }
    }

}
