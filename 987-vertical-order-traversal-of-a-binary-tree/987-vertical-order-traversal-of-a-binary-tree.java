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
    class MyNode implements Comparable<MyNode> {
        TreeNode root;
        int x;
        int y;
        
        MyNode(TreeNode root, int x, int y) {
            this.root = root;
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(MyNode n) {
            if(this.x == n.x) {
                if(n.y == this.y) {
                    return this.root.val - n.root.val;
                }
                return n.y - this.y;
            }
            
            return this.x - n.x;
        }
        
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        TreeMap<Integer, List<MyNode>> dfs = new TreeMap<>();
        traverseDFS(root, dfs, 0, 0);
        
        dfs.forEach((y, list) -> {
            Collections.sort(list);
            List<Integer> newList = new ArrayList<>();
            list.forEach(o -> newList.add(o.root.val));
            result.add(newList);
        });
        
            
        return result; 
    }
    
    public void traverseDFS(TreeNode root, Map<Integer, List<MyNode>> dfs, int x, int y) {
        if(root != null)  {
            traverseDFS(root.left, dfs, x-1, y-1);
            traverseDFS(root.right, dfs, x+1, y-1);
            
            List<MyNode> list = dfs.get(x);
            if(list == null) {
                list = new ArrayList<>();
            }
            list.add(new MyNode(root, x, y));
            dfs.put(x, list);
        }
    }
    
}