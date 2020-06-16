package com.roni.videoflow;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.deep.videotrimmer.DeepVideoTrimmer;
import com.deep.videotrimmer.interfaces.OnTrimVideoListener;

public class Trimmer2Activity extends AppCompatActivity implements OnTrimVideoListener {
    
    DeepVideoTrimmer mVideoTrimmer;
    private static final String TAG = "Trimmer2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trimmer2);
        Intent extraIntent = getIntent();
        
        
        String path = "";

        if (extraIntent != null) {
            path = extraIntent.getStringExtra(MainActivity.EXTRA_VIDEO_PATH);
            Log.i(TAG, "createTrimmer: path: " + path);

            mVideoTrimmer = (DeepVideoTrimmer)findViewById(R.id.timeLine);
            mVideoTrimmer.setMaxDuration(100);
            mVideoTrimmer.setOnTrimVideoListener(this);
            mVideoTrimmer.setVideoURI(Uri.parse(path));

        }
    }

    @Override
    public void getResult(Uri uri) {

        Log.i(TAG, "getResult: " + uri);

    }

    @Override
    public void cancelAction() {
        mVideoTrimmer.destroy();
        finish();
    }
}
