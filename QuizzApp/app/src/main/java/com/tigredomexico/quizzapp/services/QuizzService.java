package com.tigredomexico.quizzapp.services;

import com.tigredomexico.quizzapp.models.Quizz;

import java.util.List;

public class QuizzService {
    private List<Quizz> quizzes;
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

    public Quizz GetCurrentQuizz() {
        return quizzes.get(currentQuizz);
    }
}
