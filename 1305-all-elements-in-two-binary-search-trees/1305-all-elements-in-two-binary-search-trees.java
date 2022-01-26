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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new ArrayList<>();
        this.traverse(root1, result);
        this.traverse(root2, result);
        
        Collections.sort(result);
        
        return result;
    }
    
    
    public void traverse(TreeNode root, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null) {
            queue.add(root);
        }
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);

            if(node.left != null) {queue.offer(node.left);}
            if(node.right != null) {queue.offer(node.right);}
        }
    }
}