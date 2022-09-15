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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0){
            return head;
        }
        ListNode cur=head;
        int size=0;
        while(cur!=null){
            size++;
            cur=cur.next;
        }
        
        int index = k>=size? k%size:k;
        if(index==0){
            return head;
        }
        index = (size-index);
        
        // System.out.println(index);
        cur=head;
        ListNode prev=null;
        while(index>0){
            prev=cur;
            cur=cur.next;
            index--;
        }
        if(prev!=null){
            prev.next=null;
        }
        ListNode newHead=cur;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=head;
        return newHead;
    }
}