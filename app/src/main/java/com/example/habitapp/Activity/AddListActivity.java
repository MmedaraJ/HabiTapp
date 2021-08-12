package com.example.habitapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;

import com.example.habitapp.Adapter.ListColourIconsAdapter;
import com.example.habitapp.Adapter.ListIconIconsAdapter;
import com.example.habitapp.ItemDecorations.GridSpacingItemDecoration;
import com.example.habitapp.R;
import com.example.habitapp.databinding.ActivityAddListBinding;

public class AddListActivity extends AppCompatActivity implements View.OnClickListener, ListColourIconsAdapter.ColourIconSelected, ListIconIconsAdapter.IconIconSelected {
    private ActivityAddListBinding binding;
    private TypedArray colourIcons;
    private TypedArray iconIcons;
    private ListColourIconsAdapter listColourIconsAdapter;
    private ListIconIconsAdapter listIconIconsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setUpColourIconsRecycler();
        setUpIconIconsRecycler();

        setOnClickListener();
    }

    private void setUpColourIconsRecycler() {
        colourIcons = getResources().obtainTypedArray(R.array.list_colour_icons_array);
        listColourIconsAdapter = new ListColourIconsAdapter(this, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6, GridLayoutManager.VERTICAL, false);
        int spanCount = 6;
        int spacing = 10;
        binding.listColourIcons.setLayoutManager(gridLayoutManager);
        binding.listColourIcons.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, false));
        listColourIconsAdapter.setColourIcons(colourIcons);
        binding.listColourIcons.setAdapter(listColourIconsAdapter);
    }

    private void setUpIconIconsRecycler() {
        iconIcons = getResources().obtainTypedArray(R.array.list_icon_icons_array);
        listIconIconsAdapter = new ListIconIconsAdapter(this, this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 6, GridLayoutManager.VERTICAL, false);
        int spanCount = 6;
        int spacing = 10;
        binding.listIconIcons.setLayoutManager(gridLayoutManager);
        binding.listIconIcons.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, false));
        listIconIconsAdapter.setIconIcons(iconIcons);
        binding.listIconIcons.setAdapter(listIconIconsAdapter);
    }

    private void setOnClickListener(){
        binding.cancelAddList.setOnClickListener(this);
        binding.doneAddList.setOnClickListener(this);
    }

    private void showNewListOnMainActivity(){
        //hbhb yb
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel_add_list:
                finish();
                break;
            case R.id.done_add_list:
                showNewListOnMainActivity();
                break;

        }
    }

    @Override
    public void onColourItemClicked(int position) {

    }

    @Override
    public void onIconItemClicked(int position) {

    }
}