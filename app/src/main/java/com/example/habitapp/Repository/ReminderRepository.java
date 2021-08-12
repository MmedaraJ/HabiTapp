package com.example.habitapp.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.habitapp.Dao.ReminderDao;
import com.example.habitapp.Database.HabiTappDatabase;
import com.example.habitapp.Model.Reminder;

import java.util.List;

public class ReminderRepository {
    public ReminderDao reminderDao;
    public LiveData<List<Reminder>> getAllReminders;
    public LiveData<List<Reminder>> getAllUncompletedReminders;
    public LiveData<List<Reminder>> getAllCompletedReminders;
    public LiveData<List<Reminder>> getTodayReminders;
    public LiveData<List<Reminder>> getFutureReminders;
    public LiveData<List<Reminder>> getAllFlaggedReminders;
    public LiveData<List<Reminder>> getHighToLowPriorityReminders;
    public LiveData<List<Reminder>> getLowToHighPriorityReminders;
    public LiveData<List<Reminder>> getAllRemindersFromList;

    public ReminderRepository(Application application){
        HabiTappDatabase database = HabiTappDatabase.getDatabaseInstance(application);
        reminderDao = database.getReminderDao();
        getAllReminders = reminderDao.getAllReminders();
        getAllUncompletedReminders = reminderDao.getAllUncompletedReminders();
        getAllCompletedReminders = reminderDao.getAllCompletedReminders();
        getTodayReminders = reminderDao.getTodayReminders("today");
        getFutureReminders = reminderDao.getFutureReminders("future");
        getAllFlaggedReminders = reminderDao.getAllFlaggedReminders();
        getHighToLowPriorityReminders = reminderDao.getHighToLowPriorityReminders();
        getLowToHighPriorityReminders = reminderDao.getLowToHighPriorityReminders();
    }

    public void getAllRemindersFromList(String list) {
        reminderDao.getAllRemindersFromList(list);
    }

    public void insertReminder(Reminder reminder) {reminderDao.insertReminder(reminder);}

    public void deleteReminder(int id) {reminderDao.deleteReminder(id);}

    public void updateReminder(Reminder reminder) {reminderDao.updateReminder(reminder);}

}
