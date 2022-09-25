class MyCircularQueue {
    class Node {
        int val;
        Node next;
    }
    
    
    int n, size;
    Node head;
    Node tail;
    
    public MyCircularQueue(int k) {
        n = 0;
        size = k;
        head = null;
        tail = null;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) {return false;}
        n++;
        Node node = new Node();
        node.val = value;
        if(head == null) {head = node;}
        
        if(tail != null) {
            tail.next = node;
        }
        
        tail = node;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {return false;}
        head = head.next;
        n--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) {
            return -1;
        }
        
        return head.val;
    }
    
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        
        return tail.val;
    }
    
    public boolean isEmpty() {
        return n == 0;
    }
    
    public boolean isFull() {
        return n == size;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */ 