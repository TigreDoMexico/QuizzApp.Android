package com.tigredomexico.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.iniciar_button).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizzActivity.class);
            startActivity(intent);
        });
    }
}