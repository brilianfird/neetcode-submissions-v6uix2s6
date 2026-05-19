class Solution {
    public int numIslands(char[][] grid) {
        int islandCount = 0;
        
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == '1') {
                    islandCount += 1;
                    traverseIsland(grid, i, j);
                }
            }
        }
        return islandCount;
    }

    private void traverseIsland(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) return;
        if (grid[i][j] == '0') return;

        grid[i][j] = '0';
        traverseIsland(grid, i+1,j);
        traverseIsland(grid, i-1,j);
        traverseIsland(grid, i,j+1);
        traverseIsland(grid, i,j-1);
    }
}
