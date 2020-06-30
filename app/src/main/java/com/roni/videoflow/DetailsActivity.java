package com.roni.videoflow;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DetailsActivity extends AppCompatActivity {

    TextView filePath;
    ImageView thumbmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        filePath = (TextView)findViewById(R.id.filePath);
        filePath.setText(intent.getStringExtra("filepath"));

        thumbmail = (ImageView)findViewById(R.id.thumbnail);
        Bitmap thumbmailBitmap = ThumbnailUtils.createVideoThumbnail(intent.getStringExtra("filepath"), MediaStore.Video.Thumbnails.MINI_KIND);

        thumbmail.setImageBitmap(thumbmailBitmap);

    }
}
