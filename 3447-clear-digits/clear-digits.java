public class Solution {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (true) {
            int index = findFirstDigit(sb);
            if (index == -1) { 
                break;
            }
            if (index == 0) {
                sb.deleteCharAt(0);
            } else {
                sb.deleteCharAt(index - 1); 
                sb.deleteCharAt(index - 1); 
            }
        }
        return sb.toString();
    }
    
    // Helper method: returns the index of the first digit in sb, or -1 if none exists.
    private int findFirstDigit(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
}
