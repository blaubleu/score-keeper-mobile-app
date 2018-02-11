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

    public void onlyWayToFortyC(boolean twoToChullasCaida) {
        if ((scoreChullas == 38) && twoToChullasCaida == true)
        {
            scoreChullas = scoreChullas +2;
            displayChullas (scoreChullas);
        }
		else {
            Context context = getApplicationContext();

            CharSequence text = "Only way to 40 is Caida";
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
    public void onlyWayToFortyV(boolean twoToViejosCaida) {
        if ((scoreViejos == 38) && twoToViejosCaida == true)
        {
            scoreViejos = scoreViejos +2;
            displayViejos (scoreViejos);
        }
        else {
            Context context = getApplicationContext();

            CharSequence text = "Only way to 40 is Caida";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    /**
     *  40 should force a reset
     */
    public void Reset (View v) {
        if (scoreViejos == 40 || scoreChullas == 40)
        { 	scoreChullas = 0;
            scoreViejos =0;
        }
        displayViejos (scoreChullas);
        displayViejos (scoreViejos);
    }

    /**
     * Displays the score for Team Viejos
     */
    public void displayViejos(int scoreViejos) {
        TextView scoreView = findViewById(R.id.viejosScore);
        scoreView.setText(String.valueOf(scoreViejos));
    }
}
