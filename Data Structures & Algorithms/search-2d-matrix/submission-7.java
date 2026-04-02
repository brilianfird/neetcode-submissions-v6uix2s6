class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 1) return search2D(matrix[0], target);
        int left = 0;
        int right = matrix.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            System.out.println("mid: " + mid);
            if (matrix[mid][0] < target) {
                if (mid != matrix.length-1 && target > matrix[mid][0] && target < matrix[mid+1][0]) {
                    return search2D(matrix[mid], target);
                }
                left++;
            } else if (matrix[mid][0] > target) {
                right--;
            } else {
                return true;
            }
        }
        // mid = mid == 0 ? 0 : mid-1;
        System.out.println(mid);
        return search2D(matrix[mid], target);
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
