class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int cycle = 0;
        PriorityQueue<int[]> cooldown = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for(char task : tasks) {
            if (!freqMap.containsKey(task)) {
                freqMap.put(task, 0);
            }

            freqMap.put(task, freqMap.get(task)+1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            heap.offer(new int[]{entry.getValue(), entry.getKey()});
        }

        while (!heap.isEmpty() || !cooldown.isEmpty()) {
            cycle++;
            while (!cooldown.isEmpty() && cooldown.peek()[0] <= cycle) {
                int[] currCooldown = cooldown.poll();
                heap.offer(new int[]{currCooldown[1], currCooldown[2]});
            }

            if (heap.isEmpty()) {
                continue;
            }
            int[] currTask = heap.poll();
            if (currTask[0] != 1) {
                cooldown.offer(new int[]{cycle+n+1, currTask[0]-1, currTask[1]});
            }
        }

        return cycle;
    }
}
