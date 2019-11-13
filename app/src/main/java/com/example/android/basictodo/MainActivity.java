package com.example.android.basictodo;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rvList)
    RecyclerView mListRecyclerView;

    @BindView(R.id.new_item_edit_text)
    TextView mNewItemEditText;

    private ArrayList<ListItem> items = new ArrayList<>();
    private ItemsAdapter itemsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        itemsAdapter = new ItemsAdapter(items);

        mListRecyclerView.setAdapter(itemsAdapter);

    }

    @OnClick(R.id.add_button)
    public void addListItem() {
        if (mNewItemEditText.getText().toString().length() > 0) {
            items.add(new ListItem(mNewItemEditText.getText().toString()));
            itemsAdapter.notifyItemInserted(items.size());
            mNewItemEditText.setText("");
        }
    }
}
