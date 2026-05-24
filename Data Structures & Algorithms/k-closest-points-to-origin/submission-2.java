class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for(int[] point : points) {
            int dist = calcDistance(point);
            heap.offer(new int[]{dist, point[0], point[1]});
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[][] result = new int[k][];
        int i=0;
        while (!heap.isEmpty()) {
            int[] node = heap.poll();
            result[i] = new int[]{node[1], node[2]};
            i++;
        }

        return result;
    }

    private int calcDistance(int[] point) {
        return (point[0]*point[0]) + (point[1] * point[1]);
    }
}
