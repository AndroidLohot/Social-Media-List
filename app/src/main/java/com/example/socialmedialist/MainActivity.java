package com.example.socialmedialist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.RecyclerViewEvent{

    private RecyclerView rvList;
    private ArrayList<WebSite> webSitesList;
    private MyAdapter myAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvList = findViewById(R.id.rvList);
        webSitesList = new ArrayList<>();
        myAdapter = new MyAdapter(this, webSitesList);
        layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(myAdapter);

        WebSite webSite = new WebSite();

        webSite.setSiteName("Google");
        webSite.setSiteImage("https://pbs.twimg.com/profile_images/1455185376876826625/s1AjSxph_400x400.jpg");

        webSitesList.add(webSite);

    }

    @Override
    public void setOnItemClickListener(int position) {

        Toast.makeText(this, "Website name : "+webSitesList.get(position).getSiteName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(getApplicationContext(),  DetailActivity.class);

        intent.putExtra("website",  webSitesList.get(position));

        startActivity(intent);


    }
}