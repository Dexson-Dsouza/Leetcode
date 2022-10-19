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
    public ListNode removeElements(ListNode head, int val) {
        ListNode ptr1=head;
        ListNode nhead=new ListNode(0);
        ListNode ptr2=nhead;
        while(ptr1!=null){
            if(ptr1.val!=val){
                ptr2.next=ptr1;
                ptr1=ptr1.next;
                ptr2=ptr2.next;
                ptr2.next=null;
            }else{
                ptr1=ptr1.next;
            }
            
        }
        return nhead.next;
    }
}