class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> wordDict = new HashMap<>();
        for (char c:s.toCharArray()) {
            if (wordDict.get(c) == null) wordDict.put(c, 0);
            wordDict.put(c, wordDict.get(c)+1);
        }

        for (char c:t.toCharArray()) {
            if (wordDict.get(c) == null) return false;
            wordDict.put(c, wordDict.get(c) - 1);
            if (wordDict.get(c) == 0) {
                wordDict.remove(c);
            }
        }

        return wordDict.size() == 0;
    }
}
