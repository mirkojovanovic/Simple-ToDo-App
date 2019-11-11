package com.example.android.basictodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private List<ListItem> mItemsList;

    public ItemsAdapter(List<ListItem> mItemsList) {
        this.mItemsList = mItemsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View itemView = inflater.inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ListItem item = mItemsList.get(position);

        TextView itemContentTextView = holder.itemContentTextView;

        itemContentTextView.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView itemContentTextView;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemContentTextView = itemView.findViewById(R.id.item_content);
        }
    }

}
