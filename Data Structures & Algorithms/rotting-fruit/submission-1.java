class Solution {
    public int orangesRotting(int[][] grid) {
        /**
        1. Do BFS from rotten orange
        2. Check the next cell. skip if wrong index or index is rotten orange/empty
        3. Iterate until queue is empty
        4. At the end, check if there's still a fresh orange

        Edge case:
        1. All fresh orange: just return -1
        2. All rotten orange: return 0
        **/

        // Initialize Variable
        int currMin = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] dirs = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
        boolean freshFound = false;

        // Fill queue with rotten orange
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i,j});
                } else if (grid[i][j] == 1) {
                    freshFound = true;
                }
            }
        }

        // Validate for early return
        if (queue.isEmpty()) {
            if (!freshFound) {
                return 0;
            }
            return -1;
        }

        if (!freshFound) {
            return 0;
        }
        
        // Process BFS queue
        while (!queue.isEmpty()) {
            int queueLength = queue.size();

            for (int it=0;it<queueLength;it++) {
                int[] currNode = queue.poll();

                for(int[] dir:dirs) {
                    int nextI = currNode[0] + dir[0];
                    int nextJ = currNode[1] + dir[1];

                    if (nextI < 0 || nextJ < 0 || nextI >= grid.length || nextJ >= grid[nextI].length ||
                        grid[nextI][nextJ] != 1) continue;

                    grid[nextI][nextJ] = 2;
                    queue.offer(new int[]{nextI, nextJ}); 
                }
            }
            currMin++;
        }

        // Check if fresh orange still exist
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return --currMin;

    }
}
