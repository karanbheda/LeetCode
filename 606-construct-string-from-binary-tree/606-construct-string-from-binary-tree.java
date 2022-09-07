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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        return sb.toString();
    }
    
    private void solve(TreeNode node, StringBuilder sb) {
        if(node == null) {
           // sb.append("()");
            return;
        }
        
        if(node.left == null && node.right == null) {
            sb.append(node.val);
            return;
        }
        
        sb.append(node.val).append('(');
        solve(node.left, sb);
        sb.append(')');
        if(node.right != null) {
            sb.append('(');
            solve(node.right, sb);
            sb.append(')');
        }
        
    }
}