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
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] countOfPalindromicPath=new int[1];
        findPaths(root,new int[10],countOfPalindromicPath);
        return countOfPalindromicPath[0];
    }
    
    void findPaths(TreeNode root, int[] values, int[] countOfPalindromicPath){
        if(root==null){
            return;
        }
        values[root.val-1]++;
        if(root.left==null && root.right==null){
            int countOfOdds=0;
            for(int i=0;i<10;i++){
                if(values[i]%2==1){
                    countOfOdds++;
                }
            }
            if(countOfOdds<=1){
                countOfPalindromicPath[0]++;
            }
        }else{
            findPaths(root.left,values,countOfPalindromicPath);
            findPaths(root.right,values,countOfPalindromicPath);
        }
        values[root.val-1]--;
    }
}