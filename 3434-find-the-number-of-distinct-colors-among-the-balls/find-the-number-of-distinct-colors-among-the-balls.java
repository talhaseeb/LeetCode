class Solution {
    public int[] queryResults(int limit, int[][] queries) {
      int n = queries.length;
        int[] result = new int[n];
        
        // Maps to keep track of ball colors and frequencies of colors.
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorFreq = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];
            
            if (ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);
                if (oldColor != newColor) {
                    // Decrease frequency of the old color.
                    int freq = colorFreq.get(oldColor);
                    if (freq == 1) {
                        colorFreq.remove(oldColor);
                    } else {
                        colorFreq.put(oldColor, freq - 1);
                    }
                    
                    // Update ball's color to newColor.
                    ballColor.put(ball, newColor);
                    
                    // Increase frequency of newColor.
                    colorFreq.put(newColor, colorFreq.getOrDefault(newColor, 0) + 1);
                }
            } else {
                // Ball wasn't colored before.
                ballColor.put(ball, newColor);
                colorFreq.put(newColor, colorFreq.getOrDefault(newColor, 0) + 1);
            }
            
            // The number of distinct colors is the size of colorFreq.
            result[i] = colorFreq.size();
        }
        
        return result;  
    }
}