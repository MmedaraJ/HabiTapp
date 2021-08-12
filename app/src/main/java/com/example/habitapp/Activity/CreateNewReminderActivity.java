package com.example.habitapp.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.habitapp.databinding.ActivityCreateNewReminderBinding;

public class CreateNewReminderActivity extends AppCompatActivity {
    private ActivityCreateNewReminderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCreateNewReminderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.cancelNewReminder.setOnClickListener(v -> {
            finish();
        });
    }
}