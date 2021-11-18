package com.example.myapplication;

public final class Ingredient
{
    private final String name;
    private final String description;
    private double price;



    public Ingredient(String name, String description, double price)
    {
        this(name, description);
        this.price = price;
    }

    public Ingredient(String name, String description)
    {
        this.name = name;
        this.description = description;
        this.price = 0.0f;
    }

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public double getPrice() { return price; }
}
