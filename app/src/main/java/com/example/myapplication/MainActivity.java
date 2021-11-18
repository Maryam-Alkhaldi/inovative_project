package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GridView gridView;
    String[] categories = {"Trending", "Breakfast", "Lunch", "Dinner", "Dessert", "Snack"};
    int[] categoryImages = {R.drawable.trending, R.drawable.breakfast, R.drawable.lunch,
            R.drawable.dinner, R.drawable.dessert, R.drawable.snack};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Recipe_List_activity.class);
                intent.putExtra("name",categories[i]);
                intent.putExtra("image",categoryImages[i]);
                startActivity(intent);

            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return categoryImages.length;
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
            View view1 = getLayoutInflater().inflate(R.layout.category_data_layout,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.categoryName);
            ImageView image = view1.findViewById(R.id.categoryImage);

            name.setText(categories[position]);
            image.setImageResource(categoryImages[position]);
            return view1;
        }
    }
}