package com.roni.videoflow;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;

import life.knowledge4.videotrimmer.K4LVideoTrimmer;
import life.knowledge4.videotrimmer.interfaces.OnTrimVideoListener;

public class TrimmerActivity extends AppCompatActivity implements OnTrimVideoListener {

    private K4LVideoTrimmer mVideoTrimmer;
    private ProgressDialog mProgressDialog;
    private static final String TAG = "TrimmerActivity";
    private static final int REQUEST_STORAGE_WRITE_ACCESS_PERMISSION = 101;
    String path = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trimmer);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, "Storage permission is required to proceed", REQUEST_STORAGE_WRITE_ACCESS_PERMISSION);
        } else {
            createTrimmer();
        }


    }

    private void requestPermission(final String permission, String rationale, final int requestCode) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Permission required to proceed");
            builder.setMessage(rationale);
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ActivityCompat.requestPermissions(TrimmerActivity.this, new String[]{permission}, requestCode);
                }
            });
            builder.setNegativeButton("Cancel", null);
            builder.show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
        }
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_STORAGE_WRITE_ACCESS_PERMISSION:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    createTrimmer();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    private void createTrimmer() {
        try {
            Intent extraIntent = getIntent();


            if (extraIntent != null) {
                path = extraIntent.getStringExtra(MainActivity.EXTRA_VIDEO_PATH);
                Log.i(TAG, "createTrimmer: path: " + path);
            }

            //setting progressbar
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Trimming in progress");

            mVideoTrimmer = ((K4LVideoTrimmer) findViewById(R.id.timeLine));
            if (mVideoTrimmer != null) {
                mVideoTrimmer.setMaxDuration(30);
                mVideoTrimmer.setOnTrimVideoListener(this);
                // mVideoTrimmer.setOnK4LVideoListener(this);
                mVideoTrimmer.setDestinationPath("/storage/emulated/0/DCIM/TrimmedVideo/");
                mVideoTrimmer.setVideoURI(Uri.fromFile(new File(path)));
                //  mVideoTrimmer.setVideoInformationVisibility(true);
            }
        }catch (Exception e)
        {
            Log.i(TAG, "createTrimmer: " + e.getMessage());
        }

    }

    @Override
    public void getResult(final Uri uri) {
        Log.i(TAG, "getResult: " + uri);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(TrimmerActivity.this, "Video at : " + uri.getPath(), Toast.LENGTH_SHORT).show();
            }
        });
         Intent intent = new Intent(this, DetailsActivity.class);
         intent.putExtra("filepath", uri.getPath());
          startActivity(intent);
        // finish();

    }

    @Override
    public void cancelAction() {

        mVideoTrimmer.destroy();
        finish();
        // finish();

    }


}
