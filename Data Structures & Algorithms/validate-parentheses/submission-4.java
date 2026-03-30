class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put('(', ')');
        charMap.put('{', '}');
        charMap.put('[', ']');

        for (char c : s.toCharArray()) {
            if (charMap.containsKey(c)) {
                stack.offerFirst(charMap.get(c));
                continue;
            }

            if (stack.isEmpty() || stack.pollFirst() != c) {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
