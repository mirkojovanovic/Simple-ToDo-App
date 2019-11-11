package com.example.android.basictodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvList)
    RecyclerView mListRecyclerView;

    ArrayList<ListItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        ItemsAdapter adapter = new ItemsAdapter(items);

        mListRecyclerView.setAdapter(adapter);

        mListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
