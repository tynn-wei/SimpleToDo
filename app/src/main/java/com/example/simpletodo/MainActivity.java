package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etTaskEntry;
    Button btnAdd;
    Button btnClear;
    ListView lvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTaskEntry = findViewById(R.id.etTaskEntry);
        btnAdd = findViewById(R.id.buttonAdd);
        btnClear = findViewById(R.id.buttonClear);
        lvTasks = findViewById(R.id.lvTasks);

        ArrayList<String> alTasks = new ArrayList<>();
        ArrayAdapter<String> aaTasks = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alTasks);
        lvTasks.setAdapter(aaTasks);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todo = etTaskEntry.getText().toString();
                alTasks.add(todo);
                aaTasks.notifyDataSetChanged();
                etTaskEntry.setText(null);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String todo = etTaskEntry.getText().toString();
                alTasks.clear();
                aaTasks.notifyDataSetChanged();
            }
        });

    }
}