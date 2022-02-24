/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null) {return head;}

        return sort(head);
    }
    
    private ListNode sort(ListNode head) {
        if(head.next == null) {return head;}
        
        ListNode temp = head;
        ListNode mid = null;
        while(temp != null && temp.next != null) {
            temp = temp.next.next;
            mid = mid==null?head: mid.next;
        }
        
        ListNode next = mid.next;
        mid.next = null;
        ListNode head1 = sort(head);
        ListNode head2 = sort(next);
        return merge(head1, head2);
    }
    
    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while(node1 != null && node2 != null) {
            if(node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
                
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            
            temp = temp.next;
        }
        temp.next = (node1 == null? node2: node1);
        head = head.next;
        return head;
    }
}