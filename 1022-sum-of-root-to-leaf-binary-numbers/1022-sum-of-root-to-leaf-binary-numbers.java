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
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return this.traverse(root, 0);
    }
    
    public int traverse(TreeNode root, int sum) {
        if(root != null ) {
            sum = sum * 2 + root.val;
            if(root.left == null && root.right == null) {
                return sum + this.traverse(root.left, sum) + this.traverse(root.right, sum);
            }
            
            return this.traverse(root.left, sum) + this.traverse(root.right, sum);
        }
        
        return 0;
    }
}