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
    public ListNode mergeNodes(ListNode head) {
        ListNode cur=head.next;
        ListNode temp=head;
        int sum=00;
        while(cur != null){
            sum+=cur.val;
            if(cur.val==0){
                temp.next.val=sum;
                temp=temp.next;

                sum=0;
            }
            cur=cur.next;
        }
        temp.next=null;
        return head.next;
    }
}