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
    public boolean isPalindrome(ListNode head) {
        List<Integer> firstHalf = new ArrayList<>();
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        
        while(ptr1 != null && ptr2 != null && ptr2.next != null) {
            firstHalf.add(ptr1.val);
            ptr1 = ptr1.next;
            ptr2 = (ptr2.next).next;
        }
        
        if(ptr2 != null) {
            ptr1 = ptr1.next;
        }
        
        for(int i = firstHalf.size() -1 ; i >= 0 && ptr1 != null; i--) {
            if(ptr1.val != firstHalf.get(i)) {
                return false;
            }
            ptr1 = ptr1.next;
        }
        
        return true;
    }
}