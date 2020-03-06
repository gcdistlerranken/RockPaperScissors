package com.google.distlergrace.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    //Widget Variables
    ImageButton imageButtonRock;
    ImageButton imageButtonPaper;
    ImageButton imageButtonScissors;
    TextView    textViewResults;
    Button      buttonTotals;

    //Non-Widget Variables
    String  compChoice      = "";
    String  userChoice      = "";
    int     totalCompWins   = 0;
    int     totalUserWins   = 0;
    int     totalTies       = 0;
    String  winner          = "";
    Random  r;
    String  results         = "";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButtonRock     = findViewById(R.id.imageButtonRock);
        imageButtonPaper    = findViewById(R.id.imageButtonPaper);
        imageButtonScissors = findViewById(R.id.imageButtonScissors);
        textViewResults     = findViewById(R.id.textViewResults);
        buttonTotals        = findViewById(R.id.buttonTotals);


        imageButtonRock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userChoice = "ROCK";
                decideWinner(userChoice);
                viewResults();
            }
        });

        imageButtonPaper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userChoice = "PAPER";
                decideWinner(userChoice);
                viewResults();
            }
        });

        imageButtonScissors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                userChoice = "SCISSORS";
                decideWinner(userChoice);
                viewResults();
            }
        });

        buttonTotals.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle extras = new Bundle();
                extras.putInt("totalCompWins", totalCompWins);
                extras.putInt("totalUserWins", totalUserWins);
                extras.putInt("totalTies", totalTies);

                Intent intent = new Intent(getApplicationContext(), TotalsActivity.class);

                intent.putExtras(extras);

                startActivity(intent);
            }
        });
    }

    public String decideWinner (String userChoice)
    {
        //Computer Choice
        r = new Random();
        int compRandomChoice = r.nextInt(3)+1;

        if(compRandomChoice == 1)
        {
            compChoice = "ROCK";
        }
        else if(compRandomChoice == 2)
        {
            compChoice = "PAPER";
        }
        else if(compRandomChoice == 3)
        {
            compChoice = "SCISSORS";
        }

        //Compare User & Computer Choices To Determine Who Wins
        if (compChoice == userChoice)
        {
            ++totalTies;
            winner = "TIE";
        }
        else if (userChoice == "ROCK" && compChoice == "PAPER")
        {
            ++totalCompWins;
            winner = "COMPUTER";
        }
        else if (userChoice == "ROCK" && compChoice == "SCISSORS")
        {
            ++totalUserWins;
            winner = "USER";
        }
        else if (userChoice == "PAPER" && compChoice == "ROCK")
        {
            ++totalUserWins;
            winner = "USER";
        }
        else if (userChoice == "PAPER" && compChoice == "SCISSORS")
        {
            ++totalCompWins;
            winner = "COMPUTER";
        }
        else if (userChoice == "SCISSORS" && compChoice == "ROCK")
        {
            ++totalCompWins;
            winner = "COMPUTER";
        }
        else if (userChoice == "SCISSORS" && compChoice == "PAPER")
        {
            ++totalUserWins;
            winner = "USER";
        }

        return winner;
    }

    public void viewResults()
    {
        results  = "Computer Chose: " + compChoice;
        results += "\nThe User Chose: " + userChoice;
        results += "\nThe Winner Is: " + winner;
        textViewResults.setText(results);
    }
}
