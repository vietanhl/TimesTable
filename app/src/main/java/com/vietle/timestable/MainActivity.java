package com.vietle.timestable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView timesTableListView;

    public void generateTimesTable (int timesTable){
        //  --Create Array of numbers--
        ArrayList<String> timesTableContent = new ArrayList<>();

        for (int i =1; i<=20; i++){

            timesTableContent.add(Integer.toString(i * timesTable));
        }

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTableListView.setAdapter(myArrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int timesTable = 20;
        timesTableListView = findViewById(R.id.timesTableList) ;
        //   --Seekbar--
        final SeekBar multiplyControl = findViewById (R.id.mySeekBar);
        multiplyControl.setMax(20);
        multiplyControl.setProgress(10); //This is the value when you open the app

        //   --SeekBar interactive--
        multiplyControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                //  --Setting min value--
                int min = 1;
                int timesTable;
                if (progress < min ){
                    timesTable = min;
                    // -- This prevents having the Seekbar having 1 twice --
                    multiplyControl.setProgress(min);
                } else {
                    timesTable = progress;
                }
                // Updates the values with the SeekBar
                generateTimesTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        generateTimesTable(20);
    }
}
