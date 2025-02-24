public class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = edges.length + 1;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        int[] parent = new int[n];
        int[] depth = new int[n];
        Arrays.fill(parent, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        parent[0] = -1;
        depth[0] = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (parent[v] == -1 && v != parent[u]) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    q.add(v);
                }
            }
        }

        Map<Integer, Integer> bobTime = new HashMap<>();
        int current = bob;
        int time = 0;
        while (current != -1) {
            bobTime.put(current, time);
            current = parent[current];
            time++;
        }

        int[] contribution = new int[n];
        for (int i = 0; i < n; i++) {
            if (bobTime.containsKey(i)) {
                int aliceT = depth[i];
                int bobT = bobTime.get(i);
                if (aliceT < bobT) {
                    contribution[i] = amount[i];
                } else if (aliceT == bobT) {
                    contribution[i] = amount[i] / 2;
                } else {
                    contribution[i] = 0;
                }
            } else {
                contribution[i] = amount[i];
            }
        }

        int maxSum = Integer.MIN_VALUE;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, contribution[0]});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int node = curr[0];
            int sum = curr[1];
            boolean isLeaf = true;

            for (int neighbor : adj.get(node)) {
                if (neighbor != parent[node]) {
                    isLeaf = false;
                    queue.add(new int[]{neighbor, sum + contribution[neighbor]});
                }
            }

            if (isLeaf) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }
}