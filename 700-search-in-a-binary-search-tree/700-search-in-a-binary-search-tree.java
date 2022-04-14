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
    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }
    
    private TreeNode search(TreeNode node, int target) {
        if(node == null) {
            return null;
        }
        
        if(node.val == target) {
            return node;
        }
        
        TreeNode left = null;
        TreeNode right = null;
        
        if(node.left != null) {
            left = search(node.left, target);
        }
        
        if(node.right != null) {
            right = search(node.right, target);
        }
        
        return left == null? right:left;
    }
}