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
    public ListNode swapPairs(ListNode head) {
        ListNode prevHead = null;
        ListNode start = null;
        ListNode t = null;
        while(head != null) {
            if(head.next != null) {
                prevHead = head;
                ListNode temp = head.next;
                prevHead.next = temp.next;
                temp.next = prevHead;
                head = temp;
                if (start == null) {
                    start = head;
                    t = start;
                } else {
                    t = t.next;
                    t.next = head;
                    t = t.next;
                }
                head = (head.next).next;
            } else {
                if(start == null) {
                    start = head;
                } /*else {
                    //while(t.next != null) {t = t.next;}
                    t.next = head;
                }*/
                break;
            }
        }

        return start;
    }
}