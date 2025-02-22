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
    private int index = 0;
    
    public TreeNode recoverFromPreorder(String S) {
        index = 0; 
        return helper(S, 0);
    }
    
    private TreeNode helper(String S, int level) {
        int n = S.length();
        int count = 0;
        int temp = index;
        while (temp < n && S.charAt(temp) == '-') {
            count++;
            temp++;
        }
        
        if (count != level) {
            return null;
        }
        
        index = temp;
        int num = 0;
        while (index < n && Character.isDigit(S.charAt(index))) {
            num = num * 10 + (S.charAt(index) - '0');
            index++;
        }
        TreeNode node = new TreeNode(num);
        node.left = helper(S, level + 1);
        node.right = helper(S, level + 1);
        return node;
    }
}