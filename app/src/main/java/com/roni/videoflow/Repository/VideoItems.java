package com.roni.videoflow.Repository;

import com.roni.videoflow.Models.VideoItemModel;

import java.util.ArrayList;

public class VideoItems {



    public static ArrayList<VideoItemModel> getItems(){
        ArrayList<VideoItemModel> items = new ArrayList<>();

       VideoItemModel currentItem = new VideoItemModel();
       currentItem.setVideoURL("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4");
       currentItem.setVideoTitle("Big Buck Bunny tells the story of a giant rabbit with a heart bigger than himself.");
       currentItem.setThumbnailUrl("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/BigBuckBunny.jpg");
       currentItem.setUsername("Big Buck Bunny");
       items.add(currentItem);

       currentItem = new VideoItemModel();
        currentItem.setVideoURL("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4");
        currentItem.setVideoTitle("The first Blender Open Movie from 2006");
        currentItem.setThumbnailUrl("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ElephantsDream.jpg");
        currentItem.setUsername("Elephant Dream");
        items.add(currentItem);

        currentItem = new VideoItemModel();
        currentItem.setVideoURL("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4");
        currentItem.setVideoTitle("HBO GO now works with Chromecast -- the easiest way to enjoy online video on your TV.");
        currentItem.setThumbnailUrl("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/ForBiggerBlazes.jpg");
        currentItem.setUsername("For Bigger Blazes");
        items.add(currentItem);



        return items;

    }
}
