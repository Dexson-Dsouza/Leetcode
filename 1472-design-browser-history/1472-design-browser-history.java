class BrowserHistory {
    
    public static class Node{
        String link;
        Node next;
        Node prev;
        Node(){
            prev=null;
            next=null;
            link="";
        }
    }    
    
    Node head;
    public BrowserHistory(String homepage) {
        head=new Node();
        head.link=homepage;
    }
    
    public void visit(String url) {
        Node visitedNode=new Node();
        visitedNode.link=url;
        visitedNode.prev=head;
        head.next=visitedNode;
        head=visitedNode;
    }
    
    public String back(int steps) {
        while(steps>0 && head.prev!=null){
            head=head.prev;
            steps--;
        }
        return head.link;
    }
    
    public String forward(int steps) {
        while(steps>0 && head.next!=null){
            head=head.next;
            steps--;
        }
        return head.link;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */