package com.yarin.puzzle15;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameBoard = new GameBoard();
        gameBoard.resetBoard();

        // start new game Button
        btnStartNewGame = (Button) findViewById(R.id.btnSNGID);
        btnStartNewGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                gameBoard.resetBoard();
            }
        });
    }

    @Override
    public void onClick(View v) {
        //Move
        String temp = getResources().getResourceName(v.getId()); // get the id name

        // cat the index
        temp = temp.replaceAll("com.yarin.puzzle15:id/txvGT","");
        temp = temp.replaceAll("ID","");
        int result = gameBoard.Move(parseInt(temp));
        switch (result){
            case 1:
                Log.d("win","win");
                break;
            case 0:
                Log.d("moves","Moves ++");
                break;
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        setSizeAndStyle();
    }

    private void setSizeAndStyle(){
        for(int i = 1 ; i < gameTable.length ; i++){
            String id = "txvGT" + i + "ID";
            gameTable[i] = (TextView)findViewById(getResources().getIdentifier(id, "id", getPackageName()));
            //gameTable[i].measure(0, 0);
            //int h = gameTable[i].getMeasuredWidth();
            gameTable[i].setText(i + "");
            gameTable[i].setHeight(150);
            gameTable[i].setBackgroundColor(-16711681);
            gameTable[i].setTextColor(-16777216);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams)gameTable[i].getLayoutParams();
            params.setMargins(5, 5, 5, 5);
            gameTable[i].setLayoutParams(params);
            //Log.d("size",h + "");
            gameTable[i].setOnClickListener(this);
        }
        gameTable[0] = (TextView)findViewById(R.id.txvGT0ID);
        gameTable[0].setOnClickListener(this);
        gameTable[0].setText("");
        gameTable[0].setHeight(150);

    }


}
