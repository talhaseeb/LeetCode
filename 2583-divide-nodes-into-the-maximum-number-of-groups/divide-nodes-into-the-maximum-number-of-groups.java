
class Solution {
    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        int[] component = new int[n + 1];
        int componentCount = 0;
        Map<Integer, Set<Integer>> components = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            if (component[i] == 0) {
                componentCount++;
                components.put(componentCount, new HashSet<>());
                dfs(i, graph, component, componentCount, components);
            }
        }
        
        int result = 0;
        for (Set<Integer> comp : components.values()) {
            int maxGroups = 0;
            for (int node : comp) {
                maxGroups = Math.max(maxGroups, bfs(node, graph, n));
            }
            if (maxGroups == 0) return -1;
            result += maxGroups;
        }
        return result;
    }
    
    private void dfs(int node, List<List<Integer>> graph, int[] component, int componentCount, Map<Integer, Set<Integer>> components) {
        component[node] = componentCount;
        components.get(componentCount).add(node);
        for (int neighbor : graph.get(node)) {
            if (component[neighbor] == 0) {
                dfs(neighbor, graph, component, componentCount, components);
            }
        }
    }
    
    private int bfs(int start, List<List<Integer>> graph, int n) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        queue.offer(start);
        distance[start] = 0;
        int maxDepth = 0;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            maxDepth = Math.max(maxDepth, distance[node]);
            
            for (int neighbor : graph.get(node)) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.offer(neighbor);
                } else if (Math.abs(distance[neighbor] - distance[node]) != 1) {
                    return 0;
                }
            }
        }
        
        return maxDepth + 1;
    }
}
