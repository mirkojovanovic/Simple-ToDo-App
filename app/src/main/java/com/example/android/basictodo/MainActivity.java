package com.example.android.basictodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvList)
    RecyclerView mListRecyclerView;

    @BindView(R.id.new_item_edit_text)
    TextView mNewItemEditText;

    private ArrayList<ListItem> items;

    private ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        items = new ArrayList<>();

        itemsAdapter = new ItemsAdapter(items);

        mListRecyclerView.setAdapter(itemsAdapter);

        mListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @OnClick(R.id.add_button)
    public void addListItem() {
        items.add(new ListItem(mNewItemEditText.getText().toString()));
        itemsAdapter.notifyItemInserted(items.size());
        mNewItemEditText.setText("");
    }
}
