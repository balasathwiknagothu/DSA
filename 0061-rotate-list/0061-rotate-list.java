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
    public ListNode rotateRight(ListNode head, int k) 
    {
        if(head==null || head.next==null || k==0) return head;
        int n=0;
        ListNode temp=head;
        while(temp!=null){n++;temp=temp.next;}
        if(k>n) k=k%n;
        int s=n-k;
        if(s==0 || s==n) return head;
        ListNode prev=null;
        ListNode newhead=head;
        while(s>0)
        {
            prev=newhead;
            newhead=newhead.next;
            s--;
        }
        ListNode ans=newhead;
        prev.next=null;
        while(newhead.next!=null)
        {
            newhead=newhead.next;
        }
        newhead.next=head;
        return ans;


        
    }
}