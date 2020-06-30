package com.roni.videoflow.Models;

import java.io.Serializable;

public class VideoItemModel implements Serializable {

    String videoURL, videoTitle, username, date, viewCount, commentCount, likeCount, dislikeCount, thumbnailUrl;

    public VideoItemModel() {

        this.commentCount=this.likeCount = this.dislikeCount = this.viewCount = "10k";
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public void setVideoTitle(String videoTitle) {
        this.videoTitle = videoTitle;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setViewCount(String viewCount) {
        this.viewCount = viewCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public void setDislikeCount(String dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getUsername() {
        return username;
    }

    public String getDate() {
        return date;
    }

    public String getViewCount() {
        return viewCount;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public String getDislikeCount() {
        return dislikeCount;
    }
}
