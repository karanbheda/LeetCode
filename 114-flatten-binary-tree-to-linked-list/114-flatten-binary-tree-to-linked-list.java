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
    public void flatten(TreeNode root) {
        traverse(root);
    }

    private void traverse(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) {
            return;
        }

        if(node.right != null) {
            traverse(node.right);
        }

        if(node.left != null) {
            traverse(node.left);
            TreeNode tempSubtree = node.right;
            node.right = node.left;
            node.left = null;
            TreeNode tempNode = node.right;
            while(tempNode.right != null) {
                tempNode = tempNode.right;
            }
            tempNode.right = tempSubtree;
        }
    }
}