class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> subString = new HashSet<>();
        int result = 0;
        int j = 0;
        for (int i=0; i<s.length(); i++){
            while(subString.contains(s.charAt(i))){
                subString.remove(s.charAt(j));
                j++;
            }
            subString.add(s.charAt(i));
            result = Math.max(result, i - j + 1);
        }
        return result;
    }
}