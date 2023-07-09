public class SudokuSolver {
    public static boolean canPlace(int[][] board, int row, int col, int val) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
            if (board[i][col] == val) {
                return false;
            }
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == val) {
                return false;
            }
        }
        return true;
    }

    public static boolean solveSudoku(int[][] matrix) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrix[i][j] == 0) {
                    for (int val = 1; val <= 9; val++) {
                        if (canPlace(matrix, i, j, val)) {
                            matrix[i][j] = val;
                            if (solveSudoku(matrix)) {
                                return true;
                            }
                            matrix[i][j] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isItSudoku(int matrix[][]) {
        return solveSudoku(matrix);
    }

    public static void main(String[] args) {
        int[][] board = { { 9, 0, 0, 0, 2, 0, 7, 5, 0 },
                { 6, 0, 0, 0, 5, 0, 0, 4, 0 },
                { 0, 2, 0, 4, 0, 0, 0, 1, 0 },
                { 2, 0, 8, 0, 0, 0, 0, 0, 0 },
                { 0, 7, 0, 5, 0, 9, 0, 6, 0 },
                { 0, 0, 0, 0, 0, 0, 4, 0, 1 },
                { 0, 1, 0, 0, 0, 5, 0, 8, 0 },
                { 0, 9, 0, 0, 7, 0, 0, 0, 4 },
                { 0, 8, 2, 0, 4, 0, 0, 0, 6 } };
        if (isItSudoku(board)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
