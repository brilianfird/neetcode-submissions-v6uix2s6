class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i=0;i<board.length;i++) {
            if (!checkRow(board, i)) return false;
            if (!checkCol(board, i)) return false;
        }

        for (int i=0;i<board.length;i+=3) {
            for (int j=0;j<board.length;j+=3) {
                if (!checkBox(board, i, j)) return false;
            }
        }
        return true;
    }

    public boolean checkRow(char[][] board, int row) {
        Set<Character> numSet = new HashSet<>();
        for (int i=0;i<board[row].length;i++) {
            if (board[row][i] == '.') continue;
            if (numSet.contains(board[row][i])) return false;
            numSet.add(board[row][i]);
        }
        return true;
    }

    public boolean checkCol(char[][] board, int col) {
        Set<Character> numSet = new HashSet<>();
        for (int i=0;i<board.length;i++) {
            if (board[i][col] == '.') continue;
            if (numSet.contains(board[i][col])) return false;
            numSet.add(board[i][col]);
        }

        return true;
    }

    public boolean checkBox(char[][] board, int row, int col) {
        Set<Character> numSet = new HashSet<>();
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (board[row+i][col+j] == '.') continue;
                if (numSet.contains(board[row+i][col+j])) return false;
                numSet.add(board[row+i][col+j]);
            }
        }
        return true;
    }
}
