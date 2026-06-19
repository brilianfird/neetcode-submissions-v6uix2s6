class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, "", result);
        return result;
    }

    public void generate(int n, int open, int closed, String currResult, List<String> result) {
        if (open == n && closed == n) {
            result.add(currResult);
            return;
        }
        if (open < n) {
            currResult += "(";
            generate(n, open + 1, closed, currResult, result);
            currResult = currResult.substring(0, currResult.length() - 1);
        }
        if (closed < open) {
            currResult += ")";
            generate(n, open, closed + 1, currResult, result);
            currResult = currResult.substring(0, currResult.length() - 1);
        }
    }
}
