/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ptr1=headA;
        ListNode ptr2=headB;
        boolean isPtr1Turned=false;
        boolean isPtr2Turned=false;
        
        while(ptr1!=null && ptr2!=null){
            if(ptr1==ptr2){
                return ptr1;
            }
            ptr1=ptr1.next;
            ptr2=ptr2.next;
            if(ptr1==null && isPtr1Turned==false){
                isPtr1Turned=true;
                ptr1=headB;
            }
            if(ptr2==null && isPtr2Turned==false){
                isPtr2Turned=true;
                ptr2=headA;
            }
        }
        return null;
    }
}