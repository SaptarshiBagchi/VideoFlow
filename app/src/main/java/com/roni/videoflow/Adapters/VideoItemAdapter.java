package com.roni.videoflow.Adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.roni.videoflow.Models.VideoItemModel;
import com.roni.videoflow.R;
import com.roni.videoflow.ViewHolders.VideoItemViewHolder;

import java.util.ArrayList;

public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemViewHolder> {

    ArrayList<VideoItemModel> arrayList;
    Context context;

    public VideoItemAdapter(ArrayList<VideoItemModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @Override
    public VideoItemViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.feed_item, viewGroup, false);
        return new VideoItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoItemViewHolder videoItemViewHolder, int i) {

        //and the current item
        videoItemViewHolder.setVideoItem(arrayList.get(i), context);

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
