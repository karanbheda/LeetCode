/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        Node[] allNodes = new Node[101];
        boolean[] visited = new boolean[101];
        allNodes[node.val] = new Node(node.val);
        
        Queue<Node[]> queue = new LinkedList<>();
        for(Node next: node.neighbors) {
            queue.add(new Node[]{next, allNodes[node.val]});
        }
        
        visited[node.val] = true;
        
        while(!queue.isEmpty()) {
            Node[] pair = queue.poll();
            Node parent = pair[1];
            Node child = pair[0];

            if(allNodes[child.val] == null)
                allNodes[child.val] = new Node(child.val);
            
            //System.out.println(child.val + " " + parent.val);
            Node copy = allNodes[child.val];
            parent.neighbors.add(copy);
            copy.neighbors.add(parent);
            
            visited[child.val] = true;
            
            for(Node next: child.neighbors) {
                if(!visited[next.val]) {
                    queue.add(new Node[]{next, copy});
                }
            }
        }
        
        return allNodes[node.val];
    }
}