class Solution {
    public int maxScore(String s) {
        int ones = 0;
        int zeros = 0;
        for (char a : s.toCharArray()){
            if(a == '1') {
                ones++;
            }
        }
        int result = 0;
        for (int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == '0'){
                zeros++;
            } else if (s.charAt(i-1) == '1'){
                ones--;
            }
            int score = ones + zeros;
            result = Math.max(result, score);
        }
        return result;
    }
}