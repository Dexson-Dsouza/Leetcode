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
        List<Integer> values1=new LinkedList<>();
        List<Integer> values2=new LinkedList<>();
        getLeafs(root1,values1);
        getLeafs(root2,values2);
        if(values1.size()!=values2.size()){
            return false;
        }
        
        for(int i=0;i<values1.size();i++){
            if(values1.get(i)!=values2.get(i)){
                return false;
            }
        }
        return true;
    }
    
    public void getLeafs(TreeNode root, List<Integer> values){
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