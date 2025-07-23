package com.example.app;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class FaqActivity extends AppCompatActivity {

    private final String[] answers = {
            "-Trojan is a tactical game where players navigate and hack their way through security systems. The motivation behind it was to immerse players in a high-tech hacking scenario and strategic gameplay.",
            "-The team chose dark, moody tones with claustrophobic accents to create tension and evoke a sense of being trapped in a secure facility.",
            "-Health sector mechanics were inspired by both real-world medical tech and sci-fi futures, aiming to reinforce the bio-tech theme and gameplay immersion.",
            "-From the designer’s perspective, the goal is to deliver an experience that balances challenge, immersion, and strategic decision-making.",
            "-The experimental project is woven into the narrative and environment design to reinforce immersion and player engagement within the facility."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);

        LinearLayout faqContainer = findViewById(R.id.faq_container);

        int questionIndex = 0;
        int i = 0;
        while (i < faqContainer.getChildCount() && questionIndex < answers.length) {
            View item = faqContainer.getChildAt(i);

            if (item instanceof LinearLayout) {
                LinearLayout questionRow = (LinearLayout) item;

                if (questionRow.getChildCount() >= 2 &&
                        questionRow.getChildAt(1) instanceof ImageView) {

                    final ImageView icon = (ImageView) questionRow.getChildAt(1);
                    final String answerText = answers[questionIndex];

                    final TextView answerView = new TextView(this);
                    answerView.setText(answerText);
                    answerView.setTextColor(Color.WHITE);
                    answerView.setTextSize(15);
                    answerView.setPadding(32, 16, 32, 16);
                    answerView.setVisibility(View.GONE);

                    faqContainer.addView(answerView, i + 1); // Insert below the question
                    i++; // Skip newly added answer view

                    icon.setOnClickListener(new View.OnClickListener() {
                        boolean expanded = false;

                        @Override
                        public void onClick(View v) {
                            expanded = !expanded;
                            answerView.setVisibility(expanded ? View.VISIBLE : View.GONE);
                            icon.setImageResource(expanded ?
                                    android.R.drawable.ic_menu_close_clear_cancel :
                                    android.R.drawable.ic_menu_add);
                        }
                    });

                    questionIndex++;
                }
            }
            i++;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    // Menu item handling
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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

        } else if (id == R.id.contact_us) {
            Toast.makeText(this, "CONTACT", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, ContactActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
