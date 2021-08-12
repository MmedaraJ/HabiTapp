package com.example.habitapp.Activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.app.Activity;

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
public class CreateNewReminderActivityTest {
    private ActivityScenario<CreateNewReminderActivity> createNewReminderActivity;

    @Rule
    public ActivityScenarioRule<CreateNewReminderActivity> activityScenarioRule = new ActivityScenarioRule<>(CreateNewReminderActivity.class);

    @Before
    public void setUp() throws Exception {
        createNewReminderActivity = activityScenarioRule.getScenario();
        Intents.init();
    }

    @Test
    public void cancelCreateNewReminder(){
        onView(withId(R.id.cancel_new_reminder)).perform(click());
        //assertThat(createNewReminderActivity.getResult(), r(Activity.RESULT_CANCELED));
        assertNull(createNewReminderActivity);
    }

    @After
    public void tearDown() throws Exception{
        Intents.release();
        createNewReminderActivity = null;
    }
}