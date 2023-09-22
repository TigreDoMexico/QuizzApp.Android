package com.tigredomexico.quizzapp.activity;

import android.content.Intent;

import com.tigredomexico.quizzapp.R;
import com.tigredomexico.quizzapp.ResultActivity;
import com.tigredomexico.quizzapp.models.Result;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class ResultActivityTest {
    private final Result result = new Result(5, 10);

    @Test
    public void When_ShowResultActivity_Should_PresentAllLabelsAndButton() {
        ActivityScenario<ResultActivity> scenario = InitializeActivity();

        Espresso.onView(ViewMatchers.withId(R.id.final_textlabel)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.score_textlabel)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.percentage_textlabel)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.tryagain_btn)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        scenario.close();
    }

    @Test
    public void When_ShowResultActivity_Should_BindAllInformationInTheLabels() {
        ActivityScenario<ResultActivity> scenario = InitializeActivity();

        String expectedScoreText = "Você acertou 5 de 10 questões";
        String expectedPercentageText = "Pontuação Final: 50.00 %";

        Espresso.onView(ViewMatchers.withId(R.id.score_textlabel))
                .check(ViewAssertions.matches(ViewMatchers.withText(expectedScoreText)));

        Espresso.onView(ViewMatchers.withId(R.id.percentage_textlabel))
                .check(ViewAssertions.matches(ViewMatchers.withText(expectedPercentageText)));

        scenario.close();
    }

    @Test
    public void When_ClickTryAgainButton_Should_GotoMainActivity() {
        ActivityScenario<ResultActivity> scenario = InitializeActivity();

        Espresso.onView(ViewMatchers.withId(R.id.tryagain_btn)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.iniciar_button)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        scenario.close();
    }

    private ActivityScenario<ResultActivity> InitializeActivity() {
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), ResultActivity.class);
        intent.putExtra("result", this.result);

        return ActivityScenario.launch(intent);
    }
}
