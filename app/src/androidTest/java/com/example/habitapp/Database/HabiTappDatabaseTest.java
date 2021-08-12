package com.example.habitapp.Database;

import static org.junit.Assert.*;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.habitapp.Dao.ReminderDao;
import com.example.habitapp.Model.Reminder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

@RunWith(AndroidJUnit4.class)
public class HabiTappDatabaseTest {
    private ReminderDao reminderDao;
    private HabiTappDatabase db;
    private static final String TAG = "TEST_DATABASE_00";

    @Before
    public void createDb(){
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, HabiTappDatabase.class).allowMainThreadQueries().build();
        reminderDao = db.getReminderDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void getAllReminders() throws Exception {
    }
}