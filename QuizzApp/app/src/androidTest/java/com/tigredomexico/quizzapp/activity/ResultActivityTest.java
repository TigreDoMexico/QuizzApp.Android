package com.tigredomexico.quizzapp.activity;

import com.tigredomexico.quizzapp.QuizzActivity;
import com.tigredomexico.quizzapp.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

@RunWith(AndroidJUnit4.class)
public class ResultActivityTest {
    @Test
    public void When_ShowResultActivity_Should_PresentAllLabensAndButton() {
        ActivityScenario<QuizzActivity> scenario = ActivityScenario.launch(QuizzActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.final_textlabel)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.score_textlabel)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.percentage_textlabel)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.tryagain_btn)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        scenario.close();
    }
}
