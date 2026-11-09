package com.example.mobileapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Context;

import java.util.concurrent.Executors;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView message;
    EditText username, password;
    Button btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message);
        message.setVisibility(TextView.GONE);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.login);

        btnLogin.setOnClickListener(view -> {
            String user = username.getText().toString();
            String pass = password.getText().toString();

            login(user, pass);
        } );

        RecipeDatabase db = RecipeDatabase.getDatabase(getApplicationContext());

        Executors.newSingleThreadExecutor().execute(() -> {

            Recipe recipe = new Recipe("Title", "Description", "Ingredients", "Instructions");
            db.recipeDao().insert(recipe);

        });

        Executors.newSingleThreadExecutor().execute(() -> {
            List<Recipe> recipes = db.recipeDao().getAll();

            runOnUiThread(() -> {
                //Update UI
            });
        });

    }

    private void login(String user, String pass)
    {
        message.setVisibility(TextView.GONE);
        if (user.equals("admin") && pass.equals("pass"))
        {
            Toast.makeText(this, "Login Sucessful", Toast.LENGTH_SHORT).show();

            message.setText("Login Successful!");
            message.setVisibility(TextView.VISIBLE);
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
            message.setText("Login Failed!");
            message.setVisibility(TextView.VISIBLE);

        }
    }

}