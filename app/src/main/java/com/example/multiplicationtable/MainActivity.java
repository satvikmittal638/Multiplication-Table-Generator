package com.example.multiplicationtable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView tables;
SeekBar seekTable;
TextView tabName;
Integer i=1;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekTable=findViewById(R.id.seekTable);
        tables=findViewById(R.id.tables);
        tabName=findViewById(R.id.tabname);
        seekTable.setMax(20);
        seekTable.setMin(1);
        ArrayList<String> defaultlist=new ArrayList<>();
       ArrayAdapter<String> defl=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,defaultlist);
       tables.setAdapter(defl);
       for(i=1;i<=10;i++)
       {
           String table1="1X"+i.toString()+"="+i.toString();
           defaultlist.add(table1);
       }



        seekTable.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ArrayList<String> tableList=new ArrayList<>();
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(MainActivity.this,android.R.layout.simple_list_item_1,tableList);
                tables.setAdapter(arrayAdapter);
                tableList.clear();
                tabName.setText("Table of "+progress);
                for (i=1;i<=10;i++)
                {
                    Integer progNo=progress,I=i,product=progress*i;
                    String tableLine=progNo.toString()+"X"+I.toString()+"="+product.toString();
                    tableList.add(tableLine);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}