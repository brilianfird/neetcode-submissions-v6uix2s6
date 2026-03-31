class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0;i<temperatures.length;i++) {

            while (stack.size() != 0 && temperatures[stack.peekLast()] < temperatures[i]) {
                int lastIdx = stack.pollLast();
                result[lastIdx] = i - lastIdx;
            }

            stack.offerLast(i);
        }

        return result;
    }
}
