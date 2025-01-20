public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        HashMap<Integer, int[]> positionMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                positionMap.put(mat[i][j], new int[]{i, j});
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int[] pos = positionMap.get(num);            
            int row = pos[0];
            int col = pos[1];

            rowCount[row]++;
            colCount[col]++;

            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }

        return -1;
    }
}
