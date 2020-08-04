package com.example.smarthands;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class imageAdapter extends RecyclerView.Adapter<imageAdapter.ViewHolder> {
    private List<Listitem> listItems;
    private Context context;

    public imageAdapter(List<Listitem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public imageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview,viewGroup,false);

        return new imageAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull imageAdapter.ViewHolder viewHolder, final int i) {
        final Listitem listItem = listItems.get(i);
        viewHolder.head.setText(listItem.getHead());
        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Image.class);
                intent.putExtra("header",listItem.getHead());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView head;
        public RelativeLayout relativeLayout;
        public ViewHolder(View v) {
            super(v);
            head = (TextView)itemView.findViewById(R.id.header);
            relativeLayout = itemView.findViewById(R.id.list);
        }
    }
}
