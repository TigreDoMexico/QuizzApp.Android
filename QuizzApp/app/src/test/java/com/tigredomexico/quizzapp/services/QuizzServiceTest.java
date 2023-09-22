package com.tigredomexico.quizzapp.services;

import com.tigredomexico.quizzapp.models.Quizz;
import com.tigredomexico.quizzapp.models.Result;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuizzServiceTest {
    @Test
    public void Given_CorrectAnswer_When_UpdateScoreBySelection_Should_ReturnTrue() {
        int correct_index = 1;

        QuizzService service = new QuizzService(CreateQuizzes(2, correct_index));
        boolean result = service.UpdateScoreBySelection(correct_index);

        assertTrue(result);
    }

    @Test
    public void Given_WrongAnswer_When_UpdateScoreBySelection_Should_ReturnFalse() {
        int correct_index = 1;

        QuizzService service = new QuizzService(CreateQuizzes(2, correct_index));
        boolean result = service.UpdateScoreBySelection(correct_index + 1);

        assertFalse(result);
    }

    @Test
    public void Given_TwoQuestions_When_SetNextQuestion_Should_ReturnTrue() {
        QuizzService service = new QuizzService(CreateQuizzes(2, 1));
        boolean result = service.SetNextCurrentQuizz();

        assertTrue(result);
    }

    @Test
    public void Given_TwoQuestions_When_SetNextQuestionThreeTimes_Should_LastCallReturnFalse() {
        QuizzService service = new QuizzService(CreateQuizzes(2, 1));
        service.SetNextCurrentQuizz();
        service.SetNextCurrentQuizz();
        boolean result = service.SetNextCurrentQuizz();

        assertFalse(result);
    }

    @Test
    public void Given_TwoQuestionsWithAllCorrectAnswers_When_GetResults_Should_ReturnCorrectResult() {
        int correct_index = 1;
        QuizzService service = new QuizzService(CreateQuizzes(2, correct_index));

        service.UpdateScoreBySelection(correct_index);
        service.UpdateScoreBySelection(correct_index);

        Result result = service.GetQuizzResults();

        assertEquals(result.getScore(), "2");
        assertEquals(result.getTotal(), "2");
        assertEquals(result.getPercentage(), "100,00");
    }

    @Test
    public void Given_TwoQuestionsWithAllWrongAnswers_When_GetResults_Should_ReturnCorrectResult() {
        int correct_index = 1;
        QuizzService service = new QuizzService(CreateQuizzes(1, correct_index));

        service.UpdateScoreBySelection(correct_index + 1);
        service.UpdateScoreBySelection(correct_index + 1);

        Result result = service.GetQuizzResults();

        assertEquals(result.getScore(), "0");
        assertEquals(result.getTotal(), "1");
        assertEquals(result.getPercentage(), "0,00");
    }

    @Test
    public void Given_TwoQuestionsWithHalfQuestionsCorrect_When_GetResults_Should_ReturnCorrectResult() {
        int correct_index = 1;
        QuizzService service = new QuizzService(CreateQuizzes(2, correct_index));

        service.UpdateScoreBySelection(correct_index);
        service.UpdateScoreBySelection(correct_index + 1);

        Result result = service.GetQuizzResults();

        assertEquals(result.getScore(), "1");
        assertEquals(result.getTotal(), "2");
        assertEquals(result.getPercentage(), "50,00");
    }

    @Test
    public void Given_TwoQuestions_When_GetCurrentQuestion_Should_ReturnFirstQuestion() {
        ArrayList<Quizz> quizzes = (ArrayList<Quizz>) CreateQuizzes(2, 1);
        QuizzService service = new QuizzService(quizzes);

        Quizz result = service.GetCurrentQuizz();

        assertEquals(result.getPergunta(), quizzes.get(0).getPergunta());
        assertEquals(result.getRespostaCorreta(), quizzes.get(0).getRespostaCorreta());
    }

    private List<Quizz> CreateQuizzes(int quantity, int correctIndex) {
        ArrayList<Quizz> quizzes = new ArrayList<>();

        for(int i = 0; i < quantity; i++) {
            Quizz quizz = new Quizz("Question " + 1, Arrays.asList("Answer1", "Answer2", "Answer3"), correctIndex);
            quizzes.add(quizz);
        }

        return quizzes;
    }
}
