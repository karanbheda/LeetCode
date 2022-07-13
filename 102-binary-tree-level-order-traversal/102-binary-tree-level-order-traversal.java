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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(root != null) {
            int noOfPrevChild = 1, noOfPoppedElements = 0, noOfNextChild = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<Integer> levelList = new ArrayList<>();
            
            while(queue.size() > 0) {
                root = queue.remove();
                noOfPoppedElements++;
                levelList.add(root.val);
                
                if(root.left != null) {
                    queue.add(root.left);
                    noOfNextChild++;
                }
                if(root.right != null) {
                    queue.add(root.right);
                    noOfNextChild++;
                }
                
                if(noOfPoppedElements == noOfPrevChild) {
                    result.add(levelList);
                    levelList = new ArrayList<>();
                    noOfPrevChild = noOfNextChild;
                    noOfPoppedElements = 0;
                    noOfNextChild = 0;
                }
                
                
            }
        }
        
        return result;
    }
}