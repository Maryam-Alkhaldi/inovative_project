package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
        //loadRecipes();
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
        ArrayList<Recipe> recipeList = new ArrayList<>();
        Recipe tmpRecipeReference;
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

                int recipeNum = 0; // Only used for testing.
                int event = 0;

                String recipeName = "", recipeDescription = "", recipeCategory = "", imagePath = "";
                while (event != XmlPullParser.END_DOCUMENT)
                {

                    Ingredient recipeIngredients[] = new Ingredient[20]; // 20 is arbitrarily chosen for size.
                    double recipePrice;

                    String tagName;
                    int depth;

                    if (event != XmlPullParser.START_TAG) // Skip any null's
                    {
                        event = xmlParser.next();
                    }
                    else
                    {
                        tagName = xmlParser.getName();
                        depth = xmlParser.getDepth();

                        event = xmlParser.next(); // Skip over the Recipe tag denoting a new Recipe

                        // BEGINNING of a recipe. All recipes start with a <Recipe> tag at a
                        // depth of 1 following immediately to the start of a recipe
                        while(depth >= 2)
                        {

                            if (event != XmlPullParser.START_TAG) // Skip any null's
                            {
                                event = xmlParser.next();
                            }
                            else
                            {
                                tagName = xmlParser.getName();
                                event = xmlParser.next();

                                if(tagName.equals("Name")) // Get recipe name
                                {
                                    recipeName = xmlParser.getText();
                                }
                                if(tagName.equals("Description")) // Get recipe Description
                                {
                                    recipeDescription = xmlParser.getText();
                                }
                                else if(tagName.equals("Category")) // Get recipe Category
                                {
                                    recipeCategory = xmlParser.getText();
                                }
                                else if(tagName.equals("Ingredients"))
                                {
                                    getEmbeddedAttributes(xmlParser, true);
                                }
                                //Get all steps  for cooking the recipe
                                else if(tagName.equals("Method"))
                                        {
                                        getEmbeddedAttributes(xmlParser, false);
                                        }

                                        System.out.println(">>>Name: " + recipeName + "\t>>>Description: " +
                                        recipeDescription + "\t>>>Category: " + recipeCategory);
                                        }
                                        depth = xmlParser.getDepth();
                                        }
                                        }

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

private void getEmbeddedAttributes(XmlPullParser xmlParser, boolean ingredients) throws Exception
        {
        ArrayList<String> attributes = new ArrayList<>();
        String tagName = "";
        int event = xmlParser.next(); // Advance to the first attribute.
        int depth = xmlParser.getDepth();

        while(depth >= 3) // Get all nested attributes.
        {


        if(event != XmlPullParser.START_TAG)
        {
        event = xmlParser.next();
        }
        else
        {
        tagName = xmlParser.getName();
        event = xmlParser.next();
        if(ingredients == true) // Read ingredients list
        {
        String ingredientName = xmlParser.getText();
        String quantity = xmlParser.getAttributeValue(0); // Throws an exception???
        System.out.println(">>>Ingredient: " + ingredientName);

        }
        else // Read method
        {

        }

        }

        depth = xmlParser.getDepth();
        }
        }
        }*/