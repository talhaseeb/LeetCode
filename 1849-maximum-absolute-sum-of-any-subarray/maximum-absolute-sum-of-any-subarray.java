public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prefix = 0;
        int maxPrefix = 0;
        int minPrefix = 0;
        for (int num : nums) {
            prefix += num;
            maxPrefix = Math.max(maxPrefix, prefix);
            minPrefix = Math.min(minPrefix, prefix);
        }
        return maxPrefix - minPrefix;
    }
}
