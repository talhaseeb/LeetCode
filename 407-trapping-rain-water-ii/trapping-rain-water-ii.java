public class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) return 0;

       PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new int[]{heightMap[i][j], i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int totalWater = 0;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int height = cell[0];
            int x = cell[1];
            int y = cell[2];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }

               totalWater += Math.max(0, height - heightMap[nx][ny]);

                
                pq.offer(new int[]{Math.max(height, heightMap[nx][ny]), nx, ny});
                visited[nx][ny] = true;
            }
        }

        return totalWater;
    }
}