package com.yarin.puzzle15;
import java.util.*;
import android.util.Log;
import android.widget.TextView;



public class GameBoard {


    private TextView[] gameBoard;

    GameBoard(TextView[] gameBoard){
        this.gameBoard = gameBoard;
    }





    public void resetBoard()
    {
        int[] board = randomBoard();
        while(!isSolvable(board))
        {
            board = randomBoard();

        }
        
        for(int i = 1 ; i < 16 ; i++)
        {
            if(board[i-1] == 0)
            {
                gameBoard[i].setText("");
                continue;
            }
            String str = Integer.toString(board[i-1]);
            gameBoard[i].setText(str);
        }

        if(board[15] == 0)
        {
            gameBoard[0].setText("");
        }
        else {
            String s = Integer.toString(board[15]);
            gameBoard[0].setText(s);
        }

    }


    public int Move(int indexClick)
    {
        CharSequence clicked;
        clicked = gameBoard[indexClick].getText();
        if( (6 <= indexClick && indexClick <= 7) || (10 <= indexClick && indexClick <= 11) )
        {
            if(gameBoard[indexClick +1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick +1].setText(clicked);
            }
            else if(gameBoard[indexClick - 1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick - 1].setText(clicked);
            }
            else if(gameBoard[indexClick + 4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick + 4].setText(clicked);
            }
            else if(gameBoard[indexClick - 4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick - 4].setText(clicked);
            }
            else
            {
                return -1;
            }

        }

        if(indexClick == 2 || indexClick == 3)
        {
            if(gameBoard[indexClick +1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick +1].setText(clicked);
            }
            else if(gameBoard[indexClick-1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-1].setText(clicked);
            }
            else if(gameBoard[indexClick + 4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick + 4].setText(clicked);
            }
            else
            {
                return -1;
            }

        }

        if(indexClick == 5 || indexClick == 9)
        {
            if(gameBoard[indexClick +1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick +1].setText(clicked);
            }
            else if(gameBoard[indexClick+4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick+4].setText(clicked);
            }
            else if(gameBoard[indexClick-4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-4].setText(clicked);
            }
            else
            {
                return -1;
            }
        }

        if(indexClick == 8 )
        {
            if(gameBoard[indexClick-1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-1].setText(clicked);
            }
            else if(gameBoard[indexClick+4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick+4].setText(clicked);
            }
            else if(gameBoard[indexClick-4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-4].setText(clicked);
            }
            else
            {
                return -1;
            }
        }

        if(indexClick == 12 )
        {
            if(gameBoard[indexClick-1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-1].setText(clicked);
            }
            else if(gameBoard[indexClick-12 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-12].setText(clicked);
            }
            else if(gameBoard[indexClick-4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-4].setText(clicked);
            }
            else
            {
                return -1;
            }
        }

        if(indexClick == 14)
        {
            if(gameBoard[indexClick +1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");
                gameBoard[indexClick +1].setText(clicked);
            }
            else if(gameBoard[indexClick-1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");
                gameBoard[indexClick-1].setText(clicked);
            }
            else if(gameBoard[indexClick-4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");
                gameBoard[indexClick-4].setText(clicked);
            }
            else{
                return -1;
            }
        }
        else if(indexClick == 15)
        {
            if(gameBoard[indexClick-15 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick-15].setText(clicked);
            }
            else if(gameBoard[indexClick - 1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick - 1].setText(clicked);
            }
            else if(gameBoard[indexClick - 4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick - 4].setText(clicked);
            }
            else
            {
                return -1;
            }
        }
        else if(indexClick == 1)
        {
            if(gameBoard[indexClick +1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick +1].setText(clicked);
            }
            else if(gameBoard[indexClick + 4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick + 4].setText(clicked);
            }
            else
            {
                return -1;
            }
        }

        else if(indexClick == 4)
        {
            if(gameBoard[indexClick -1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick -1].setText(clicked);
            }
            else if(gameBoard[indexClick + 4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick + 4].setText(clicked);
            }
            else
            {
                return -1;
            }
        }

        else if(indexClick == 13)
        {
            if(gameBoard[indexClick +1 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick +1].setText(clicked);
            }
            else if(gameBoard[indexClick - 4 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick - 4].setText(clicked);
            }
            else
            {
                return -1;
            }
        }

        else if(indexClick == 0)
        {
            if(gameBoard[indexClick +15 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick+15].setText(clicked);
            }
            else if(gameBoard[indexClick+12 ].getText() == "")
            {
                gameBoard[indexClick].setText("");;
                gameBoard[indexClick + 12].setText(clicked);
            }
            else {
                return -1;
            }

        }


        // if win return 1
        //if move ok return 0

        // if move not legal return -1



        return winChecker();
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

    private int winChecker()
    {
        for(int i = 1 ; i < 16 ; i++)
        {
            if(gameBoard[i].getText() ==  "")
            {
                return 0;
            }
            else
            {
                int number = Integer.parseInt((String) gameBoard[i].getText());

                if(number != i)
                {
                    return 0;
                }
            }
        }
        if(gameBoard[0].getText() != "")
        {
            return 0;
        }

        return 1;
    }
}
