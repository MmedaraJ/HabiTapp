package com.example.habitapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.habitapp.Adapter.CategoryAdapter;
import com.example.habitapp.ItemDecorations.GridSpacingItemDecoration;
import com.example.habitapp.Model.Category;
import com.example.habitapp.R;
import com.example.habitapp.TouchListeners.ItemClickSupport;
import com.example.habitapp.ViewModel.ReminderViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private SearchView homeSearchView;
    private RecyclerView categoryRecycler;
    private CategoryAdapter categoryAdapter;
    private TextView addNewReminderTv;
    private TextView addList;
    private List<Category> categories;
    private ReminderViewModel viewModel;
    private static final String TAG = "MAIN_ACTIVITY";

    private int noUncompletedReminders;
    private int noFlaggedReminders;
    private int noTodayReminders;
    private int noFutureReminders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noUncompletedReminders = 0;
        noFlaggedReminders = 0;
        noTodayReminders = 0;
        noFutureReminders = 0;

        viewModel = ViewModelProviders.of(this).get(ReminderViewModel.class);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        addNewReminderTv = findViewById(R.id.addNewReminderTv);
        addList = findViewById(R.id.addList);

        setUpViewModel();

        setUpCategories();

        setAdapter();

        setOnClickListener();
    }

    private void setUpViewModel() {
        viewModel.getAllUncompletedReminders.observe(this, reminders -> {
            noUncompletedReminders = reminders.size();
        });
        viewModel.getAllFlaggedReminders.observe(this, reminders -> {
            noFlaggedReminders = reminders.size();
        });
        viewModel.getFutureReminders.observe(this, reminders -> {
            noFutureReminders = reminders.size();
        });
        viewModel.getTodayReminders.observe(this, reminders -> {
            noTodayReminders = reminders.size();
        });
    }

    private void setUpCategories() {
        categories = new ArrayList<>();
        Log.d(TAG, noUncompletedReminders + " uncompleted ");
        Log.d(TAG, noFlaggedReminders + " flagged ");
        Log.d(TAG, noFutureReminders + " future ");
        Log.d(TAG, noTodayReminders + " today ");
        categories.add(new Category("All", R.drawable.ic_baseline_featured_play_list_24, noUncompletedReminders, true));
        categories.add(new Category("Today", R.drawable.ic_baseline_today_24, noTodayReminders, true));
        categories.add(new Category("Future", R.drawable.ic_baseline_calendar_today_24, noFutureReminders, true));
        categories.add(new Category("Flagged", R.drawable.ic_baseline_flag_24, noFlaggedReminders, true));
    }

    private void setAdapter() {
        categoryAdapter = new CategoryAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        int spanCount = 2;
        int spacing = 50;
        categoryRecycler.setLayoutManager(gridLayoutManager);
        categoryRecycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, false));
        categoryAdapter.setCategories(categories);
        categoryRecycler.setAdapter(categoryAdapter);
        addClickSupportToRecycler(categoryRecycler, categories);
    }

    private void addClickSupportToRecycler(RecyclerView recycler, List<Category> categories){
        ItemClickSupport.addTo(recycler).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                Intent i = new Intent(MainActivity.this, ShowRemindersActivity.class);
                startActivity(i);
            }

            @Override
            public void onItemDoubleClicked(RecyclerView recyclerView, int position, View v) {

            }
        });
    }

    private void setOnClickListener(){
        addNewReminderTv.setOnClickListener(this);
        addList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addNewReminderTv:
                startActivity(new Intent(MainActivity.this, CreateNewReminderActivity.class));
                break;
            case R.id.addList:
                startActivity(new Intent(MainActivity.this, AddListActivity.class));
                break;
        }

    }
}