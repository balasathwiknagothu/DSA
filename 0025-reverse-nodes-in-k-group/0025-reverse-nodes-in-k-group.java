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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        for(int i=0;i<k;i++){
            if(curr==null){
                return head;
            }
            curr=curr.next;
        }
        ListNode prev=null, next=null, temp=head;
        for(int i=0;i<k;i++){
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;

        }
        head.next=reverseKGroup(temp,k);
        return prev;
    }
}