/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    Node newHead;
    Node cur;
    public Node flatten(Node head) {
        newHead=new Node();
        cur=newHead;
        flattenList(head);
        if(newHead.next!=null){
            newHead.next.prev=null;
        }
        return newHead.next;
    }
    
    void flattenList(Node head){
        if(head==null){
            return;
        }
        Node next=head.next;
        Node child=head.child;
        cur.next=head;
        head.prev=cur;
        cur=cur.next;
        cur.next=null;
        cur.child=null;
        // System.out.print(cur.val+" ");
        flattenList(child);
        flattenList(next);
    }
}