package me.kariot.demoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView myRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRecyclerView = findViewById(R.id.my_recycler);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add("Person : " + i);
        }
        myRecyclerView.setAdapter(new MyAdapter(data, new MyAdapter.TextChangeCallback() {
            @Override
            public void textChangedAt(int position, String text) {
                data.set(position, text);
                Log.d("UPDATED LIST : ", String.valueOf(data));
            }
        }));

    }
}