package com.example.android.cuarenta;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int scoreChullas = 0;
    int scoreViejos = 0;
//    boolean onlyWayToFortyV = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void winner(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("X Team wins, do you want to play another hand?");
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
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
     *  One method to rule them all
     *  All the possible ways to score +2 pts for team Chullas
     */
    public void cuarentaPlusChullas(View view){
        if (scoreChullas >= 38) {
            caidaToast();
            return;
        }
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     */
    public void onlyWayToFortyC(View view) {
        if (scoreChullas == 38) {
            scoreChullas = scoreChullas + 2;
            displayChullas(scoreChullas);
            //alert goes here
            winner();
            return;
        }
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
     *    Viejos section starts here
     *    -2 to opponent for bad dealing
     */
    public void twoFromViejosBadDealing(View v) {
        scoreViejos = scoreViejos - 2;
        displayViejos(scoreViejos);
    }

    /**
     *  One method to rule them all
     *  All the possible ways to score +2 pts for team Viejos
     */
    public void cuarentaPlusViejos(View view){
        if (scoreViejos >= 38) {
            caidaToast();
            return;
        }
        scoreViejos = scoreViejos + 2;
        displayViejos(scoreViejos);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     */
    public void onlyWayToFortyV(View view) {
        scoreViejos = scoreViejos + 2;
        displayViejos(scoreViejos);
            if (scoreViejos == 38) {
                    //alert goes here
                    winner();
                    return;
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
     *  Reset scores
     */
    public void reset (View v) {
         	scoreChullas = 0;
            scoreViejos = 0;
             displayChullas(scoreChullas);
             displayViejos(scoreViejos);
    }
}
