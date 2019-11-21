package com.yarin.puzzle15;

import android.util.Log;

public class GameBoard {

    public void resetBoard(){
        Log.d("resetBoard","resetBoard");
    }


    public int Move(int indexClick){
        // if win return 1
        //if move ok return 0
        // if move not legal return -1
        Log.d("indexClick",indexClick + "");
        return 1;
    }
}
