class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        /**
        iterate until interval.end <= newInterval.start
        merge: while interval.end <= nextInterval.start:
            1. end = max(interval.end, newInteval.end)
        **/

        List<int[]> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int start = newInterval[0];
        int end = newInterval[1];

        while (i < intervals.length && end >= intervals[i][0] && intervals[i][1] >= start) {
            start = Math.min(intervals[i][0], start);
            end = Math.max(intervals[i][1], end);
            i++;
        }

        result.add(new int[]{start, end});

        while (i < intervals.length) {
            result.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int[][] resultInt = new int[result.size()][];

        for (int it=0;it<result.size();it++) {
            resultInt[it] = new int[]{result.get(it)[0], result.get(it)[1]};
        }

        return resultInt;
    }
}
