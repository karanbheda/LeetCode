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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start = head;
        
        for(int i = 2; i <= k && start != null; i++) {
            start = start.next;
        }
        
        ListNode temp = start;
        ListNode end = head;
        
        while(temp.next != null) {
            temp = temp.next;
            end = end.next;
        }
        
        int t = start.val;
        start.val = end.val;
        end.val = t;
        
        return head;
    }
}