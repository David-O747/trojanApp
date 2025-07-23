package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.Theme_App);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.about_game) {
            Toast.makeText(this, "About game", Toast.LENGTH_SHORT).show();
            return true;

        } else if (id == R.id.gameplay_video) {
            // Launch GameplayVideoActivity
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