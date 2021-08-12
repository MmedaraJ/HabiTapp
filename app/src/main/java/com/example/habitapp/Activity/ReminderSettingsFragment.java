package com.example.habitapp.Activity;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.habitapp.R;

public class ReminderSettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.reminder_preferences, rootKey);
    }
}