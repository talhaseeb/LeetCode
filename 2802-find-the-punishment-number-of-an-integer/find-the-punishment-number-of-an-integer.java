public class Solution {
    public int punishmentNumber(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++) {
            String squareStr = String.valueOf((long) i * i);
            if (canPartition(squareStr, 0, 0, i)) {
                total += i * i;
            }
        }
        return total;
    }
    
    private boolean canPartition(String s, int index, int currentSum, int target) {
        if (index == s.length()) {
            return currentSum == target;
        }
        
        long num = 0;
        for (int j = index; j < s.length(); j++) {
            num = num * 10 + (s.charAt(j) - '0');
            if (currentSum + num > target) break;
            if (canPartition(s, j + 1, currentSum + (int)num, target)) {
                return true;
            }
        }
        return false;
    }
}