package com.roni.videoflow.ViewHolders;

import android.content.Context;
import android.content.Intent;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.roni.videoflow.Models.VideoItemModel;
import com.roni.videoflow.R;
import com.roni.videoflow.FeedConcept.VideoFullScreenActivity;

public class VideoItemViewHolder extends RecyclerView.ViewHolder {


    //initialising the viewholder variables

    TextView videoTitle, username, date, commentCount, viewCount, likeCount, dislikeCount;
    ImageView thumbMail, playButton;

    public VideoItemViewHolder(View itemView) {
        super(itemView);

        videoTitle = itemView.findViewById(R.id.title);
        username = itemView.findViewById(R.id.username);
        date = itemView.findViewById(R.id.post_date);
        viewCount = itemView.findViewById(R.id.view_count);
        commentCount = itemView.findViewById(R.id.comment_count);
        likeCount = itemView.findViewById(R.id.like_count);
        dislikeCount = itemView.findViewById(R.id.dislike_count);

        thumbMail = itemView.findViewById(R.id.thumbnail);
        playButton = itemView.findViewById(R.id.play_button);


    }


    public void setVideoItem(final VideoItemModel currentVideoModel, final Context context){

        videoTitle.setText(currentVideoModel.getVideoTitle());
        username.setText(currentVideoModel.getUsername());
        date.setText(currentVideoModel.getDate());
        viewCount.setText(currentVideoModel.getViewCount());
        commentCount.setText(currentVideoModel.getCommentCount());
        likeCount.setText(currentVideoModel.getLikeCount());
        dislikeCount.setText(currentVideoModel.getDislikeCount());

        Glide.with(context).load(currentVideoModel.getThumbnailUrl()).into(thumbMail);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, VideoFullScreenActivity.class);
                intent.putExtra("item", currentVideoModel);
                context.startActivity(intent);


            }
        });


    }
}
