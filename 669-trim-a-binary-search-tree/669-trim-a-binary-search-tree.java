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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        while(root != null && (root.val < low || root.val > high)) {
            if(root.val < low) {root = root.right;}
            else {root = root.left;}
        }
        
        dfs(root, low, high);
        
        return root;
    }
    
    private void dfs(TreeNode node, int low, int high) {
        if(node == null) {return;}
        
        if(node.left != null && node.left.val < low) {node.left = node.left.right; dfs(node, low, high);} 
        else {dfs(node.left, low, high);}
        
        if(node.right != null && node.right.val > high) {node.right = node.right.left; dfs(node, low, high);} 
        else {dfs(node.right, low, high);}
    }
}