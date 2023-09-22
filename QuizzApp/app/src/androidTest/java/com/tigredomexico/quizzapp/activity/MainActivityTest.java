package com.tigredomexico.quizzapp.activity;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.tigredomexico.quizzapp.MainActivity;
import com.tigredomexico.quizzapp.R;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Test
    public void When_ShowMainActivity_Should_PresentAButtonAndAnImage() {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.imageView3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        Espresso.onView(ViewMatchers.withId(R.id.iniciar_button)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        scenario.close();
    }

    @Test
    public void Given_MainActivity_When_ClickIniciarButton_Should_GoToNextActivity() {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);

        Espresso.onView(ViewMatchers.withId(R.id.iniciar_button)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.quizzTitle)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        scenario.close();
    }
}
