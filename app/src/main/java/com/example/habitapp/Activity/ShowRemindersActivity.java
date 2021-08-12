package com.example.habitapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.habitapp.R;
import com.example.habitapp.databinding.ActivityCreateNewReminderBinding;
import com.example.habitapp.databinding.ActivityShowRemindersBinding;

public class ShowRemindersActivity extends AppCompatActivity {
    private ActivityShowRemindersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowRemindersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.backToCategories.setOnClickListener(v -> {
            finish();
        });

        binding.reminderSettings.setOnClickListener(v -> {
            Intent i = new Intent(ShowRemindersActivity.this, ReminderSettingsActivity.class);
            startActivity(i);
        });
    }
}