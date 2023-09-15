package com.tigredomexico.quizzapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tigredomexico.quizzapp.models.Result;

public class ResultActivity extends AppCompatActivity {

    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        result = (Result) intent.getSerializableExtra("result");

        configureResults();
    }

    private final View.OnClickListener newQuizzClickListener = view -> {
        Intent intent = new Intent(ResultActivity.this, MainActivity.class);
        startActivity(intent);
    };

    private void configureResults() {
        TextView scoreLabel = findViewById(R.id.score_textlabel);
        TextView percentageLabel = findViewById(R.id.percentage_textlabel);
        Button newQuizzButton = findViewById(R.id.tryagain_btn);

        String newScore = getNewScoreText(scoreLabel.getText().toString());
        String newPercent = getNewPercentageText(percentageLabel.getText().toString());

        scoreLabel.setText(newScore);
        percentageLabel.setText(newPercent);
        newQuizzButton.setOnClickListener(newQuizzClickListener);
    }

    private String getNewScoreText(String baseText) {
        return baseText.replace("{score}", result.getScore()).replace("{total}", result.getTotal());
    }

    private String getNewPercentageText(String baseText) {
        return baseText.replace("{percent}", result.getPercentage());
    }
}