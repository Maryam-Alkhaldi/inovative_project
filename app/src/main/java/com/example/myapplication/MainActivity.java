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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
    * Hard Coded recipe list to get around XML parser difficulties.
    * recipe indexes:
    * 0 = Beef and Veggie Stew (recipe id:1)
    * 1 = Vegetarian Lasagne (recipe id:2)
    * 2 = Pancakes (recipe id:3)
    * 3 = Mushrooms (recipe id:4)
    * 4 = Cheesecake (recipe id:5)
    * 5 = Banana Milkshake (recipe id:6)
    *
    * Each recipe has the following variables:
    * String name;
    * String description;
    * String category;
    * String ingredients[];
    * String method[];
    * Integer price;
    * Integer id;
    *
    * Each variable has assessor methods for them
    *
    */
    ArrayList<Recipe> recipeList = Recipe.loadRecipesWorkaround();



    /*
    * Example of how to obtain information. It should work...(I was unable to find a way to test it)
    String name = recipeList.get(4).getName();
    Integer id = recipeList.get(3).getId();
    String description = recipeList.get(2).getDescription();
    String category = recipeList.get(5).getCategory();
    Integer price = recipeList.get(1).getPrice();
    String[] ingredients = recipeList.get(0).getIngredients();
    String[] method = recipeList.get(4).getMethod();
    */

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
                String categoryName = categories[i];
                intent.putExtra("category name",categoryName);
                startActivity(intent);

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UploadActivity.class));
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
    /*
     * NOT FULLY FUNCTIONAL
     * Reads in data from an XML file containing all data associated with
     * the stock recipes contained in the app.
     *
    public void loadRecipes()
    {
        AssetManager assets = getAssets();

        InputStream iStream;
        XmlPullParser xmlParser;

        try
        {
            iStream = assets.open("recipes.xml");
            try
            {
                xmlParser = Xml.newPullParser();
                xmlParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                xmlParser.setInput(iStream, null);

                int recipeNum = 0;
                int event = 0;

                while (event != XmlPullParser.END_DOCUMENT)
                {
                    String name = xmlParser.getName();
                    System.out.println(">>>" + name); // First returned value is null.

//                    if(name.equals("Recipe")) // Throws an Exception???
//                    {
//                        recipeNum++;
//                    }

                    System.out.println(">>>" + recipeNum);
                    event = xmlParser.next();
                }


            }
            catch(XmlPullParserException exception)
            {
                System.err.println(">>>Error XmlPullParser");
            }


        }
        catch(FileNotFoundException e)
        {
            System.err.println(">>>FileNotFoundException Has Occured.");
        }
        catch(IOException e)
        {
            System.err.println(">>>IOException Has Occured");
        }
        catch (Exception e)
        {
            System.err.println(">>>" + e.getCause());
            System.err.println(">>>ERROR Reading File.");
        }
    }
}*/