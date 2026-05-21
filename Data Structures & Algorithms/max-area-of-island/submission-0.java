class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, traverseIsland(grid, i, j));
                }
            }
        }

        return maxArea;
    }

    public int traverseIsland(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 0;
        area += traverseIsland(grid, i+1, j);
        area += traverseIsland(grid, i-1, j);
        area += traverseIsland(grid, i, j+1);
        area += traverseIsland(grid, i, j-1);
        return area + 1;
    }
}
