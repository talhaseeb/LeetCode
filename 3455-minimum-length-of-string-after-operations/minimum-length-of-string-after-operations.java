class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0) + 1);
        }
        int deleteCount = 0;
        for (int freq : charFrequencyMap.values()) {
            if (freq % 2 == 1) {
                
                deleteCount += (freq - 1);
            } else {
                deleteCount += (freq - 2);
            }
        }
        return s.length() - deleteCount;
    }
}