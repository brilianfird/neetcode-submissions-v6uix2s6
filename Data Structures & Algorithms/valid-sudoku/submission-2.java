class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new HashSet[9];
        Set<Character>[] colSet = new HashSet[9];
        Set<Character>[] boxSet = new HashSet[9];
        for (int i=0;i < rowSet.length;i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[i].length;j++) {
                char currNum = board[i][j];
                if (currNum == '.') continue;
                int boxIdx = getBoxIdx(i, j);
                if (rowSet[i].contains(currNum) || 
                    colSet[j].contains(currNum) ||
                    boxSet[boxIdx].contains(currNum)) {
                        return false;
                    }
                rowSet[i].add(currNum);
                colSet[j].add(currNum);
                boxSet[boxIdx].add(currNum);
            }
        }

        return true;
    }

    public int getBoxIdx(int row, int col) {
        return (col / 3) + (row / 3) * 3;        
    }
}
