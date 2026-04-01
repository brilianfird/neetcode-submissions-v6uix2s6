class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> positionToSpeed = new ArrayList<>();

        for (int i=0;i<position.length;i++) {
            positionToSpeed.add(new int[]{position[i], speed[i]});
        }
        Collections.sort(positionToSpeed, (a, b) -> Integer.compare(b[0], a[0]));

        Deque<Double> timeStack = new ArrayDeque<>();

        for (int i=0;i<positionToSpeed.size();i++) {
            double time = (double)(target - positionToSpeed.get(i)[0]) / positionToSpeed.get(i)[1];
            timeStack.offerLast(time);
        }

        int result = 0;

        while (timeStack.size() != 0) {
            result++;
            double curr = timeStack.pollFirst();
            while (timeStack.size() != 0 && timeStack.peekFirst() <= curr) timeStack.pollFirst();
        }


        return result;
    }
}