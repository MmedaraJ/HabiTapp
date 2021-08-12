package com.example.habitapp.ViewModel;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.example.habitapp.Dao.ReminderDao;
import com.example.habitapp.Database.HabiTappDatabase;
import com.example.habitapp.Model.Reminder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReminderViewModelTest {
    private ReminderDao reminderDao;
    private HabiTappDatabase db;
    private ReminderViewModel viewModel;
    private Context context;
    private Reminder reminder;

    @Before
    public void setUp() throws Exception {
        context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, HabiTappDatabase.class).build();
        reminderDao = db.getReminderDao();
        viewModel = new ReminderViewModel(viewModel.getApplication());
    }

    @Test
    public void testReminderViewModel(){
        viewModel.insertReminder(reminder);
    }

    @After
    public void tearDown() throws Exception {
    }
}