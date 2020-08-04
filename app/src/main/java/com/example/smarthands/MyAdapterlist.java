package com.example.smarthands;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.INotificationSideChannel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapterlist extends RecyclerView.Adapter<MyAdapterlist.ViewHolder>{

    private List<Listitem> listItems;
    private Context context;

    public MyAdapterlist(List<Listitem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cardview,viewGroup,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final Listitem listItem = listItems.get(i);
        viewHolder.head.setText(listItem.getHead());

        viewHolder.relativeLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = null;

                switch(i){
                    case 0:
                        intent = new Intent(context,Words.class);
                        break;
                    case 1:
                        intent = new Intent(context,Sentence.class);
                        break;
                    case 2:
                        intent = new Intent(context,AtoZ.class);
                        break;
                    case 3:
                        intent = new Intent(context,Digits.class);
                        break;
                    case 4:
                        intent = new Intent(context,Colors.class);
                        break;
                }


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

        public ViewHolder(View itemView) {
            super(itemView);

            head = (TextView)itemView.findViewById(R.id.header);
            relativeLayout = itemView.findViewById(R.id.list);
        }

    }
}
