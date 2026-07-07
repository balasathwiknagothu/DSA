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
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev=null;
        ListNode temp=null;
        ListNode curr=head;
        int count=0;
        while(curr!= null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            count++;
        }
        head=prev;
        int[] arr=new int[count];
        Stack<Integer> s=new Stack<>();
        
        int i=count-1;
        while(prev!=null){
            while(!s.isEmpty() && prev.val>=s.peek()){
                s.pop();
            }
            if(s.isEmpty()){
                arr[i]=0;
            }else{
                arr[i]=s.peek();
            }
            i--;
            s.push(prev.val);
            prev=prev.next;
        }
        return arr;
    }
}