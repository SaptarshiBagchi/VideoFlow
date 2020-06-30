package com.roni.videoflow.FeedConcept;

//import android.support.v7.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.roni.videoflow.Adapters.VideoItemAdapter;
import com.roni.videoflow.Models.VideoItemModel;
import com.roni.videoflow.R;
import com.roni.videoflow.Repository.VideoItems;

import java.util.ArrayList;

public class FeedActivity extends AppCompatActivity {

    RecyclerView feedList;
    private static final String TAG = "FeedActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        //ArrayList<VideoItemModel> items = VideoItems.getItems();

        feedList = (RecyclerView) findViewById(R.id.feedList);
        feedList.setLayoutManager(new LinearLayoutManager(this));

        feedList.setAdapter(new VideoItemAdapter(VideoItems.getItems(), this));

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            feedList.setLayoutManager(new GridLayoutManager(this, 2));
            Log.d(TAG, "onConfigurationChanged:  landscape");
            feedList.setAdapter(new VideoItemAdapter(VideoItems.getItems(), this));

        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            feedList.setLayoutManager(new LinearLayoutManager(this));
            Log.d(TAG, "onConfigurationChanged:  potrait");
            feedList.setAdapter(new VideoItemAdapter(VideoItems.getItems(), this));

        }


    }
}
