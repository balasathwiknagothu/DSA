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
    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list=new ArrayList<>();
        int size=0;
        ListNode temp=head;
        while(temp!=null){
            size++;
            list.add(temp.val);
            temp=temp.next;
        }
        int t1=list.get(k-1);
        int t2=list.get(size-k);
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            if(i==k-1){
                arr[i]=t2;
            }else if(i==size-k){
                arr[i]=t1;
            }else{
                arr[i]=list.get(i);
            }
        }
        ListNode res=new ListNode(0);
        ListNode cur=res;
        int i=0;
        while(i<size){
            cur.next=new ListNode(arr[i]);
            cur=cur.next;
            i++;
        }

        return res.next;
    }
}