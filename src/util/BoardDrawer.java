package util;

import java.util.ArrayList;

public class BoardDrawer
{
  private int width, height;

  public BoardDrawer(int queens){
    this.width = queens;
    this.height = queens;
  }


  public static String drawBoard(int[][] board, int n){

    StringBuilder toReturn = new StringBuilder();
    for (int i = 0; i < n; i++)
    {
      for (int j = 0; j < n; j++)
      {
        if (board[j][i] == 0)
        {
          toReturn.append("   ");
        }
        else if (board[j][i] == 1)
          toReturn.append(" Q ");
        if (j < n - 1)
          toReturn.append("|");

      }
      toReturn.append("\n");
      if (i < n -1)
      {
        for (int j = 0; j < n; j++)
        {

          if (j < n - 1)
          {
            toReturn.append("---+");
          }
          else
            toReturn.append("---");
        }
        toReturn.append("\n");
      }
    }
    return toReturn.toString();
  }


}
