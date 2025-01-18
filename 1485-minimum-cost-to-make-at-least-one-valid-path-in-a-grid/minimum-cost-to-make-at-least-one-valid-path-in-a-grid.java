class Solution {
   public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[m][n];
        for (int[] row : cost) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        cost[0][0] = 0;

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[]{0, 0, 0}); // {x, y, cost}

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int x = current[0], y = current[1], currentCost = current[2];

            if (currentCost > cost[x][y]) continue;

            for (int dir = 1; dir <= 4; dir++) {
                int newX = x + directions[dir - 1][0];
                int newY = y + directions[dir - 1][1];
                int newCost = currentCost + (grid[x][y] == dir ? 0 : 1);

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && newCost < cost[newX][newY]) {
                    cost[newX][newY] = newCost;

                    if (grid[x][y] == dir) {
                        deque.addFirst(new int[]{newX, newY, newCost}); 
                    } else {
                        deque.addLast(new int[]{newX, newY, newCost}); 
                    }
                }
            }
        }

        return cost[m - 1][n - 1];
    }

}