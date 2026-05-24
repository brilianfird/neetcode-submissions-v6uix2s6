class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        for(int[] point : points) {
            int dist = calcDistance(point);
            heap.offer(new int[]{dist, point[0], point[1]});
        }
        int[][] result = new int[k][];
        for (int i = 0;i < k;i++) {
            int[] node = heap.poll();
            result[i] = new int[]{node[1], node[2]};
        }
        return result;
    }

    private int calcDistance(int[] point) {
        return (point[0]*point[0]) + (point[1] * point[1]);
    }
}
