public class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;
        long countEven = 0, countOdd = 0;
        int prefix = 0;  
        countEven++; 
        for (int num : arr) {
            prefix = (prefix + num) % 2;
            if (prefix == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }
        
        long result = (countEven * countOdd) % mod;
        return (int) result;
    }
}
