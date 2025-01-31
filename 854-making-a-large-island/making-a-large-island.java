class Solution {
    private int[] parent;
    private int[] size;
    private int n;

    public int largestIsland(int[][] grid) {
        n = grid.length;
        parent = new int[n * n];
        size = new int[n * n];
        
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    unionNeighbors(i, j, grid);
                }
            }
        }
        
        int maxSize = 0;
        boolean hasZero = false;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    maxSize = Math.max(maxSize, 1 + getSizeOfSurroundingIslands(i, j, grid));
                } else {
                    maxSize = Math.max(maxSize, size[find(i * n + j)]);
                }
            }
        }
        
        return hasZero ? maxSize : n * n;
    }
    
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            size[rootX] += size[rootY];
        }
    }
    
    private void unionNeighbors(int i, int j, int[][] grid) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int current = i * n + j;
        
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                union(current, ni * n + nj);
            }
        }
    }
    
    private int getSizeOfSurroundingIslands(int i, int j, int[][] grid) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        Set<Integer> islands = new HashSet<>();
        
        for (int k = 0; k < 4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];
            if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                islands.add(find(ni * n + nj));
            }
        }
        
        int totalSize = 0;
        for (int island : islands) {
            totalSize += size[island];
        }
        return totalSize;
    }
}