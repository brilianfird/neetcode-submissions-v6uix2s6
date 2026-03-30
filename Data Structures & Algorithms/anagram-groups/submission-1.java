class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strToStringsMap = new HashMap<>();
        
        for (String s:strs) {
            char[] charFreq = new char[26];

            for (char c:s.toCharArray()) {
                charFreq[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i=0;i<26;i++) {
                sb.append(charFreq[i]).append("#");
            }
            String key = sb.toString();
            strToStringsMap.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(strToStringsMap.values());
    }
}
