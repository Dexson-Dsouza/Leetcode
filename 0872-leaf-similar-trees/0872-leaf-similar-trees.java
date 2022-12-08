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
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> values1=new LinkedList<>();
        Queue<Integer> values2=new LinkedList<>();
        getLeafs(root1,values1);
        getLeafs(root2,values2);
        while(values1.size()>0 && values2.size()>0 && values1.peek() == values2.peek()){
            values1.poll();
            values2.poll();
        }
        return values1.size()==0 && values2.size()==0;
    }
    
    public void getLeafs(TreeNode root, Queue<Integer> values){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            values.add(root.val);
            return;
        }
        getLeafs(root.left,values);
        getLeafs(root.right,values);
    }
    
    
}