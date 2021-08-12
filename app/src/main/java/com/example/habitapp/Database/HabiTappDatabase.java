package com.example.habitapp.Database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.habitapp.Dao.ReminderDao;
import com.example.habitapp.Model.Reminder;

@Database(
        entities = {Reminder.class},
        version = 2
)
public abstract class HabiTappDatabase extends RoomDatabase {
    public abstract ReminderDao getReminderDao();
    public static HabiTappDatabase INSTANCE;

    public static HabiTappDatabase getDatabaseInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    HabiTappDatabase.class,
                    "Reminder_Database").
                    addMigrations(MIGRATION_1_2).
                    fallbackToDestructiveMigration().
                    allowMainThreadQueries().
                    build();
        }
        return INSTANCE;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Habitapp_database ADD COLUMN reminder_list TEXT");
        }
    };
}
