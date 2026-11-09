package com.example.mobileapp;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "recipes")
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "ingredients")
    public String ingredients;

    @ColumnInfo(name = "instructions")
    public String instructions;

    public Recipe() {}

    public Recipe(String title, String description, String ingredients, String instructions) {

        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.instructions = instructions;

    }


}
