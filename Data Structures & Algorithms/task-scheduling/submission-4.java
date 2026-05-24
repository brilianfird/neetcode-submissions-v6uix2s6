class Solution {
    public int leastInterval(char[] tasks, int n) {
        /**
        Basically the result is task with most frequency * n + how many char with the same max frequency
        **/

        int[] freq = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;

        for (char task : tasks) {
            freq[task - 'A']++;
            maxFreq = Math.max(freq[task - 'A'], maxFreq);
        }

        // get max freq
        for (int f : freq) {
            if (f == maxFreq) maxFreqCount++;
        }
        

        return Math.max(tasks.length, (maxFreq - 1) * (n+1) + maxFreqCount);
    }
}
