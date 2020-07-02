package com.roni.videoflow.Repository;

import com.roni.videoflow.Models.VideoItemModel;

import java.util.ArrayList;

public class VideoItems {


    public static ArrayList<VideoItemModel> getItems() {
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


        currentItem = new VideoItemModel();
        currentItem.setVideoURL("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4");
        currentItem.setVideoTitle("Sintel is an independently produced short film, initiated by the Blender Foundation as a means to further improve and validate the free/open source 3D creation suite Blender.");
        currentItem.setThumbnailUrl("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/Sintel.jpg");
        currentItem.setUsername("Sintel");
        items.add(currentItem);


        currentItem = new VideoItemModel();
        currentItem.setVideoURL("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/SubaruOutbackOnStreetAndDirt.mp4");
        currentItem.setVideoTitle("Smoking Tire takes the all-new Subaru Outback to the highest point we can find in hopes our customer-appreciation Balloon Launch will get some free T-shirts into the hands of our viewers.");
        currentItem.setThumbnailUrl("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/images/SubaruOutbackOnStreetAndDirt.jpg");
        currentItem.setUsername("By Garage419");
        items.add(currentItem);


        return items;

    }
}
