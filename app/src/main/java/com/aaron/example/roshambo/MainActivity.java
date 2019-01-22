package com.aaron.example.roshambo;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    String cpuChoice = "";
    String userChoice = "";
    boolean gameIsActive = true;

    ImageView cpuImageView1;
    ImageView cpuImageView2;
    ImageView cpuImageView3;

    LinearLayout gsLayout;
    TextView gsTextView;
    Button gsButton;

   public void hideLayout(View v){
       gsLayout = findViewById(R.id.gameStateLayout);
       gsButton = findViewById(R.id.gameStateButton);
       gsTextView = findViewById(R.id.gameStateMessage);

       cpuImageView1 = findViewById(R.id.cpuImageView1);
       cpuImageView2 = findViewById(R.id.cpuImageView2);
       cpuImageView3 = findViewById(R.id.cpuImageView3);


       if(gameIsActive){
           if(gsButton.getText().toString().startsWith("O")){
               //Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show();
               gsLayout.setVisibility(View.INVISIBLE);
           }else{
               if(gsButton.getText().toString().startsWith("C")){
                   userChoice = gsButton.getTag().toString();
                   String winningString = "";
                   String winOrLoseString = "";


                   if(cpuChoice.equals("1")){
                       cpuImageView1.animate().alpha(1f).setDuration(1000);
                   }
                   else if(cpuChoice.equals("2")){
                       cpuImageView2.animate().alpha(1f).setDuration(1000);
                   }
                   else if(cpuChoice.equals("3")){
                       cpuImageView3.animate().alpha(1f).setDuration(1000);
                   }


                   if (userChoice.equals(cpuChoice)) {
                       winningString = "Draw";
                   } else if (userChoice.equals("1") && cpuChoice.equals("3") || userChoice.equals("3") && cpuChoice.equals("1")) {
                       if(userChoice.equals("3")){
                           winOrLoseString = "You lose.";
                       }else{
                           winOrLoseString = "You win!";
                       }
                       winningString = "Rock beats Scissors!";
                   } else if (userChoice.equals("2") && cpuChoice.equals("1") || userChoice.equals("1") && cpuChoice.equals("2")) {
                       if(userChoice.equals("1")){
                           winOrLoseString = "You lose.";
                       }else{
                           winOrLoseString = "You win!";
                       }
                       winningString = "Paper beats Rock!";
                   } else if(userChoice.equals("3") && cpuChoice.equals("2") || userChoice.equals("2") && cpuChoice.equals("3")) {
                      if(userChoice.equals("2")){
                          winOrLoseString = "You lose.";
                      }else{
                          winOrLoseString = "You win!";
                      }
                       winningString = "Scissor beats Paper!";
                   }
                   gsTextView.setText(winningString +  "\n" + winOrLoseString);
                   gsButton.setText("WOOOW (GG) ");
                   gameIsActive = false;
               }
           }
       }else{
           gsTextView.setText("Choose a weapon");
           gsButton.setText("OK");
           cpuImageView1.animate().alpha(0f).setDuration(0);
           cpuImageView2.animate().alpha(0f).setDuration(0);
           cpuImageView3.animate().alpha(0f).setDuration(0);
           gameIsActive = true;
       }
   }

   @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
   public void weaponClicked(View v){

            if(gameIsActive){
                // Get user choice & cpu choice
                String userChoice = v.getTag().toString();
                cpuChoice = Integer.toString(ThreadLocalRandom.current().nextInt(1, 3 + 1));

                // Get weapon Name
                String weaponName = "You chose ";
                switch (userChoice) {
                    case "1":
                        weaponName += "rock";
                        break;
                    case "2":
                        weaponName += "paper";
                        break;
                    case "3":
                        weaponName += "scissors";
                        break;
                }
                gsLayout = findViewById(R.id.gameStateLayout);
                gsLayout.setVisibility(View.VISIBLE);

                gsTextView = findViewById(R.id.gameStateMessage);
                gsTextView.setText(weaponName);

                gsButton = findViewById(R.id.gameStateButton);
                gsButton.setText("Challenge");
                gsButton.setTag(userChoice);

            }

   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     }
}

