class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        Set<String> funcMap = new HashSet<>();
        funcMap.add("+");
        funcMap.add("-");
        funcMap.add("*");
        funcMap.add("/");

        for (String token:tokens) {
            if (!funcMap.contains(token)) {
                stack.offerLast(Integer.valueOf(token));
                continue;
            }

            int num1 = stack.pollLast();
            int num2 = stack.pollLast();

            switch(token) {
                case "+": stack.offerLast(num1+num2); break;
                case "-": stack.offerLast(num2-num1); break;
                case "*": stack.offerLast(num1*num2); break;
                case "/": stack.offerLast(num2/num1); break;
            }
        }

        return stack.pollLast();
    }
}
