package com.example.android.cuarenta;

import android.content.Context;
import android.content.DialogInterface;
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

    public void winner(String winnerMessage) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Game Over!");
        alertDialog.setMessage(winnerMessage);
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Restart", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reset();
                dialog.dismiss();
            }
        });

        alertDialog.show();
    }


    /**
     *  Toast method
     */
    public void caidaToast(String text) {

        Context context = getApplicationContext();

        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }


    /**
     * Chullas section starts here
     * -2 to opponent for bad dealing
     */
    public void twoPointsRemovedFromChullas(View view) {
        scoreChullas = scoreChullas - 2;
        displayChullas(scoreChullas);
    }

    /**
     *  One method to rule them all
     *  All the possible ways to score +2 pts for team Chullas
     */
    public void twoPointsAddedToChullas(View view){
        if (scoreChullas >= 38) {
            caidaToast("Only way to 40 is Caida");
            return;
        }
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     */
    public void onlyWayToFortyChullus(View view) {
        if (scoreChullas < 38) {
            caidaToast("You can't use Caida till you score 38");
            return;
        }
            scoreChullas = scoreChullas + 2;
            displayChullas(scoreChullas);

            //alert goes here
            winner("Congratulations Chullus wins!");

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
    public void twoPointsRemovedFromViejos(View v) {
        scoreViejos = scoreViejos - 2;
        displayViejos(scoreViejos);
    }

    /**
     *  One method to rule them all
     *  All the possible ways to score +2 pts for team Viejos
     */
    public void twoPointsAddedToViejos(View view){
        if (scoreViejos >= 38) {
            caidaToast("Only way to 40 is Caida");
            return;
        }
        scoreViejos = scoreViejos + 2;
        displayViejos(scoreViejos);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     */
    public void onlyWayToFortyViejos(View view) {
        if (scoreViejos < 38) {
            caidaToast("You can't use Caida till you score 38");
            return;
        }
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);

        //alert goes here
        winner("Congratulations Viejos wins!");
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
    public void resetButton (View v) {
        reset();
    }

    private void reset() {
        scoreChullas = 0;
        scoreViejos = 0;
        displayChullas(scoreChullas);
        displayViejos(scoreViejos);
    }
}
