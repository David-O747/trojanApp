package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class GameplayVideoActivity extends AppCompatActivity {

    private ImageView videopreview1;
    private VideoView videoView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay_video);  // layout: gameplay_video.xml

        // Bind views correctly to member variables
        videopreview1 = findViewById(R.id.videopreview1);
        videoView1 = findViewById(R.id.videoview1);

        // Click listener to play video
        videopreview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playVideoInline(videopreview1, videoView1, R.raw.trojan_gameplay);
            }
        });
    }

    private void playVideoInline(ImageView preview, VideoView videoView, int videoResId) {
        preview.setVisibility(View.GONE);
        videoView.setVisibility(View.VISIBLE);

        String videoPath = "android.resource://" + getPackageName() + "/" + videoResId;
        Uri uri = Uri.parse(videoPath);
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.requestFocus();
        videoView.start();
    }

    // MENU SETUP
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);  // traditional inflation
        return true;
    }

    // MENU ITEM HANDLING
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about_game) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.gameplay_video) {
            Intent intent = new Intent(this, GameplayVideoActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.game_location) {
            Intent intent = new Intent(this, GameLocationActivity.class);
            startActivity(intent);
            return true;

        } else if (id == R.id.faq) {
            Toast.makeText(this, "FAQ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, FaqActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.contact_us) {
            Toast.makeText(this, "CONTACT", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}