package com.mfrancetic.timestablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private SeekBar slider;

    private int chosenNumber;

    private List<Integer> numberList;

    private ArrayAdapter arrayAdapter;

    private int minValue = 1;

    private int maxValue = 20;

    private int defaultValue = 10;

    private int step = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);
        slider = findViewById(R.id.slider);

        numberList = new ArrayList<>();

        if (chosenNumber < 1) {
            chosenNumber = 1;
        }

        updateList(chosenNumber);
        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                numberList);
        listView.setAdapter(arrayAdapter);
        slider.setProgress(defaultValue);
        slider.setMax((maxValue - minValue) / step);

        slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                chosenNumber = minValue + (i * step);
                updateList(chosenNumber);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void updateList(int chosenNumber) {
        numberList.clear();
        for (int i = 1; i <= 10; i++) {
            numberList.add(chosenNumber * i);
        }
    }
}