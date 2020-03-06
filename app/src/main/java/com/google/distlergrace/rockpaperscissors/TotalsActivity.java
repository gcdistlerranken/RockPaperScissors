package com.google.distlergrace.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TotalsActivity extends AppCompatActivity
{
    TextView    textViewTotals;
    Button      buttonReturnHome;

    int     totalCompWins;
    int     totalUserWins;
    int     totalTies;
    String  result;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_totals);

        textViewTotals      = findViewById(R.id.textViewTotals);
        buttonReturnHome    = findViewById(R.id.buttonReturnHome);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null)
        {
            if (extras.containsKey("totalCompWins"))
            {
                totalCompWins = extras.getInt("totalCompWins", 0);
            }

            if (extras.containsKey("totalUserWins"))
            {
                totalUserWins = extras.getInt("totalUserWins", 0);
            }

            if (extras.containsKey("totalTies"))
            {
                totalTies = extras.getInt("totalTies", 0);
            }

            result  = "Computer Wins: " + totalCompWins;
            result += "\nUser Wins: "   + totalUserWins;
            result += "\nTotal Ties: "  + totalTies;

            textViewTotals.setText(result);
        }

        buttonReturnHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }
}
