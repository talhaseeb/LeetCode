public class Solution {
    private int n;
    private int L;
    private int[] ans;
    private int[] count;

    public int[] constructDistancedSequence(int n) {
        this.n = n;
        L = 2 * n - 1;
        ans = new int[L];
        count = new int[n + 1];
        backtrack(0);
        return ans;
    }
    
    private boolean backtrack(int index) {
        if (index == L) {
            return true;
        }
        if (ans[index] != 0) {
            return backtrack(index + 1);
        }
        
        for (int i = n; i >= 1; i--) {
            if (i == 1) {
                if (count[1] == 0) {
                    ans[index] = 1;
                    count[1] = 1;
                    if (backtrack(index + 1)) {
                        return true;
                    }
                    ans[index] = 0;
                    count[1] = 0;
                }
            } else {
                if (count[i] == 0) {
                    int secondIndex = index + i;
                    if (secondIndex < L && ans[secondIndex] == 0) {
                        ans[index] = i;
                        ans[secondIndex] = i;
                        count[i] = 2;
                        if (backtrack(index + 1)) {
                            return true;
                        }
                        ans[index] = 0;
                        ans[secondIndex] = 0;
                        count[i] = 0;
                    }
                }
            }
        }
        return false;
    }
}
