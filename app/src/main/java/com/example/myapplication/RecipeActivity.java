package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

public class RecipeActivity extends AppCompatActivity {
    ListView ingredintsListView;
    ListView instructionListView;
    ListView notesView;
    String[] ingredients;
    String[] instructions;
    String[] notes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        Resources res = getResources();
        ingredintsListView = (ListView) findViewById(R.id.ingredient_list);
        ingredients = res.getStringArray(R.array.cc_ingredients);
        IngredientAdapter ingredientAdapter = new IngredientAdapter(this, ingredients);
        ingredintsListView.setAdapter(ingredientAdapter);

        instructionListView = (ListView) findViewById(R.id.instruction_list);
        instructions = res.getStringArray(R.array.cc_Instructions);
        InstructionAdapter instructionAdapter = new InstructionAdapter(this, instructions);
        instructionListView.setAdapter(instructionAdapter);

        notesView = (ListView) findViewById(R.id.notes_list);
        notes = res.getStringArray(R.array.cc_notes);
        NotesAdapter notesAdapter = new NotesAdapter(this, notes);
        notesView.setAdapter(notesAdapter);
    }

    private class IngredientAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        String[] ingredients;

        public IngredientAdapter(Context c, String[] i){
            ingredients = i;
            mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
            View view = mInflater.inflate(R.layout.ingredient_item_layout, null);
            RadioButton ingredientview = (RadioButton) view.findViewById(R.id.ingredient_button);
            String name = ingredients[position];
            ingredientview.setText(name);
            return view;
        }
    }

    private class InstructionAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        String[] instructions;

        public InstructionAdapter(Context c, String[] i){
            instructions = i;
            mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return instructions.length;
        }

        @Override
        public Object getItem(int position) {
            return instructions[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mInflater.inflate(R.layout.instruction_layout, null);
            RadioButton instructionview = (RadioButton) view.findViewById(R.id.instruction_button);
            String name = instructions[position];
            instructionview.setText(name);
            return view;
        }
    }
    private class NotesAdapter extends BaseAdapter {
        LayoutInflater mInflater;
        String[] notes;

        public NotesAdapter(Context c, String[] i){
            notes = i;
            mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return notes.length;
        }

        @Override
        public Object getItem(int position) {
            return notes[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = mInflater.inflate(R.layout.note_layout, null);
            TextView noteView = (TextView) view.findViewById(R.id.note_text);
            String note = notes[position];
            noteView.setText(note);
            return view;
        }
    }
}
