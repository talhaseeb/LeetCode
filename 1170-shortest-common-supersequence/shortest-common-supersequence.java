public class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        if (str1.equals(str2)) return str1;
        
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0){
            if (str1.charAt(i - 1) == str2.charAt(j - 1)){
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]){
                i--;
            } else {
                j--;
            }
        }
        lcs.reverse();
        String lcsStr = lcs.toString();
        
        StringBuilder res = new StringBuilder();
        i = 0; 
        j = 0;
        for (char c : lcsStr.toCharArray()){
            while (i < m && str1.charAt(i) != c){
                res.append(str1.charAt(i));
                i++;
            }
            while (j < n && str2.charAt(j) != c){
                res.append(str2.charAt(j));
                j++;
            }
            res.append(c);
            i++;
            j++;
        }
        res.append(str1.substring(i));
        res.append(str2.substring(j));
        
        return res.toString();
    }
}
