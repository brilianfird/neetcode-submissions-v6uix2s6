class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        strs.forEach(s -> sb.append(s.length()).append("#").append(s));
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int currIdx = 0;
        while (currIdx < str.length()) {
            int hashIdx = str.indexOf("#", currIdx);
            int length = Integer.parseInt(str.substring(currIdx, hashIdx));
            result.add(str.substring(hashIdx+1, hashIdx+1+length));
            currIdx = hashIdx+1+length;
        }
        return result;
    }
}
