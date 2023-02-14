package com.example.myapplicationrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class recyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<ModalClass>arrayList;
    private final RecyclerItemClickListener listener;

    public interface RecyclerItemClickListener {
        void onRecyclerItemClick(String checklistName);
    }

    public recyclerViewAdapter(Context context, ArrayList<ModalClass> arrayList, RecyclerItemClickListener listener){

        this.context = context;
        this.arrayList=arrayList;
        this.listener=listener;
    }
    public class StatusViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public StatusViewHolder(View view) {
            super(view);
            textView=view.findViewById(R.id.textView);
            //arrowiconImage=view.findViewById(R.id.arrow_image);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new StatusViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        StatusViewHolder statusViewHolder=(StatusViewHolder) holder;
        statusViewHolder.textView.setText(arrayList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
