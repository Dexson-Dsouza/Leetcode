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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> matchingPaths=new ArrayList<>();
        List<Integer> curPath=new ArrayList<>();
        findAllPaths(root,targetSum,curPath,matchingPaths);
        return matchingPaths;
    }
    
    public void findAllPaths(TreeNode root, int targetSum, List<Integer> curPath, List<List<Integer>> matchingPaths){
        if(root==null){
            return;
        }
        targetSum-=root.val;
        curPath.add(root.val);
        if(root.left==null && root.right==null && targetSum==0){
            matchingPaths.add(new ArrayList<>(curPath));
        }
        findAllPaths(root.left,targetSum,curPath,matchingPaths);
        findAllPaths(root.right,targetSum,curPath,matchingPaths);
        curPath.remove(curPath.size()-1);
    }
}