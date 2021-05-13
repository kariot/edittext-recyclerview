package me.kariot.demoapp;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ItemVH> {


    ArrayList<String> data;
    TextChangeCallback callback;

    public MyAdapter(ArrayList<String> data, TextChangeCallback callback) {
        this.data = data;
        this.callback = callback;
    }

    @NonNull

    @Override
    public ItemVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ItemVH holder, int position) {
        holder.editTextTextPersonName.setText(data.get(position));
        holder.editTextTextPersonName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.equals("")){
                    return;
                }
                callback.textChangedAt(position, String.valueOf(s));

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ItemVH extends RecyclerView.ViewHolder {
        TextView editTextTextPersonName;

        public ItemVH(@NonNull View itemView) {
            super(itemView);
            editTextTextPersonName = itemView.findViewById(R.id.editTextTextPersonName);
        }
    }

    public interface TextChangeCallback {
        void textChangedAt(int position, String text);
    }
}
