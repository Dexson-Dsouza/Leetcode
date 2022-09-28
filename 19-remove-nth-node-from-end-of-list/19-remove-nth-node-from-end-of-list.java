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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front=head;
        
        while(n>1){
            front=front.next;
            n--;
        }
        
        ListNode cur=head;
        ListNode prev=null;
        while(front.next!=null){
            prev=cur;
            cur=cur.next;
            front=front.next;
        }
        if(prev==null){
            head=head.next;
        }else{
            prev.next=cur.next;
        }
        return head; 
    }
}