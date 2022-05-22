import util.BoardDrawer;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

public class nQueens
{
  static ArrayList<int[][]> solutions;

  public static void main(String[] args)
  {
      solutions = new ArrayList<>();
      int queens = 4;  //queens must be > 3
      int[][] board = new int[queens][queens];
      for (int i = 0; i < queens; i ++){
        for (int j = 0; j < queens; j++){
          board[i][j] = 0;
        }
      }

      solve(board,0);

      System.out.println(solutions.size());
    for (int[][] solution : solutions)
    {
      System.out.println(BoardDrawer.drawBoard(solution, queens));
    }



  }


  public static void solve(int[][] board, int col){
    if (col >= board.length)
    {
      int[][] copy = Arrays.stream(board).map(int[]::clone).toArray(int[][]::new);
      solutions.add(copy);

      return;
    }


    for (int i = 0; i < board.length; i++){
      if (canPlace(board, col, i))
      {
        board[col][i] = 1;
        solve(board,col+1);
        board[col][i] = 0;
      }

    }
  }

  public static boolean canPlace(int[][] board, int col, int row){

    int up = row, down = row;
    //checking row
    for (int i = 0; i < col; i++)
    {
      if (board[i][row] == 1)
        return false;
    }
    for (int i = col-1;i >= 0;i-- ){
      if (down > 0)
      {
        if (board[i][--down] == 1)
          return false;
      }
      if (up < board.length-1)
      {
        if (board[i][++up] == 1)
          return false;
      }

    }
    return true;
  }


}
