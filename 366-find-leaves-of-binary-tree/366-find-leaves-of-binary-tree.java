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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        traverse(root,res);
        return res;
    }
    
    int traverse(TreeNode root, List<List<Integer>> res){
        if(root==null){
            return -1;
        }
        
        int index=Math.max(traverse(root.left,res),traverse(root.right,res))+1;
        if(index==res.size()){
            res.add(new ArrayList<>());
        }
        res.get(index).add(root.val);
        return index;
    }
}