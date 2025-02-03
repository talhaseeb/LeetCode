class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        int inc = 1, dec = 1; 
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
            } else {
                inc = 1;
            }

            if (nums[i] < nums[i - 1]) {
                dec++;
            } else {
                dec = 1;
            }

            max = Math.max(max, Math.max(inc, dec));
        }

        return max;  
    }
}