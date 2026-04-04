class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int i=0;i<piles.length;i++) {
            if (piles[i] > right) right = piles[i];
        }

        while (left < right) {
            int mid = (left+right) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public boolean canFinish(int[] piles, int h, int k) {
        int hour = 0;
        for (int pile:piles) {
            hour += Math.ceil((double) pile/ (double)k);
        }
        return hour <= h;
    }
}
