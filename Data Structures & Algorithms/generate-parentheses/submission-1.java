class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    public void generate(int open, int closed, String currResult, List<String> result) {
        if (open == 0 && closed == 0) {
            result.add(currResult);
            return;
        }
        if (open > 0) {
            generate(open - 1, closed, currResult + "(", result);
        }
        if (closed > open) {
            generate(open, closed - 1, currResult + ")", result);
        }
    }
}
