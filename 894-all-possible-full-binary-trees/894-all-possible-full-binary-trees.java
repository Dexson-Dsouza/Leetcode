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
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> result=new ArrayList<>();
        if(n%2==0){
            return result;
        }
        
        if(n==1){
            result.add(new TreeNode(0));
            return result;
        }
        for(int i=1;i<n;i+=2){
            List<TreeNode> arr1=allPossibleFBT(i);
            List<TreeNode> arr2=allPossibleFBT(n-i-1);
            
            for(TreeNode child1:arr1){
                for(TreeNode child2:arr2){
                    TreeNode node1=new TreeNode(0);
                    node1.left=child1;
                    node1.right=child2;
                    result.add(node1);
                    
                }   
            }
        }
        return result;
    }
}