import java.util.*;

public class NQueens {

    private static boolean canPlaceQueen(int row, int col, int n, ArrayList<ArrayList<Integer>> board) {
        for (int i = 0; i < n; i++) {
            if (board.get(i).get(col) == 1 || board.get(row).get(i) == 1) {
                return false;
            }
        }
        int tempR = row, tempC = col;
        while (row < n && col >= 0) {
            if (board.get(row).get(col) == 1) {
                return false;
            }
            row++;
            col--;
        }
        row = tempR;
        col = tempC;
        while (row >= 0 && col >= 0) {
            if (board.get(row).get(col) == 1) {
                return false;
            }
            row--;
            col--;
        }
        return true;
    }

    private static void solveNQueens(int col, int n, ArrayList<ArrayList<Integer>> board,
            ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            ArrayList<Integer> currBoardState = new ArrayList<>();
            for (ArrayList<Integer> row : board) {
                currBoardState.addAll(row);
            }
            result.add(currBoardState);
            return;
        }
        for (int row = 0; row < n; row++) {
            if (canPlaceQueen(row, col, n, board)) {
                board.get(row).set(col, 1);
                solveNQueens(col + 1, n, board, result);
                board.get(row).set(col, 0);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(0);
            }
            board.add(row);
        }
        solveNQueens(0, n, board, result);
        return result;
    }

    public static void main(String[] args) {
        int boardSize = 4;
        ArrayList<ArrayList<Integer>> result = solveNQueens(boardSize);
        for (ArrayList<Integer> row : result) {
            System.out.println(row);
        }
    }
}