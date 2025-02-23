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
public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre, 0, pre.length - 1, post, 0, post.length - 1);
    }
    
    private TreeNode helper(int[] pre, int preStart, int preEnd,
                            int[] post, int postStart, int postEnd) {
        if (preStart > preEnd) return null;
        
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart == preEnd) return root;
        
        int leftRootVal = pre[preStart + 1];
        int leftRootIndex = postStart;
        while (post[leftRootIndex] != leftRootVal) {
            leftRootIndex++;
        }
        
        int leftSize = leftRootIndex - postStart + 1;
        
        root.left = helper(pre, preStart + 1, preStart + leftSize,
                           post, postStart, leftRootIndex);
        root.right = helper(pre, preStart + leftSize + 1, preEnd,
                            post, leftRootIndex + 1, postEnd - 1);
        return root;
    }
}