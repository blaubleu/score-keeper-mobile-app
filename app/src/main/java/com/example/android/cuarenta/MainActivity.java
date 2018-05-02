package com.example.android.cuarenta;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private int scoreChullas = 0;
    private int scoreViejos = 0;
    
    //initialize text views per team
    private TextView chullas, chullasScore;
    private TextView viejos, viejosScore;

    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chullas = findViewById(R.id.chullas);
        chullasScore = findViewById(R.id.chullasScore);
        viejos = findViewById(R.id.viejos);
        viejosScore = findViewById(R.id.viejosScore);
        reset = findViewById(R.id.reset);
    }

    public void winner(String winnerMessage) {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Cuarenta!");
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
     *  Toast
     */
    public void caidaToast(String text) {

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,40, 20);
        toast.show();
    }


    /**
     * Chullas section starts here
     * -2 to opponent for bad dealing
     */
    public void minusTwoChullas(View view) {
        scoreChullas = scoreChullas - 2;
        displayChullas(scoreChullas);
    }

    /**
     *  One method to rule them all
     *  All the possible ways to score +2 pts for team Chullas
     */
    public void cuarentaPlusChullas(View view){
        if (scoreChullas >= 38) {
            caidaToast(getString(R.string.beforeForty));
            return;
        }
        scoreChullas = scoreChullas + 2;
        displayChullas(scoreChullas);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     */
    public void caidaChullas(View view) {
        if (scoreChullas < 38) {
            scoreChullas = scoreChullas + 2;
            displayChullas(scoreChullas);
        }
        else if (scoreChullas == 38){
            scoreChullas = scoreChullas + 2;
            displayChullas(scoreChullas);

            //alert goes here
            winner(getString(R.string.chullasWin));
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
    public void minusTwoViejos(View v) {
        scoreViejos = scoreViejos - 2;
        displayViejos(scoreViejos);
    }

    /**
     *  One method to rule them all
     *  All the possible ways to score +2 pts for team Viejos
     */
    public void cuarentaPlusViejos(View view){
        if (scoreViejos >= 38) {
            caidaToast(getString(R.string.beforeForty));
            return;
        }
        scoreViejos = scoreViejos + 2;
        displayViejos(scoreViejos);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     */
    public void caidaViejos(View view) {
        if (scoreViejos < 38) {
            scoreViejos = scoreViejos + 2;
            displayViejos(scoreViejos);
        }
        else if (scoreViejos == 38) {
            scoreViejos = scoreViejos + 2;
            displayViejos(scoreViejos);

            //alert goes here
            winner(getString(R.string.viejosWin));
        }
    }

    /**
     * Displays the score for Team Viejos
     */
    public void displayViejos (int scoreViejos) {
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

    /**
     * data persistence
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("chullasScore",scoreChullas);
        outState.putInt("viejosScore",scoreViejos);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        scoreChullas = savedInstanceState.getInt("chullasScore");
        scoreViejos = savedInstanceState.getInt("viejosScore");
    }
}
