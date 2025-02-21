/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class FindElements {
    private Set<Integer> recoveredValues;
    
    public FindElements(TreeNode root) {
        recoveredValues = new HashSet<>();
        // Recover the tree starting from the root (set its value to 0).
        recover(root, 0);
    }
    
    private void recover(TreeNode node, int value) {
        if (node == null) return;
        node.val = value;
        recoveredValues.add(value);
        if (node.left != null) {
            recover(node.left, 2 * value + 1);
        }
        if (node.right != null) {
            recover(node.right, 2 * value + 2);
        }
    }
    
    public boolean find(int target) {
        return recoveredValues.contains(target);
    }
}

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}


/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */