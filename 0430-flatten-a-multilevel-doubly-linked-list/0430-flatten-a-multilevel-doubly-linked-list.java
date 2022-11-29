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
    Node cur;
    public Node flatten(Node head) {
        Node newHead=new Node();
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
        head.next=null;
        head.child=null;
        cur.next=new Node(head.val);
        cur.next.prev=cur;
        cur=cur.next;
        
        // System.out.print(cur.val+" ");
        flattenList(child);
        flattenList(next);
    }
}