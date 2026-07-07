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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1=new Stack<>();
        Stack<Integer> s2=new Stack<>();
        ListNode ptr=l1;
        while(ptr!=null){
            s1.push(ptr.val);
            ptr=ptr.next;
        }
        ptr=l2;
        while(ptr!=null){
            s2.push(ptr.val);
            ptr=ptr.next;
        }
        Stack<Integer> nums=new Stack<>();
        int carry=0;
        while(!s1.isEmpty() && !s2.isEmpty()){
            int digit=s1.pop()+s2.pop()+carry;
            carry=digit/10;
            nums.push(digit%10);
        }
        while(!s1.isEmpty()){
            int digit=s1.pop()+carry;
            carry=digit/10;
            nums.push(digit%10);
        }
        while(!s2.isEmpty()){
            int digit=s2.pop()+carry;
            carry=digit/10;
            nums.push(digit%10);
        }
        if(carry!=0) nums.push(carry);
        ListNode curr=new ListNode(-1);
        ListNode temp=curr;
        while(!nums.isEmpty()){
            temp.next=new ListNode(nums.pop());
            temp=temp.next;
        }
        return curr.next;
    }
}