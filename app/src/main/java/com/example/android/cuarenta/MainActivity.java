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
    final int points = 2;
    
    //initialize text views + score buttons per team
    private TextView chullas, chullasScore;

    private TextView viejos, viejosScore;

    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize widgets per team
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
     *
     * -2 for a hand badly dealt
     */
    public void minusTwoChullas(View view) {
        scoreChullas = scoreChullas - points;
        displayChullas(scoreChullas);
    }

    /**
     *  One method to rule them all
     *  All the possible ways to score +2 points for team Chullas
     */
    public void cuarentaPlusChullas(View view){
        if (scoreChullas >= 38) {
            caidaToast(getString(R.string.beforeForty));
            return;
        }
        scoreChullas = scoreChullas + points;
        displayChullas(scoreChullas);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     * Original method implementation idea modified by @Causaelity R.S. - he taught me how to verify against a boolean variable
     *  He also mentored me on implementing the AlertDialog message
     */
    public void caidaChullas(View view) {
        if (scoreChullas < 38) {
            scoreChullas = scoreChullas + points;
            displayChullas(scoreChullas);
        }
        else if (scoreChullas == 38){
            scoreChullas = scoreChullas + points;
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
     *    -2 for a hand badly dealt
     */
    public void minusTwoViejos(View v) {
        scoreViejos = scoreViejos - points;
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
        scoreViejos = scoreViejos + points;
        displayViejos(scoreViejos);
    }

    /**
     * 38 points won't allow anything but to use method twoToChullasCaida
     * Original method implementation idea modified by @Causaelity R.S. - he taught me how to verify against a boolean variable
     * He also mentored me on implementing the AlertDialog message
     */
    public void caidaViejos(View view) {
        if (scoreViejos < 38) {
            scoreViejos = scoreViejos + points;
            displayViejos(scoreViejos);
        }
        else if (scoreViejos == 38) {
            scoreViejos = scoreViejos + points;
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
     *  @Causaelity suggested the implementation of this method as a private method
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
     * data persistence test to keep score information
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
