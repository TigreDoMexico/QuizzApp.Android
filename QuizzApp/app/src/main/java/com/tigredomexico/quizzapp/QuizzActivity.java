package com.tigredomexico.quizzapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.tigredomexico.quizzapp.models.Quizz;
import com.tigredomexico.quizzapp.services.QuizzService;

import java.util.ArrayList;

public class QuizzActivity extends AppCompatActivity {

    private final QuizzService service = new QuizzService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);

        configureQuizz();
    }

    private final View.OnClickListener answerClickListener = view -> {
        Button button = findViewById(view.getId());
        Integer tagPressed = Integer.parseInt(view.getTag().toString());

        boolean isCorrect = service.UpdateScoreBySelection(tagPressed);

        System.out.println(button.getText());

        if(isCorrect) {
            button.setBackgroundTintList(ContextCompat.getColorStateList(QuizzActivity.this, R.color.correct_answer));
        } else {
            button.setBackgroundTintList(ContextCompat.getColorStateList(QuizzActivity.this, R.color.wrong_answer));
        }

        if(service.SetNextCurrentQuizz()) {
            configureNextQuizz();
        }
    };

    private void configureQuizz() {
        Quizz currentQuizz = service.GetCurrentQuizz();

        TextView quizzTitle = findViewById(R.id.quizzTitle);
        quizzTitle.setText(currentQuizz.getPergunta());

        ArrayList<Integer> answers = new ArrayList<>();
        answers.add(R.id.answer1);
        answers.add(R.id.answer2);
        answers.add(R.id.answer3);

        for(int i = 0; i < answers.size(); i++) {
            Button btn = findViewById(answers.get(i));
            btn.setText(currentQuizz.getResposta(i));

            btn.setOnClickListener(answerClickListener);
            btn.setBackgroundTintList(ContextCompat.getColorStateList(this, R.color.action_principal));
        }
    }

    private void configureNextQuizz() {
        CountDownTimer timer = new CountDownTimer(1000, 500) {
            @Override
            public void onTick(long millisUntilFinished) { }
            @Override
            public void onFinish() { configureQuizz(); }
        };

        timer.start();
    }
}