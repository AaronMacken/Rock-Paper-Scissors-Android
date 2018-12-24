package com.aaron.example.roshambo;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    String cpuChoice = "";
    String userChoice = "";
    boolean gameIsActive = true;

   public void hideLayout(View v){
       LinearLayout gsLayout = findViewById(R.id.gameStateLayout);
       Button gsButton = findViewById(R.id.gameStateButton);
       TextView gsTextView = findViewById(R.id.gameStateMessage);
       ImageView c1 = findViewById(R.id.c1);
       ImageView c2 = findViewById(R.id.c2);
       ImageView c3 = findViewById(R.id.c3);
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
                       c1.animate().alpha(1f).setDuration(1000);
                   }
                   else if(cpuChoice.equals("2")){
                       c2.animate().alpha(1f).setDuration(1000);
                   }
                   else if(cpuChoice.equals("3")){
                       c3.animate().alpha(1f).setDuration(1000);
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
                       winningString = "Paper Wins!";
                   } else if(userChoice.equals("3") && cpuChoice.equals("2") || userChoice.equals("2") && cpuChoice.equals("3")) {
                      if(userChoice.equals("2")){
                          winOrLoseString = "You lose.";
                      }else{
                          winOrLoseString = "You win!";
                      }
                       winningString = "Scissor wins!";
                   }
                   gsTextView.setText(winningString +  "\n" + winOrLoseString);
                   gsButton.setText("WOOOW (GG) ");
                   gameIsActive = false;
               }
           }
       }else{
           gsTextView.setText("Choose a weapon");
           gsButton.setText("OK");
           c1.animate().alpha(0f).setDuration(0);
           c2.animate().alpha(0f).setDuration(0);
           c3.animate().alpha(0f).setDuration(0);
           gameIsActive = true;
       }
   }

   @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
   public void weaponClicked(View v){

            if(gameIsActive){
                // Get user choice
                String userChoice = v.getTag().toString();
                // Get cpu choice
                int cpuRNG = (ThreadLocalRandom.current().nextInt(1, 3 + 1));
                // Switch Statement to convert CPU RNG to weapon choice.
                switch (cpuRNG) {
                    case 1:
                        if (cpuRNG == 1) {
                            cpuChoice = "1";
                            break;
                        }
                    case 2:
                        if (cpuRNG == 2) {
                            cpuChoice = "2";
                            break;
                        }
                    case 3:
                        if (cpuRNG == 3) {
                            cpuChoice = "3";
                            break;
                        }
                }
                // Get weapon Name
                String weaponName = "";
                switch (userChoice) {
                    case "1":
                        weaponName = "You chose rock";
                        break;
                    case "2":
                        weaponName = "You chose paper";
                        break;
                    case "3":
                        weaponName = "You chose scissors";
                        break;
                }
                LinearLayout gsLayout = findViewById(R.id.gameStateLayout);
                gsLayout.setVisibility(View.VISIBLE);

                TextView gsTextView = findViewById(R.id.gameStateMessage);
                gsTextView.setText(weaponName);

                Button gsButton = findViewById(R.id.gameStateButton);
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

