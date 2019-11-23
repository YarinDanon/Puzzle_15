package com.yarin.puzzle15;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static java.lang.Integer.*;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStartNewGame;
    private GameBoard gameBoard;
    private TextView[] gameTable = new TextView[16];
    private TextView txvMoves;
    private int countMoves = 0;
    private TextView txvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        setGameBoardClickListener(); // set click listener for 16 text views on the board

        gameBoard = new GameBoard(gameTable);
        gameBoard.resetBoard();

        // start new game Button
        btnStartNewGame = (Button) findViewById(R.id.btnSNGID);
        btnStartNewGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameBoard.resetBoard();
                setMoves(0);
            }
        });

        txvMoves = (TextView)findViewById(R.id.txvMovesID);
        txvTime = (TextView)findViewById(R.id.txvTimeID);
        
    }

    @Override
    public void onClick(View v) {
        //Move
        String temp = getResources().getResourceName(v.getId()); // get the id name

        // cat the index from the id
        temp = temp.replaceAll("com.yarin.puzzle15:id/txvGT","");
        temp = temp.replaceAll("ID","");
        int result = gameBoard.Move(parseInt(temp));
        switch (result){
            case 1:
                Log.d("win","win");
                break;
            case 0:
                setMoves(countMoves+1);
                break;
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        //setSizeAndStyle();
    }

    private void setGameBoardClickListener(){
        for(int i = 0 ; i < gameTable.length ; i++){
            String id = "txvGT" + i + "ID";
            gameTable[i] = (TextView)findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            gameTable[i].setOnClickListener(this);
        }
    }

    private void  setMoves(int num){
        String s = "Moves: ";
        if(num > 99)
            s+= "0";
        else if (num > 9)
            s+= "00";
        else
            s+= "000";
        txvMoves.setText(s + num);
        countMoves = num;
    }

}
