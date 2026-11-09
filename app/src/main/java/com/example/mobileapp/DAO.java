package com.example.mobileapp;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {

    @Query("SELECT * FROM recipes")
    List<Recipe> getAll();

    @Insert
    void insert(Recipe recipe);

    @Delete
    void delete(Recipe recipe);


}
