class Solution {
    public boolean isArraySpecial(int[] nums) {
       if (nums.length == 1) {
            return true;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            int current = nums[i];
            int next = nums[i + 1];
            
            if ((current % 2 == 0 && next % 2 == 0) || (current % 2 != 0 && next % 2 != 0)) {
                return false;
            }
        }
        
        return true;
    }
}