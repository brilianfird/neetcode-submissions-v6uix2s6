class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> charFreq = new HashMap<>();

        for (Character c:s1.toCharArray()) {
            if (!charFreq.containsKey(c)) charFreq.put(c, 0);

            charFreq.put(c, charFreq.get(c)+1);
        }

        int start = 0;
        int found = 0;
        for (int end=0;end<s2.length();end++) {
            char endChar = s2.charAt(end);

            if (charFreq.containsKey(endChar)) {
                charFreq.put(endChar, charFreq.get(endChar)-1);
                if (charFreq.get(endChar) == 0) found++;
                else if (charFreq.get(endChar) == -1) found--;
            }

            if (end-start+1>s1.length()) {
                char startChar = s2.charAt(start);
                if (charFreq.containsKey(startChar)) {
                    charFreq.put(startChar, charFreq.get(startChar)+1);
                    if (charFreq.get(startChar) == 0) found++;
                    else if (charFreq.get(startChar) == 1) found--;
                }
                start++;
            }

            if (found == charFreq.size()) return true;
        }

        return false;
    }
}
