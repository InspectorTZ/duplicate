package com.example.duplicate;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.duplicate.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.duplicate.R;  // Ensure this import is correct

public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private int score;

    // Constructor to initialize score to 0
    public MainActivity() {
        this.score = 0;
    }

    AlertDialog wrongClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        Button b = (Button) view;
        b.setBackgroundColor(ContextCompat.getColor(this, R.color.black));

        // Correct way to compare drawable resource
        Drawable currentBackground = b.getBackground();
        Drawable targetBackground = ContextCompat.getDrawable(this, R.color.black);

        // Use currentBackground comparison to Drawable
        if (currentBackground != null && currentBackground.getConstantState().equals(targetBackground.getConstantState())) {
            b.setBackgroundColor(ContextCompat.getColor(this, android.R.color.white));  // Changed to android.R.color.white for correct white color reference
            score++;
        } else {
            WrongClick(score);
        }
    }

    public void WrongClick(int score) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("YOU LOST!");
        builder.setMessage("SCORE: " + score);
        builder.setPositiveButton("PLAY AGAIN", this);
        builder.setNeutralButton("RATE THE APP", this);  // Corrected setNeutralButton position
        builder.setNegativeButton("Cancel", this);       // Added setNegativeButton for clarity
        wrongClick = builder.create();                   // Fixed creation of AlertDialog
        wrongClick.show();                               // Show the dialog
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        // Handle button clicks on the dialog here
    }
}
