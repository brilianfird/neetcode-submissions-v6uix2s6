class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
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
            
            if (grid[i][j] > dist) {
                grid[i][j] = dist;
            }

            for (int[] dir: dirs) {
                int nextI = i+dir[0];
                int nextJ = j+dir[1];

                if (nextI < 0 || nextJ < 0 || nextI >= grid.length 
                || nextJ >= grid[i].length) {
                    continue;
                }

                if (grid[nextI][nextJ] != Integer.MAX_VALUE) {
                    continue;
                }

                queue.offer(new int[]{nextI, nextJ, dist+1});
            }
        }
    }
}
