import java.util.*;

public class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        
        for (int x : nums) {
            int s = sumDigits(x);
            if (!map.containsKey(s)) {
        
                map.put(s, new int[]{x, -1});
            } else {
                int[] pair = map.get(s);
                if (x > pair[0]) {
                    pair[1] = pair[0];
                    pair[0] = x;
                } else if (x > pair[1]) {
                    pair[1] = x;
                }
            }
        }
        
        int ans = -1;
        for (int[] pair : map.values()) {
            if (pair[1] != -1) {  
                ans = Math.max(ans, pair[0] + pair[1]);
            }
        }
        
        return ans;
    }
    
    private int sumDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
