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
            StringBuilder lengthString = new StringBuilder();
            while (!str.substring(currIdx, currIdx+1).equals("#")) {
                lengthString.append(str.substring(currIdx, currIdx+1));
                currIdx++;
            }
            int length = Integer.valueOf(lengthString.toString());
            result.add(str.substring(currIdx+1, currIdx+1+length));
            currIdx = currIdx+1+length;
        }
        return result;
    }
}
