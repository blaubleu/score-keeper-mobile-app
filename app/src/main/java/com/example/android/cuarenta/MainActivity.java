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
//    boolean onlyWayToFortyC = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

        /**
         *   Chullas section starts here
         *   -2 to opponent for bad dealing
         */
        public void twoFromChullasBadDealing (View view){
        scoreChullas = scoreChullas - 2;
        displayChullas(scoreChullas);
    }

        /**
         *   +2 if you receive 3 cards of matching value
         */

    public void twoToChullasRonda(View view) {
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);
        if (scoreChullas >= 39) {
            caidaToast();
        }
    }

    /**
     * +2 if you snap a card that was placed on the table by your opponent
     */
    public void twoToChullasLimpia(View view) {
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);
        if (scoreChullas >= 39) {
            caidaToast();
        }
    }

    /**
     * +2 until you reach the number of cards you earned -start counting after 20 cards-
     */
    public void pairNumberAfterTwentyCardsInStackChullas(View view) {
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);
        if (scoreChullas >= 39) {
            caidaToast();
        }
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     */
    public void onlyWayToFortyC(View view) {
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);
/*        if (scoreChullas == 40) {
            reset();
        }*/
    }

    /**
     *  Toast method
     */
    public void caidaToast() {

        Context context = getApplicationContext();

        String text = "Only way to 40 is Caida";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    /**
     * Displays the score for Team Chullas
     */
    public void displayChullas(int scoreChullas) {
        TextView scoreView = findViewById(R.id.chullasScore);
        scoreView.setText(String.valueOf(scoreChullas));
    }

    /**
     * Reset method -- totally starting here, does not work :(
     */
/*    public void reset() {
        if ((scoreChullas == 40) && onlyWayToFortyC == true){
            scoreChullas = 0;
            displayChullas(scoreChullas);
        }
    }*/

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
        if (scoreViejos >= 39) {
            caidaToast();
        }
    }

    /**
     *   +2 until you reach the number of cards you earned -start counting after 20 cards-
     */
    public void twoToViejosLimpia (View v) {
        scoreViejos = scoreViejos + 2;
        displayViejos (scoreViejos);
        if (scoreViejos >= 39) {
            caidaToast();
        }
    }

    /**
     *  +2 until you reach the number of cards counted -start counting after 20 cards-
     */
    public void pairNumberAfterTwentyCardsInStackViejos (View v) {
        scoreViejos = scoreViejos + 2;
        displayViejos (scoreViejos);
        if (scoreViejos >= 39) {
            caidaToast();
        }
    }

    /**
     *     38 points won't allow anything but to use method twoToViejosCaida
     *     NOTE: pending update once Chullas method passes test
     *
     */
      public void onlyWayToFortyV(View view) {
          scoreViejos = scoreViejos + 2;
          displayViejos (scoreViejos);
      }

    /**
     * Displays the score for Team Viejos
     */
    public void displayViejos(int scoreViejos) {
        TextView scoreView = findViewById(R.id.viejosScore);
        scoreView.setText(String.valueOf(scoreViejos));
    }

    /**
     *  Should be able to reset game at any point but alwasy reset the game one 40 is reached - not tested
     */
    // This is the only place you use this code.  As it's attached to a button the point is to reset the scores.
    // uncomment out some of the code below if that wasn't your intent.
    public void reset (View v) {
         	scoreChullas = 0;
            scoreViejos = 0;
             displayChullas(scoreChullas);
             displayViejos(scoreViejos);
        //I would like to reset the game in this section , but adding an iff statement as below these lines does not work
        //but I did notice I need to have the option to reset prior to reaching

 /*           if (scoreViejos == 40 || scoreChullas == 40){
                    scoreChullas = 0;
                    scoreViejos = 0;
        }*/

    }
}
