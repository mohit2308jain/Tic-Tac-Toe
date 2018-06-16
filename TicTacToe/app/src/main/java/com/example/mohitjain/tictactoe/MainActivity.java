package com.example.mohitjain.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1 for cross and 0 for circle
    int activePlayer = 1;
    int[] gameState = {9,9,9,9,9,9,9,9,9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void imageTapped(View view){
        ImageView mytapped = (ImageView) view;

        int currenttapped = Integer.parseInt(mytapped.getTag().toString());
        if(gameState[currenttapped] == 9){

            gameState[currenttapped] = activePlayer;

            if(activePlayer == 1) {
                mytapped.setImageResource(R.drawable.cross);
                mytapped.animate().rotation(mytapped.getRotation() + (180)).setDuration(1000);
                activePlayer = 0;
            }
            else {
                mytapped.setImageResource(R.drawable.circle);
                mytapped.animate().rotation(360).setDuration(1000);
                activePlayer = 1;
            }
        }
        else{
            Toast.makeText(this,"This block is already clicked",Toast.LENGTH_SHORT).show();
        }

        if((gameState[0]==1&&gameState[1]==1&&gameState[2]==1)||(gameState[3]==1&&gameState[4]==1&&gameState[5]==1)
                ||(gameState[6]==1&&gameState[7]==1&&gameState[8]==1)||(gameState[0]==1&&gameState[3]==1&&gameState[6]==1)
                ||(gameState[1]==1&&gameState[4]==1&&gameState[7]==1)||(gameState[2]==1&&gameState[5]==1&&gameState[8]==1)
                ||(gameState[0]==1&&gameState[4]==1&&gameState[8]==1)||(gameState[2]==1&&gameState[4]==1&&gameState[6]==1)){
            Toast.makeText(this,"CROSS WON",Toast.LENGTH_SHORT).show();
            playagain(view);
        }
        else if((gameState[0]==0&&gameState[1]==0&&gameState[2]==0)||(gameState[3]==0&&gameState[4]==0&&gameState[5]==0)
                ||(gameState[6]==0&&gameState[7]==0&&gameState[8]==0)||(gameState[0]==0&&gameState[3]==0&&gameState[6]==0)
                ||(gameState[1]==0&&gameState[4]==0&&gameState[7]==0)||(gameState[2]==0&&gameState[5]==0&&gameState[8]==0)
                ||(gameState[0]==0&&gameState[4]==0&&gameState[8]==0)||(gameState[2]==0&&gameState[4]==0&&gameState[6]==0)){
            Toast.makeText(this,"CIRCLE WON",Toast.LENGTH_SHORT).show();
            playagain(view);
        }
    }

    public void playagain(View view){

        //currnet state back to 9
        for(int i = 0;i < gameState.length;i++){
            gameState[i] = 9;
        }

        //active player back to initial state
        activePlayer = 1;

        //changing all images to initial states
        LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.lineone);
        for(int i = 0;i < linearLayout1.getChildCount();i++) {
            ((ImageView) linearLayout1.getChildAt(i)).setImageResource(R.drawable.qwww);
        }

        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.linetwo);
        for(int i = 0;i < linearLayout2.getChildCount();i++) {
            ((ImageView) linearLayout2.getChildAt(i)).setImageResource(R.drawable.qwww);
        }

        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.linethree);
        for(int i = 0;i < linearLayout3.getChildCount();i++) {
            ((ImageView) linearLayout3.getChildAt(i)).setImageResource(R.drawable.qwww);
        }
    }
}
