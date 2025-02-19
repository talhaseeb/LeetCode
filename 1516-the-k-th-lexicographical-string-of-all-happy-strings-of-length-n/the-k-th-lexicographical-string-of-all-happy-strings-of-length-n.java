public class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), n, result);
        return result.size() < k ? "" : result.get(k - 1);
    }
    
    private void backtrack(StringBuilder sb, int n, List<String> result) {
        if (sb.length() == n) {
            result.add(sb.toString());
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ch) {
                continue;
            }
            sb.append(ch);
            backtrack(sb, n, result);
            sb.deleteCharAt(sb.length() - 1); 
        }
    }
}
