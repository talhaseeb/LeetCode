class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        
        Integer[] indexedNums = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexedNums[i] = i;
        }
        
        Arrays.sort(indexedNums, (a, b) -> Integer.compare(nums[a], nums[b]));
        
        int[] result = new int[n];
        
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> currentGroup = new ArrayList<>();
        currentGroup.add(indexedNums[0]);
        
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
        
        for (List<Integer> group : groups) {
            Collections.sort(group);
            
            List<Integer> values = new ArrayList<>();
            for (int idx : group) {
                values.add(nums[idx]);
            }
            Collections.sort(values);
            
            for (int i = 0; i < group.size(); i++) {
                result[group.get(i)] = values.get(i);
            }
        }
        
        return result;
    }
}