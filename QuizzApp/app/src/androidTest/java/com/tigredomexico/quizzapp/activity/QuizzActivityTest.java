package com.tigredomexico.quizzapp.activity;

import android.graphics.drawable.ColorDrawable;
import android.view.View;

import com.tigredomexico.quizzapp.QuizzActivity;
import com.tigredomexico.quizzapp.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.core.content.ContextCompat;
import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

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

    @Test
    public void When_ClickCorrectButton_Should_ChangeColorButtonToCorrectColor() {
        ActivityScenario<QuizzActivity> scenario = ActivityScenario.launch(QuizzActivity.class);
        Espresso.onView(ViewMatchers.withId(R.id.answer1)).perform(ViewActions.click());

        int expectedColor = ContextCompat.getColor(InstrumentationRegistry.getInstrumentation().getTargetContext(), R.color.correct_answer);
        Espresso.onView(ViewMatchers.withId(R.id.answer1)).check(ViewAssertions.matches(withBackgroundColor(expectedColor)));

        scenario.close();
    }

    public static Matcher<View> withBackgroundColor(final int expectedColor) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("with background color: " + expectedColor);
            }

            @Override
            public boolean matchesSafely(View view) {
                if (view.getBackground() instanceof ColorDrawable) {
                    int backgroundColor = ((ColorDrawable) view.getBackground()).getColor();
                    return backgroundColor == expectedColor;
                }
                return false;
            }
        };
    }
}
