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
        Stack<ListNode> listOneStack=new Stack();
        Stack<ListNode> listTwoStack=new Stack();
        Stack<ListNode> sumStack=new Stack();
        
        while(l1!=null){
            listOneStack.push(l1);
            l1=l1.next;
        }
        while(l2!=null){
            listTwoStack.push(l2);
            l2=l2.next;
        }
        
        int carry=0;
        while(listOneStack.size()>0 && listTwoStack.size()>0){
            int sum = listOneStack.pop().val + listTwoStack.pop().val + carry;
            ListNode n = new ListNode(sum%10);
            carry = sum/10;
            sumStack.push(n);
        }
        while(listOneStack.size()>0){
            int sum = listOneStack.pop().val + carry;
            ListNode n = new ListNode(sum%10);
            carry = sum/10;
            sumStack.push(n);
        }
        while(listTwoStack.size()>0){
            int sum = listTwoStack.pop().val + carry;
            ListNode n = new ListNode(sum%10);
            carry = sum/10;
            sumStack.push(n);
        }
        if(carry>0){
            ListNode n = new ListNode(carry);
            sumStack.push(n);
        }
        ListNode sumListHead=new ListNode(0);
        ListNode sumListptr=sumListHead;
        while(sumStack.size()>0){
            ListNode sumNode=sumStack.pop();
            sumListptr.next=sumNode;
            sumListptr=sumNode;
        }
        return sumListHead.next;
    }
}