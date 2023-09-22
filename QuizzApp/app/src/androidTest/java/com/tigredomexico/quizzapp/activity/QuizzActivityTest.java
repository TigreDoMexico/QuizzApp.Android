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
public class QuizzActivityTest {
    @Test
    public void When_ShowQuizzActivity_Should_PresentAllButtonsAndText() {
        ActivityScenario<QuizzActivity> scenario = ActivityScenario.launch(QuizzActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.quizzTitle)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.answer1)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.answer2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.answer3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        scenario.close();
    }
}
