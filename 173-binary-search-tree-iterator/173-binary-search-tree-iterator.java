/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    Stack<TreeNode> st;
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        insert(root);    
    }
    
    public void insert(TreeNode root){
        if(root==null){
            return;
        }
        
        while(root.left!=null){
            TreeNode temp=root.left;
            root.left=null;
            st.push(root);
            root=temp;
        }
        st.push(root);
    }
    
    public int next() {
        if(st.size()==0){
            return -1;
        }
        int val=st.peek().val;
        insert(st.pop().right);
        return val;
    }
    
    public boolean hasNext() {
        return st.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */