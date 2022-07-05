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
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        
        while(head != null && head.next != null) {
            if(temp == null) {
                temp = head;
                head = head.next;
                temp.next = null;
            } else {
                ListNode t = head.next;
                head.next = temp;
                temp = head;
                head = t;
            }
        }
        
        if(head != null) {
            head.next = temp;
        }
        
        return head;
    }
}