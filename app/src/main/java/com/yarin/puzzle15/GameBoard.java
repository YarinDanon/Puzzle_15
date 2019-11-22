package com.yarin.puzzle15;
import java.util.*;
import android.util.Log;
import android.widget.TextView;



public class GameBoard {


    public void resetBoard()
    {
        int[] board = randomBoard();
        while(!isSolvable(board))
        {
            System.out.println("invalid: " + Arrays.toString(board));
            board = randomBoard();

        }
        System.out.println("GOOD: " + Arrays.toString(board));




        //Log.d("resetBoard","resetBoard");


    }


    public int Move(int indexClick)
    {

        // if win return 1
        //if move ok return 0

        // if move not legal return -1
        Log.d("indexClick",indexClick + "");



        return 1;
    }

    private int[] randomBoard()
    {
        Integer[] arr = new Integer[16];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Collections.shuffle(Arrays.asList(arr));
        int [] board = new int [16];
        for(int i = 0 ; i < board.length ; i++)
        {
            board[i] = arr[i];
        }
        return board;
    }


    private boolean isSolvable(int[] puzzle)
    {
        int parity = 0;
        int gridWidth = (int) Math.sqrt(puzzle.length);
        int row = 0;
        int blankRow = 0;

        for (int i = 0; i < puzzle.length; i++)
        {
            if (i % gridWidth == 0) {
                row++;
            }
            if (puzzle[i] == 0) {
                blankRow = row;
                continue;
            }
            for (int j = i + 1; j < puzzle.length; j++)
            {
                if (puzzle[i] > puzzle[j] && puzzle[j] != 0)
                {
                    parity++;
                }
            }
        }

        if (gridWidth % 2 == 0) { // even grid
            if (blankRow % 2 == 0) { // blank on odd row; counting from bottom
                return parity % 2 == 0;
            } else { // blank on even row; counting from bottom
                return parity % 2 != 0;
            }
        } else { // odd grid
            return parity % 2 == 0;
        }
    }
}
