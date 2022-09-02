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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> average = new ArrayList<>();
        if(root != null) {
            queue.add(root);
            int noOfChildren = 0;
            int noOfPrevChildren = 1;
            int noOfLevelNodes = 1;
            long sumOfLevelNodes = 0;
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                sumOfLevelNodes += node.val;
                noOfPrevChildren--;
                if(node.left != null) {
                    queue.add(node.left);
                    noOfChildren++;
                }
                if(node.right != null) {
                    queue.add(node.right);
                    noOfChildren++;
                }
                
                if(noOfPrevChildren == 0) {
                    average.add(sumOfLevelNodes/(double)noOfLevelNodes);
                    noOfPrevChildren = noOfChildren;
                    noOfLevelNodes = noOfPrevChildren;
                    sumOfLevelNodes = 0;
                    noOfChildren = 0;
                }
            }
        }
        
        return average;
    }
}