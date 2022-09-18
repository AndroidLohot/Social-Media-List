package com.example.socialmedialist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<WebSite> webSiteList;
    private RecyclerViewEvent event;

    public MyAdapter(Context context, ArrayList<WebSite> webSiteList) {
        this.webSiteList = webSiteList;
        this.event = (RecyclerViewEvent) context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rvl, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        WebSite webSite = webSiteList.get(position);

        holder.itemView.setTag(webSiteList.get(position));


        holder.tvWebName.setText(webSite.getSiteName());


        Glide
                .with(holder.itemView.getContext())
                .load(webSite.getSiteImage())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.ivWebSite);

        

    }

    @Override
    public int getItemCount() {
        return webSiteList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView tvWebName;
        private ImageView ivWebSite;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWebName = itemView.findViewById(R.id.tvWebName);
            ivWebSite = itemView.findViewById(R.id.ivWebSite);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    event.setOnItemClickListener( webSiteList.indexOf( (WebSite) itemView.getTag()));

                }
            });

        }
    }

    interface RecyclerViewEvent
    {
        void setOnItemClickListener(int position);
    }
}
