class Solution {
    public boolean canBeValid(String s, String locked) {
    if (s.length() % 2 != 0) {
            return false;
        }

        // Forward pass
        int openCount = 0, flexCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    openCount++;
                } else {
                    openCount--;
                }
            } else {
                flexCount++;
            }

            // If openCount < 0, try to use flexible characters to balance
            if (openCount < 0) {
                flexCount += openCount; // Use flexible chars to neutralize openCount
                openCount = 0;
            }

            // If both openCount and flexCount go negative, invalid
            if (openCount + flexCount < 0) {
                return false;
            }
        }

        // Backward pass
        int closeCount = 0;
        flexCount = 0; // Reset flexCount
        for (int i = s.length() - 1; i >= 0; i--) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == ')') {
                    closeCount++;
                } else {
                    closeCount--;
                }
            } else {
                flexCount++;
            }

            // If closeCount < 0, try to use flexible characters to balance
            if (closeCount < 0) {
                flexCount += closeCount; // Use flexible chars to neutralize closeCount
                closeCount = 0;
            }

            // If both closeCount and flexCount go negative, invalid
            if (closeCount + flexCount < 0) {
                return false;
            }
        }

        return true;
    }
}