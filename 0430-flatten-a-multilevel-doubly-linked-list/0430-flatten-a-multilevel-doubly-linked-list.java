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
    public Node flatten(Node head) {
        Node newHead = new Node();
        Node cur = newHead;
        Stack<Node> st=new Stack<>();
        st.push(head);
        while(st.size()!=0){
            Node n = st.pop();
            if(n==null){
                continue;
            }
            st.push(n.next);
            st.push(n.child);
            cur.next=n;
            n.prev=cur;
            n.next=null;
            n.child=null;
            cur=n;
        }
        if(newHead.next!=null){
            newHead.next.prev=null;
        }
        return newHead.next;
    }
    
}