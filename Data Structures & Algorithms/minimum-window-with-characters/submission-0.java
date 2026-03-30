class Solution {
    public String minWindow(String s, String t) {
        String result = "";
        int resultLength = Integer.MAX_VALUE;
        Map<Character, Integer> charFreq = new HashMap<>();
        int found = 0;
        int start = 0;
        /**
        t = "AB"
        s = "AABBAA"
        **/

        for (char c:t.toCharArray()) {
            if (!charFreq.containsKey(c)) {
                charFreq.put(c, 0);
            }
            charFreq.put(c, charFreq.get(c)+1);
        }

        for (int end=0;end<s.length();end++) {
            char endChar = s.charAt(end);
            if (charFreq.containsKey(endChar)) {
                charFreq.put(endChar, charFreq.get(endChar)-1);
                if (charFreq.get(endChar) == 0) {
                    found++;
                }
            }

            while (found == charFreq.size()) {
                if (resultLength > end - start + 1) {
                    result = s.substring(start, end+1);
                    resultLength = end - start + 1;
                }

                char startChar = s.charAt(start);

                if (charFreq.containsKey(startChar)) {
                    charFreq.put(startChar, charFreq.get(startChar)+1);
                    if (charFreq.get(startChar) > 0) {
                        found--;
                    }
                }
                start++;
            }
        }

        return result;
    }
}
