class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strToStringsMap = new HashMap<>();
        for (String s: strs) {
            String sortedStr = convertToSortedString(s);
            if (!strToStringsMap.containsKey(sortedStr)) {
                strToStringsMap.put(sortedStr, new ArrayList<>());
            }

            strToStringsMap.get(sortedStr).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(strToStringsMap.values());

        return result;
    }

    public String convertToSortedString(String s) {
        char[] sortedChar = s.toCharArray();
        Arrays.sort(sortedChar);
        return new String(sortedChar);
    }
}
