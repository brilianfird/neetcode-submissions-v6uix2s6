class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1) return search2D(matrix[0], target);
        for (int i=0;i<matrix.length;i++) {
            if (matrix[i][0] == target) return true;
            if (matrix[i][0] > target) {
                if (i==0) return false;
                return search2D(matrix[i-1], target);
            }
            if (i == matrix.length-1) return search2D(matrix[i], target);
        }
        return false;
    }

    public boolean search2D(int[] matrix, int target) {
        int left = 0;
        int right = matrix.length-1;
        while (left <= right) {
            int mid = (left+right) / 2;
            if (matrix[mid] < target) {
                left++;
            } else if (matrix[mid] > target) {
                right--;
            } else {
                return true;
            }
        }

        return false;
    }
}
