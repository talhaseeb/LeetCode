
class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxFish = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    int currentSum = grid[i][j];
                    
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        for (int[] dir : directions) {
                            int r = cell[0] + dir[0];
                            int c = cell[1] + dir[1];
                            if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] > 0) {
                                visited[r][c] = true;
                                currentSum += grid[r][c];
                                queue.add(new int[]{r, c});
                            }
                        }
                    }
                    maxFish = Math.max(maxFish, currentSum);
                }
            }
        }
        return maxFish;
    }
}