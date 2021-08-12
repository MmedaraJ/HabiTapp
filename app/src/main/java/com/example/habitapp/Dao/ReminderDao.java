package com.example.habitapp.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.habitapp.Model.Reminder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@androidx.room.Dao
public interface ReminderDao {
    @Query("SELECT * FROM HabiTapp_Database")
    LiveData<List<Reminder>> getAllReminders();

    @Query("SELECT * FROM HabiTapp_Database WHERE reminder_completed = 0")
    LiveData<List<Reminder>> getAllUncompletedReminders();

    @Query("SELECT * FROM HabiTapp_Database WHERE reminder_completed = 1")
    LiveData<List<Reminder>> getAllCompletedReminders();

    @Query("SELECT * FROM HabiTapp_Database WHERE reminder_date_and_time =:date")
    LiveData<List<Reminder>> getTodayReminders(String date);

    @Query("SELECT * FROM HabiTapp_Database WHERE reminder_date_and_time =:date")
    LiveData<List<Reminder>> getFutureReminders(String date);

    @Query("SELECT * FROM HabiTapp_Database WHERE reminder_flagged = 1")
    LiveData<List<Reminder>> getAllFlaggedReminders();

    @Query("SELECT * FROM HabiTapp_Database ORDER BY reminder_priority DESC")
    LiveData<List<Reminder>> getHighToLowPriorityReminders();

    @Query("SELECT * FROM HabiTapp_Database ORDER BY reminder_priority ASC")
    LiveData<List<Reminder>> getLowToHighPriorityReminders();

    @Query("SELECT * FROM HabiTapp_Database WHERE reminder_list =:list")
    LiveData<List<Reminder>> getAllRemindersFromList(String list);

    @Insert
    void insertReminder(Reminder... reminder);

    @Query("DELETE FROM HabiTapp_Database WHERE id=:id")
    void deleteReminder(int id);

    @Update
    void updateReminder(Reminder reminder);
}
