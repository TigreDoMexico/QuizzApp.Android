package com.tigredomexico.quizzapp.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ResultTest {
    private final int score;
    private final int total;
    private final String expectedScore;
    private final String expectedTotal;
    private final String expectedPercentage;

    public ResultTest(int score, int total, String expectedScore, String expectedTotal, String expectedPercentage) {
        this.score = score;
        this.total = total;
        this.expectedScore = expectedScore;
        this.expectedTotal = expectedTotal;
        this.expectedPercentage = expectedPercentage;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 10, 10, "10", "10", "100,00" },
                { 9, 10, "9", "10", "90,00" },
                { 1, 4, "1", "4", "25,00" },
                { 0, 4, "0", "4", "0,00" },
        });
    }

    @Test
    public void When_GetScore_Should_ReturnScoreInStringFormat() {
        Result res = new Result(score, total);
        assertEquals(res.getScore(), expectedScore);
    }

    @Test
    public void When_GetTotal_Should_ReturnTotalInStringFormat() {
        Result res = new Result(score, total);
        assertEquals(res.getTotal(), expectedTotal);
    }

    @Test
    public void When_GetPercentage_Should_ReturnTotalInStringFormat() {
        Result res = new Result(score, total);
        assertEquals(res.getPercentage(), expectedPercentage);
    }
}
