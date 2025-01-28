class Solution:
    def findMaxFish(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0]) if m > 0 else 0
        visited = [[False for _ in range(n)] for _ in range(m)]
        max_fish = 0
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        
        for i in range(m):
            for j in range(n):
                if grid[i][j] > 0 and not visited[i][j]:
                    # BFS initialization
                    q = deque()
                    q.append((i, j))
                    visited[i][j] = True
                    current_sum = grid[i][j]
                    
                    while q:
                        r, c = q.popleft()
                        for dr, dc in directions:
                            nr, nc = r + dr, c + dc
                            if 0 <= nr < m and 0 <= nc < n:
                                if grid[nr][nc] > 0 and not visited[nr][nc]:
                                    visited[nr][nc] = True
                                    current_sum += grid[nr][nc]
                                    q.append((nr, nc))
                    max_fish = max(max_fish, current_sum)
        
        return max_fish