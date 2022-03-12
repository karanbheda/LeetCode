/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        
        Node temp = head;
        
        while(temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = (temp.next).next;
        }
        
        temp = head;
        Node copy = temp.next;
        while(temp != null && copy != null && copy.next != null && temp.next != null) {
            if(temp.random != null){
                copy.random = (temp.random).next;   
            }
            copy = (copy.next).next;
            temp = (temp.next).next;
        }
        
        if(temp != null && temp.random != null && copy != null){
            copy.random = (temp.random).next;   
        }
        
        temp = head;
        copy = head.next;
        Node copyStart = copy;
        while(temp != null && copy!= null && temp.next!= null && copy.next!= null){
            temp.next = copy.next;
            temp = temp.next;
            copy.next = temp.next;
            copy = copy.next;
        }
        temp.next = null;
        copy.next = null;
        
        return copyStart;
    }
}