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
    public ListNode partition(ListNode head, int x) {
        ListNode temp=head;
        ListNode left=new ListNode(0);
        ListNode right=new ListNode(0);
        ListNode greater=right, lower=left;
        while(temp!=null){
            if(temp.val<x){
                lower.next=temp;
                lower=lower.next;
            }else{
                greater.next=temp;
                greater=greater.next;
            }
            temp=temp.next;
        }
        lower.next=right.next;
        greater.next=null;
        return left.next;
    }
}