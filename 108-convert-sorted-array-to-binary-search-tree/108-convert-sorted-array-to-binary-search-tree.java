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
   public TreeNode sortedArrayToBST(int[] nums) {
    int n = nums.length;
    TreeNode[] tree = new TreeNode[n];

    for (int i = 0; i < n; i++) {
      tree[i] = new TreeNode(nums[i]);
    }

    int mid = n / 2;
    createTree(tree, 0, mid - 1, mid, true);
    createTree(tree, mid + 1, n, mid, false);
    return tree[mid];
  }

  private void createTree(TreeNode[] tree, int beg, int end, int root, boolean isLeft) {
    if (end < beg) {
      return;
    }

    int mid = ((end + beg) / 2) ;

    if(mid < 0 || mid >= tree.length) return;
      
    if (isLeft) {
      tree[root].left = tree[mid];
    } else {
      tree[root].right = tree[mid];
    }

    createTree(tree, beg, mid - 1, mid, true);
    createTree(tree, mid + 1, end, mid, false);
  }
}