package com.yarin.puzzle15;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Integer.*;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnStartNewGame;
    private GameBoard gameBoard;
    private TextView[] gameTable = new TextView[16];
    private TextView txvMoves;
    private int countMoves = 0;
    private TextView txvTime;
    private long timeStart;
    private boolean musicOn;
    private MediaPlayer mp;
    private Boolean isPause;
    private Stoper Time;

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
                txvTime.setText("Time: 00:00");
                setMoves(0);
                Time.reset();
                Time.start();
                for(int i = 0 ; i < gameTable.length ; i++)
                    gameTable[i].setClickable(true);
            }
        });

        txvMoves = (TextView)findViewById(R.id.txvMovesID);
        setMoves(0);

        txvTime = (TextView)findViewById(R.id.txvTimeID);
        //setTime();
        //Time.start();
        Time = new Stoper(txvTime);
        Time.start();

        musicOn = getIntent().getExtras().getBoolean("musicOn");
        mp = MediaPlayer.create(this,R.raw.music);
        mp.setLooping(true);
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
                winHandle();
                break;
            case 0:
                setMoves(countMoves+1);
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
        Time.pause();
    }

    @Override
    public void onPause(){
        super.onPause();
        mp.pause();
        Time.pause();
    }

    @Override
    public void onResume(){
        super.onResume();
        if(musicOn)
            mp.start();
        Time.start();

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

    private void winHandle(){
        setMoves(countMoves+1);
        Time.pause();
        Toast.makeText(this, "Game Over - Puzzle Solved!", Toast.LENGTH_LONG).show();
        for(int i = 0 ; i < gameTable.length ; i++)
            gameTable[i].setClickable(false);
    }

}
