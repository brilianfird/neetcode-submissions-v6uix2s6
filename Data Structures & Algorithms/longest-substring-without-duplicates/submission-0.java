class Solution {
    public int lengthOfLongestSubstring(String s) {
        /**
        s = "zxyzxyz"
        Map<String, int> strToIdxMap
        int maxLength = 0;
        int startWindow = 0;

        loop (endWindow < s.length)

            if endWindowChar in strToIdxMap and startWindow <= mapCharIdx:
                startWindow = mapCharIdx+1
            strToIdxMap[endWindowChar] = endWindow
            maxLength = max(maxLength, endWindow - startWindow + 1)
        return maxLength;
        **/

        Map<Character, Integer> charToIdxMap = new HashMap<>();
        int maxLength = 0;
        int startWindow = 0;

        for (int endWindow=0;endWindow<s.length();endWindow++) {
            char endWindowChar = s.charAt(endWindow);
            if (charToIdxMap.containsKey(endWindowChar) && startWindow <= charToIdxMap.get(endWindowChar)) {
                startWindow = charToIdxMap.get(endWindowChar) + 1;
            }
            charToIdxMap.put(endWindowChar, endWindow);
            maxLength = Math.max(maxLength, endWindow - startWindow + 1);
        }
        return maxLength;
    }
}
