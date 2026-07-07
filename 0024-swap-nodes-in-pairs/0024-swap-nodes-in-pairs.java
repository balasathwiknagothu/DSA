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
        ListNode temp = head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode prev = dum;
        while(temp!=null && temp.next!=null){
            ListNode next = temp.next;
            prev.next = next;
            temp.next = next.next;
            next.next = temp;
            prev = temp;
            
            temp = temp.next;
        }
        return dum.next;

    }
}