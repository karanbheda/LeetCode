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
    int count = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] digits = new int[10];
        dfs(root, digits);
        
        return count;
    }
    
    private void dfs(TreeNode node, int[] digits) {
        if(node == null) {return;}
        
        digits[node.val]++;
        
        if(node.left == null && node.right == null) {
            int odd = 0;
            for(int digit: digits) {
                if(digit%2 == 1) {odd++;}
            }
            
            if(odd <= 1) {
                count++;
            }
        }
        
        dfs(node.left, digits);
        dfs(node.right, digits);
        
        digits[node.val]--;
    }
    
}