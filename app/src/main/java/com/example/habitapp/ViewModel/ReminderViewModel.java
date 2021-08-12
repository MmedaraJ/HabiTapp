package com.example.habitapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.habitapp.Model.Reminder;
import com.example.habitapp.Repository.ReminderRepository;

import java.util.List;

public class ReminderViewModel extends AndroidViewModel {
    public ReminderRepository repository;
    public LiveData<List<Reminder>> getAllReminders;
    public LiveData<List<Reminder>> getAllUncompletedReminders;
    public LiveData<List<Reminder>> getAllCompletedReminders;
    public LiveData<List<Reminder>> getTodayReminders;
    public LiveData<List<Reminder>> getFutureReminders;
    public LiveData<List<Reminder>> getAllFlaggedReminders;
    public LiveData<List<Reminder>> getHighToLowPriorityReminders;
    public LiveData<List<Reminder>> getLowToHighPriorityReminders;

    public ReminderViewModel(@NonNull Application application) {
        super(application);
        repository = new ReminderRepository(application);
        getAllReminders = repository.getAllReminders;
        getAllUncompletedReminders = repository.getAllUncompletedReminders;
        getAllCompletedReminders = repository.getAllCompletedReminders;
        getTodayReminders = repository.getTodayReminders;
        getFutureReminders = repository.getFutureReminders;
        getAllFlaggedReminders = repository.getAllFlaggedReminders;
        getHighToLowPriorityReminders = repository.getHighToLowPriorityReminders;
        getLowToHighPriorityReminders = repository.getLowToHighPriorityReminders;
    }

    public void getAllRemindersFromList(String list){
        repository.getAllRemindersFromList(list);
    }

    public void insertReminder(Reminder reminder) {repository.insertReminder(reminder);}

    public void deleteReminder(int id) {repository.deleteReminder(id);}

    public void updateReminder(Reminder reminder) {repository.updateReminder(reminder);}
}
