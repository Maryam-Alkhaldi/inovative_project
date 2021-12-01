package com.example.myapplication;
public final class Ingredient
{
    private final String name;
    private final String description;
    private double price;
    private double quantity;
    private String units;


    public Ingredient(String name, String description, double price, double quantity, String units)
    {
        this(name, description, quantity, units);
        this.price = price;
    }

    public Ingredient(String name, String description, double quantity, String units)
    {
        this.name = name;
        this.description = description;
        this.price = 0.0f;
        this.quantity = quantity;
        this.units = units;
    }

    public String getName() { return this.name; }
    public String getDescription() { return this.description; }
    public double getPrice() { return price; }
}
