public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }

        int n = s1.length();
        int firstDiff = -1, secondDiff = -1;
        
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (firstDiff == -1) {
                    firstDiff = i;
                } else if (secondDiff == -1) {
                    secondDiff = i;
                } else {
                    return false;
                }
            }
        }

        if (firstDiff == -1 || secondDiff == -1) {
            return false;
        }

        return s1.charAt(firstDiff) == s2.charAt(secondDiff) &&
               s1.charAt(secondDiff) == s2.charAt(firstDiff);
    }
}
