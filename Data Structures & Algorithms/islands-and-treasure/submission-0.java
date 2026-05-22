class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i,j,0});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int i = node[0];
            int j = node[1];
            int dist = node[2];
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
                continue;
            }

            if (grid[i][j] != Integer.MAX_VALUE && grid[i][j] != 0) {
                continue;
            }
            if (grid[i][j] != 0) grid[i][j] = dist;
            queue.offer(new int[]{i+1,j,dist+1});
            queue.offer(new int[]{i-1,j,dist+1});
            queue.offer(new int[]{i,j+1,dist+1});
            queue.offer(new int[]{i,j-1,dist+1});
        }
    }
}
