public class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            stack.push(i + 1);
            
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }
}
