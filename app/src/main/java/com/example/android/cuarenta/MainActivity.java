package com.example.android.cuarenta;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int scoreChullas = 0;
    int scoreViejos = 0;
    boolean twoToChullasCaida = false;
    boolean twoToViejosCaida = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *   Chullas section starts here
     *   -2 to opponent for bad dealing
     */
    public void twoFromChullasBadDealing(View v) {
        scoreChullas = scoreChullas - 2;
        displayChullas(scoreChullas);
    }

    /**
     *   +2 if you receive 3 cards of matching value
     */
    public void twoToChullasRonda(View v) {
        scoreChullas = scoreChullas + 2;
        displayChullas (scoreChullas);
    }

    /**
     *    +2 if you snap a card that was placed on the table by your opponent
     */
    public void twoToChullasLimpia(View v) {
        scoreChullas = scoreChullas + 2;
        displayChullas (scoreChullas);
    }

    /**
     *    +2 until you reach the number of cards you earned -start counting after 20 cards-
      */
    public void pairNumberAfterTwentyCardsInStackChullas(View v) {
        scoreChullas = scoreChullas + 2;
        displayChullas (scoreChullas);
    }

    /**
     *     38 points won't allow anything but to use method twoToChullasCaida
      */

    // This is an onClick method meaning you can't pass it a variable, it needs to be of (View view)
    // This is currently causing the application to crash.
    // You use use a variable where you update elsewhere.  I will move twoToChullasCaida to the top

//    public void onlyWayToFortyC(boolean twoToChullasCaida) {
    public void onlyWayToFortyC(View view) {
        if ((scoreChullas == 38) && twoToChullasCaida == true)
        {
            scoreChullas = scoreChullas +2;
            displayChullas (scoreChullas);
        }
		else {
            Context context = getApplicationContext();

            String text = "Only way to 40 is Caida";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Displays the score for Team Chullas
     */
    public void displayChullas(int scoreChullas) {
        TextView scoreView = findViewById(R.id.chullasScore);
        scoreView.setText(String.valueOf(scoreChullas));
    }

    /**
     *    Viejos section starts here
     *    -2 to opponent for bad dealing
     */
    public void twoFromViejosBadDealing(View v) {
        scoreViejos = scoreViejos - 2;
        displayViejos (scoreViejos);
    }

    /**
     *  +2 if you receive 3 cards of matching value
     */
    public void twoToViejosRonda (View v) {
        scoreViejos = scoreViejos + 2;
        displayViejos (scoreViejos);
    }

    /**
     *   +2 until you reach the number of cards you earned -start counting after 20 cards-
     */
    public void twoToViejosLimpia (View v) {
        scoreViejos = scoreViejos + 2;
        displayViejos (scoreViejos);
    }

    /**
     *  +2 until you reach the number of cards counted -start counting after 20 cards-
     */
    public void pairNumberAfterTwentyCardsInStackViejos (View v) {
        scoreViejos = scoreViejos + 2;
        displayViejos (scoreViejos);
    }

    /**
     *     38 points won't allow anything but to use method twoToViejosCaida
     */

    // Same as previous similar method.  Not sure what intent with boolean is, and were you want to set it
//    public void onlyWayToFortyV(boolean twoToViejosCaida) {
      public void onlyWayToFortyV(View view) {
        if ((scoreViejos == 38) && twoToViejosCaida == true)
        {
            scoreViejos = scoreViejos +2;
            displayViejos (scoreViejos);
        }
        else {
            Context context = getApplicationContext();

            String text = "Only way to 40 is Caida";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     * Displays the score for Team Viejos
     */
    public void displayViejos(int scoreViejos) {
        TextView scoreView = findViewById(R.id.viejosScore);
        scoreView.setText(String.valueOf(scoreViejos));
    }

    /**
     *  40 should force a reset
     */
    // This is the only place you use this code.  As it's attached to a button the point is to reset the scores.
    // uncomment out some of the code below if that wasn't your intent.
    public void reset (View v) {
//        if (scoreViejos == 40 || scoreChullas == 40) {
         	scoreChullas = 0;
            scoreViejos = 0;
//        }

        // You were calling the wrong method to update the Chullas score
//        displayViejos(scoreChullas);
        displayChullas(scoreChullas);
        displayViejos(scoreViejos);
    }


}
