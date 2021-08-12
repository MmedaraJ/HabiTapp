package com.example.habitapp.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.habitapp.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    private ActivityScenario<MainActivity> mainActivity;

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mainActivity = activityScenarioRule.getScenario();
        Intents.init();
    }
    /*
    @Test
    public void testSearchView(){
        onView(withId(R.id.homeSearchView)).check(matches(withHint("Search")));
        onView(withId(R.id.homeSearchView)).perform(click()).perform(typeText("Test search"));
        onView(withId(R.id.homeSearchView)).check(matches(withText("Test search")));
    }*/

    @Test
    public void testCreateNewReminder(){
        onView(withId(R.id.addNewReminderTv)).perform(click());
        intended(hasComponent(CreateNewReminderActivity.class.getName()));
    }

    @Test
    public void testAddList(){
        onView(withId(R.id.addList)).perform(click());
        intended(hasComponent(AddListActivity.class.getName()));
    }

    @After
    public void tearDown() throws Exception {
        Intents.release();
    }
}