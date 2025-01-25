class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        // Create indexed pairs
        Integer[] indexedNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexedNums[i] = i;
        }
        
        // Sort indices based on nums values
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(nums[a], nums[b]));
        
        // Initialize result array
        int[] result = new int[n];
        
        // Track groups of swappable elements
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> currentGroup = new ArrayList<>();
        currentGroup.add(indexedNums[0]);
        
        // Group elements that can be swapped
        for (int i = 1; i < n; i++) {
            if (nums[indexedNums[i]] - nums[indexedNums[i-1]] <= limit) {
                currentGroup.add(indexedNums[i]);
            } else {
                groups.add(currentGroup);
                currentGroup = new ArrayList<>();
                currentGroup.add(indexedNums[i]);
            }
        }
        groups.add(currentGroup);
        
        // Process each group
        for (List<Integer> group : groups) {
            // Sort original indices in the group
            Collections.sort(group);
            
            // Sort values in the group
            List<Integer> values = new ArrayList<>();
            for (int idx : group) {
                values.add(nums[idx]);
            }
            Collections.sort(values);
            
            // Reassign smallest values to sorted indices
            for (int i = 0; i < group.size(); i++) {
                result[group.get(i)] = values.get(i);
            }
        }
        
        return result;
    }
}