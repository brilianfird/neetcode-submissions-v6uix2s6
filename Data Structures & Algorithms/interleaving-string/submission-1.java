class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return canInterleave(s1, s2, s3, "", 0, 0, 0);
    }

    public boolean canInterleave(String s1, String s2, String s3, String currString, int idx1, int idx2, int idx3) {
        if (currString.equals(s3)) {
            return true;
        } else if (idx1 == s1.length() && idx2 == s2.length()) {
            return false;
        }

        boolean result = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
            result = result || canInterleave(s1, s2, s3, currString + s1.charAt(idx1), idx1+1, idx2, idx3+1);
        }

        if (idx2 < s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
            result = result || canInterleave(s1, s2, s3, currString + s2.charAt(idx2), idx1, idx2+1, idx3+1);
        }

        return result;

    }
}
