public class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] answer = new char[n];
        for (int i = 0; i < n; i++) {
            answer[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return new String(answer);
    }
}
