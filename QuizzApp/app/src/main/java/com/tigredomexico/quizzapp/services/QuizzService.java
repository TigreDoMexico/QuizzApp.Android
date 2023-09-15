package com.tigredomexico.quizzapp.services;

import com.tigredomexico.quizzapp.models.Quizz;
import com.tigredomexico.quizzapp.models.Result;

import java.util.List;

public class QuizzService {
    private final List<Quizz> quizzes;
    private int currentQuizz = 0;
    private int score = 0;

    public QuizzService() {
        quizzes = Quizz.GerarPerguntasAleatorias();
    }

    public boolean UpdateScoreBySelection(int indexSelected) {
        if(GetCurrentQuizz().getRespostaCorreta() == indexSelected) {
            score++;
            return true;
        }

        return false;
    }

    public boolean SetNextCurrentQuizz() {
        if(this.currentQuizz < quizzes.size() - 1) {
            currentQuizz++;
            return true;
        }
        return false;
    }

    public Result GetQuizzResults() {
        return new Result(this.score, this.quizzes.size());
    }

    public Quizz GetCurrentQuizz() {
        return quizzes.get(currentQuizz);
    }
}
