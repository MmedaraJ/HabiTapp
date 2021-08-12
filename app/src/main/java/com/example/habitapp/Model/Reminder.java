package com.example.habitapp.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "HabiTapp_Database")
public class Reminder {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "reminder_title")
    public String reminderTitle;

    @ColumnInfo(name = "reminder_note")
    public String reminderNote;

    @ColumnInfo(name = "reminder_url")
    public String reminderUrl;

    @ColumnInfo(name = "reminder_date_and_time")
    public String reminderDateAndTime;

    @ColumnInfo(name = "reminder_repeat")
    public String reminderRepeat;

    @ColumnInfo(name = "reminder_location")
    public String reminderLocation;

    @ColumnInfo(name = "reminder_flagged")
    public boolean reminderFlagged;

    @ColumnInfo(name = "reminder_priority")
    public String reminderPriority;

    @ColumnInfo(name = "reminder_image")
    public String reminderImage;

    @ColumnInfo(name = "reminder_completed")
    public boolean reminderCompleted;

    @ColumnInfo(name = "reminder_list")
    public String reminderList;
}