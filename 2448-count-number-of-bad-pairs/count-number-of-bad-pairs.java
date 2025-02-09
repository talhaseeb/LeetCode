public class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long totalPairs = ((long) n * (n - 1)) / 2;
        
        Map<Long, Long> freq = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long diff = i - (long) nums[i];
            freq.put(diff, freq.getOrDefault(diff, 0L) + 1);
        }
        
        long goodPairs = 0;
        for (long count : freq.values()) {
            goodPairs += (count * (count - 1)) / 2;
        }
        
        return totalPairs - goodPairs;
    }
}
