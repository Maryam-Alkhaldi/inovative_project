package com.example.myapplication;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class representing a culinary recipe. The class consists of the members:
 * name:        A String representing the name of the recipe
 * description: A String representing a description for the recipe.
 * ingredients: An array representing the list of ingredients that make up the recipe.
 * price:       A double value representing the total price of the recipe. This
 * value is calculated dynamically
 *
 */

public final class Recipe
{
    private String name;
    private String description;
    private String category;
    private String ingredients[];
    private String method[];
    private Integer price;
    private Integer id;

    // static values for calculating rating
    private static ArrayList<Double> ratings = new ArrayList<>();
    private static double finalRating;

    public Recipe(String name, String description, String cat, Integer price, Integer id)
    {
        this.name = name;
        this.description = description;
        this.ingredients = new String[20];
        this.category = cat;
        this.price = price;
        this.id = id;
    }

    /**
     * Initialises the recipe with name and list of ingredients.
     * The total price for all the ingredients is summed before
     * being assigned to the Recipe 'price' member variable.
     * pre: Takes a String argument representing a name, a string argument
     * representing a description of the recipe and an array of Ingredient
     * objects that represents the list of ingredients that make up the recipe.
     *
     * Constructs a recipe object.
     * */
    public Recipe(String name, String description, String category, Integer price, String ingredientList[], String methodList[], Integer id)
    {
        this(name, description, category, price, id);
        this.ingredients = ingredientList;
        this.method = methodList;
    }

    /**
     * Accessor methods for the name of the recipe.
     *
     */
    public String getName() { return this.name; }
    public void setName(String name){ this.name = name; }

    public String getDescription() { return this.description; }
    public void setDescription(String description){ this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category){ this.category = category; }

    public Integer getId() { return id; }

    public Integer getPrice() { return this.price; }
    public void setPrice(Integer price){ this.price = price; }

    public String[] getMethod() { return this.method; }

    public String[] getIngredients() { return this.ingredients; }

    /**
     * Calculates the average rating of the Recipe object it is called on.
     * The average rating is stored in the finalRating member variable.
     */
    public static void calculateRating()
    {
        double res = 0.;
        for(Double d : ratings)
            res += d;

        finalRating = res / ratings.size();
    }

    /**
     * Adds the vote parsed as an argument to the ArrayList of votes.
     * @param rating : The user vote for the recipe.
     */
    public static void vote(double rating)
    {
        ratings.add(rating);
    }

    /**
     * Loads a set of hardcoded Recipe objects from an XML document.
     * @return ArrayList of recipe objects.
     */
    private static Recipe createRecipe1(){
        /**
         * Hard Codes The Beef and Veggie Stew recipe
         */

        String recipeIngredients[] = new String[]
                {
                        "1 Onion",
                        "2 Carrots",
                        "8 Small Mushrooms",
                        "500g of Lean Beef",
                        "15ml of Cooking Oil",
                        "7.8g of Flour",
                        "600ml of Stock (Water+Beef Cube)",
                        "1 Bay Leaf",
                        "1 Pinch of Thyme"
                };

        String recipeMethod[] = new String[]
                {
                        "Prepare the Vegetables, peel and chop the onion and carrots. Slice the mushrooms in half.",
                        "With a clean knife on a clean board, dice the beef.",
                        "Brown the beef in the oil in a saucepan",
                        "Stir in the flour so the beef is covered",
                        "Add the vegetables to the saucepan",
                        "Pour in the stock and add the bay leaf and thyme",
                        "Bring to the boil and reduce to simmer. Cover with lid and cook for 1 hour."
                };

        Recipe recipe = new Recipe("Beef and Veggie Stew",
                "A humble stew cooked over the hob. Can be served with boiled or mashed potatoes.",
                "Lunch",
                12, recipeIngredients, recipeMethod, 1);

        return recipe;
    }

    private static Recipe createRecipe2(){
        /**
         * Hard Codes The Vegetarian Lasagne recipe
         */

        String recipeIngredients[] = new String[]
                {
                        "1 Onion",
                        "1 Carrot",
                        "1 Garlic Clove",
                        "2 Celery Sticks",
                        "15ml of Cooking Oil",
                        "100g Green Lentils",
                        "400g Chopped Tomatoes",
                        "1 teaspoon of Mixed Herbs",
                        "1 teaspoon of Tomato Puree",
                        "200ml Creme Fresh",
                        "25g of Grated Parmesan",
                        "100ml Semi-Skimmed Milk",
                        "Pinch of Black Pepper",
                        "6 Lasagne Sheets"
                };

        String recipeMethod[] = new String[]
                {
                        "Preheat the oven to 190C or Gas Mark 5.",
                        "Prepare the vegetables. Peel and chop the Onion and carrot, peel and crush the Garlic. Slice the Celery.",
                        "Fry the onion, garlic, carrot and celery in the oil until soft.",
                        "Add the lentils, tomatoes, herbs and tomato puree.",
                        "Pour in some water, just enough to cover the mixture, bring to the boil and simmer for 15 mins with the lid on.",
                        "Place an oven proof dish on a baking tray and spread some lentil mixture in the bottom, cover with a lasagne sheet and a little creme fresh.",
                        "Repeat the previous step finishing with the sauce on top.",
                        "Sprinkle the remaining grated cheese on top and bake for 20 minutes."
                };

        Recipe recipe = new Recipe("Vegetarian Lasagne",
                "A Simple Lasagne suitable for vegetarians",
                "Dinner",
                10, recipeIngredients, recipeMethod, 2);

        return recipe;
    }

    private static Recipe createRecipe3(){
        /**
         * Hard Codes The Pancakes Recipe
         */

        String recipeIngredients[] = new String[]
                {
                        "125g Flour",
                        "A Pinch of Salt",
                        "1 Egg",
                        "300ml of Milk",
                        "A Small amount of Lard"
                };

        String recipeMethod[] = new String[]
                {
                        "Mix the flour and salt, make a well in the centre and break the egg into it.",
                        "Add half the liquid, gradually work in the flour using a wooden spoon and beat until smooth.",
                        "Add the remaining liquid gradually and beat until well mixed and the surface is covered with tiny bubbles.",
                        "Melt just enough lard in a think pan to coat the bottom and sides, then pour off any surplus.",
                        "When the fat is hot, pour in a little batter to cover the bottom of the pan",
                        "Cook the pancake until it is golden brown on the underside, then toss or turn it over.",
                        "Turn out onto plate when both sides are golden.",
                        "Serve with your favourite toppings."
                };

        Recipe recipe = new Recipe("Pancakes",
                "Breakfast Pancakes, Simple and sweet.",
                "Breakfast",
                3, recipeIngredients, recipeMethod, 3);

        return recipe;
    }

    private static Recipe createRecipe4(){
        /**
         * Hard Codes The Mushroom Risotto recipe
         */

        String recipeIngredients[] = new String[]
                {
                        "1 Onion",
                        "150g of Chestnut Mushrooms",
                        "2 Garlic Cloves",
                        "250g of Risotto Rice",
                        "1 litre of boiling water",
                        "1 Tablespoon of cooking oil",
                        "A Vegetable Stock Cube",
                        "Tablespoon of Parmesan",
                        "1 Pinch of chopped Thyme"
                };

        String recipeMethod[] = new String[]
                {
                        "Prepare the Vegetables, peel and chop the onion, peel and crush the garlic. Slice the mushrooms.",
                        "Fry the onion and garlic until soft.",
                        "Add the mushrooms, and fry for another 2 minutes.",
                        "Stir in the rice.",
                        "Mix the stock with the water.",
                        "Add a little of the stock to the rice and keep stirring until the stock is absorbed.",
                        "Continue adding the stock until the rice cooks, this will take 20-25 minutes. The rice should be soft, but still retain a nutty bite.",
                        "Stir in the parmesan and thyme."
                };

        Recipe recipe = new Recipe("Mushroom Risotto",
                "A creamy mushroom and rice dish. An Italian classic.",
                "Dinner",
                10, recipeIngredients, recipeMethod, 4);

        return recipe;
    }

    private static Recipe createRecipe5(){
        /**
         * Hard Codes the Cheesecake recipe
         */

        String recipeIngredients[] = new String[]
                {
                        "60g Digestive Biscuits",
                        "30g of Melted Unsalted Butter",
                        "100g Full-Fat Cream Cheese",
                        "500ml of Double Cream",
                        "1/2 teaspoon of Vanilla",
                        "1 Tablespoon of icing sugar"
                };

        String recipeMethod[] = new String[]
                {
                        "Crush the digestive biscuits in a bowl.",
                        "Mix in the melted butter, and press the mixture into the bottom of the serving dish.",
                        "Add the Cream Cheese, Vanilla and icing sugar to a bowl. Whisk until smooth.",
                        "Spoon this on top of the biscuit mix and carefully level it.",
                        "Place the completed cheesecake in the fridge for an hour to let it set."
                };

        Recipe recipe = new Recipe("Cheesecake",
                "A small cheesecake",
                "Dessert",
                11, recipeIngredients, recipeMethod, 5);

        return recipe;
    }

    private static Recipe createRecipe6(){
        /**
         * Hard Codes The Banana Milkshake recipe
         */

        String recipeIngredients[] = new String[]
                {
                        "1 Banana",
                        "3 Scoops of Vanilla Ice Cream",
                        "Semi-Skimmed Milk"
                };

        String recipeMethod[] = new String[]
                {
                        "Peel and slice the Banana.",
                        "Add all Ice-Cream to a blender. Add enough milk to cover the ice-cream.",
                        "Blend until smooth."
                };

        Recipe recipe = new Recipe("Banana Milkshake",
                "A refreshing banana and vanilla milkshake",
                "Snack",
                2, recipeIngredients, recipeMethod, 6);

        return recipe;
    }


    public static ArrayList<Recipe> loadRecipesWorkaround() {

        ArrayList<Recipe> recipeList = new ArrayList<>();

        recipeList.add(createRecipe1());
        recipeList.add(createRecipe2());
        recipeList.add(createRecipe3());
        recipeList.add(createRecipe4());
        recipeList.add(createRecipe5());
        recipeList.add(createRecipe6());

        return recipeList;
    }

}
