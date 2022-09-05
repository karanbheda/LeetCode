/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(root == null) {return list;}
        
        queue.add(root);
        int children = 1;
        while(!queue.isEmpty()) {
            Queue<Node> cq = new LinkedList<>();
            int count = 0;
            List<Integer> level = new ArrayList<>();
            
            while(children-- > 0) {
                Node node = queue.poll();
                level.add(node.val);
                for(Node c: node.children) {
                    cq.add(c);
                    count++;
                }
            }
            
            
            children = count;
            queue = cq;
            list.add(level);
        }
        
        return list;
    }
}