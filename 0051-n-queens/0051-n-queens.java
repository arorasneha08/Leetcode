import java.util.*;

class Solution {
    public void backtrack(int row, int n, char[][] board, List<List<String>> result, 
                          boolean col[], boolean upperDiag[], boolean lowerDiag[]) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col[c] || upperDiag[row - c + n - 1] || lowerDiag[row + c]) continue;

            board[row][c] = 'Q';
            col[c] = true;
            upperDiag[row - c + n - 1] = true;
            lowerDiag[row + c] = true;

            backtrack(row + 1, n, board, result, col, upperDiag, lowerDiag);

            // Backtracking (Undo Changes)
            board[row][c] = '.';
            col[c] = false;
            upperDiag[row - c + n - 1] = false;
            lowerDiag[row + c] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean col[] = new boolean[n];
        boolean upperDiag[] = new boolean[2 * n];  // Major diagonal (row - col)
        boolean lowerDiag[] = new boolean[2 * n];  // Minor diagonal (row + col)

        backtrack(0, n, board, result, col, upperDiag, lowerDiag);
        return result;
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int n = 8; // Change for different N
        List<List<String>> solutions = solver.solveNQueens(n);

        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
