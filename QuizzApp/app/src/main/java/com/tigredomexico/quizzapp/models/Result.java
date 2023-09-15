package com.tigredomexico.quizzapp.models;

import java.io.Serializable;
import java.text.DecimalFormat;

public class Result implements Serializable {
    private final int score;
    private final int total;
    private final float percentage;

    public Result(int score, int total) {
        this.score = score;
        this.total = total;
        this.percentage = (float) score / (float) total * 100;
    }

    public String getScore() {
        return String.valueOf(this.score);
    }

    public String getTotal() {
        return String.valueOf(this.total);
    }

    public String getPercentage() {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(this.percentage);
    }
}
