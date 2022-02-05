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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode start = null;
        ListNode head = null;
        
        if(lists.length == 0) {
            return start;
        }
        
        int min = Integer.MAX_VALUE;
        int index = 0;
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < lists.length; i++) {
                if(lists[i] != null && lists[i].val < min) {
                    index = i;
                    min = lists[i].val;
                    flag = true;
                }
            }

            if(start == null) {
                start = lists[index];
                head = lists[index];
            } else {
                head.next = lists[index];
                head = head.next;
            }

            if(lists[index] != null) {
                lists[index] = lists[index].next;
            }
            min = Integer.MAX_VALUE;
        }


        return start;
    }
}