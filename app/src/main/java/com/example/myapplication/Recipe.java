package com.example.myapplication;

import java.util.ArrayList;

/**
 * A class representing a culinary recipe. The class consists of the members:
 * name:        A String representing the name of the recipe
 * description: A String representing a description for the recipe.
 * ingredients: An array representing the list of ingredients that make up the recipe.
 * price:       A double value representing the total price of the recipe. This
 * value is calculated dynamically
 *
 * Author: Calum Dawson*/

public final class Recipe
{
    private final String name;
    public final String description;
    private Ingredient ingredients[];
    private double price;

    // static values for calculating rating
    private static ArrayList<Double> ratings = new ArrayList<>();
    private static double finalRating;

    // ArrayList of Strings representing the steps to prepare the recipe
    private ArrayList<String> instructions;

    public Recipe(String name, String description)
    {
        instructions = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.ingredients = new Ingredient[20];

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
    public Recipe(String name, String description, Ingredient ingredientList[])
    {
        this(name, description);

        // Sanity check for list of ingredients. If an
        //Array of ingredients have been passed the reference for ingredients
        // is changed to the list of ingredients provided
        if(ingredientList.length != 0)
        {
            ingredients = ingredientList;
        }
        else
            calculatePrice(); // Calculate the total cost of the recipe.


    }

    /**
     * Accessor method for the name of the recipe.
     * @return String object holding the name of recipe.
     */
    public String getName() { return this.name; }

    /**
     * Accessor method for the description of the recipe.
     * @return String object containing a description of the recipe.
     */
    public String getDescription() { return this.description; }

    /**
     * Accessor method for the total cost of the recipe.
     * @return A double value representing the total cost of the recipe.
     */
    public double getPrice() { return this.price; }

    public ArrayList<String> getInstructions() { return this.instructions; }

    /**
     * Calculates the cost of the recipe by totaling the prices of individual
     * ingredients. The value is stored in the member variable price.
     * @return The to cost of the recipe.
     */
    public double calculatePrice()
    {
        this.price = 0.0; // Reset price value to zero to prevent erroneous values

        for(Ingredient i : ingredients)
        {
            this.price += i.getPrice();
        }
        return this.price;
    }

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
     * @return
     */
    public static ArrayList<Recipe> loadRecipes()
    {
        // Load a recipe from memory.
        // Must be a static method so it can be called to load/create
        // a recipe object
        return null;
    }

}
