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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode cur=head;
        while(cur.next != null){
            ListNode temp=cur.next;
            int value=remainder(cur.val,temp.val);
            ListNode newNode=new ListNode(value);
            cur.next=newNode;
            newNode.next=temp;
            cur=temp;
        }
        return head;
    }
    int remainder(int val1 ,int val2){
        while(val2!=0){
            int rem=val1 % val2;
            val1=val2;
            val2=rem;
        }
        return val1;
    }
}