import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        int maxLen = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int expected = arr[j] - arr[i];
                Integer k = indexMap.get(expected);
                if (k != null && k < i) {
                    dp[i][j] = dp[k][i] > 0 ? dp[k][i] + 1 : 3;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
                
            }
        }
        return maxLen >= 3 ? maxLen : 0;
    }
}
