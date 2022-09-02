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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Integer> countList=new ArrayList<>();
        List<Double> sumList=new ArrayList<>();
        getNodeLevelSum(root,countList,sumList,0);
        List<Double> averageList= new ArrayList<>();
        for(int i=0;i<countList.size();i++){
            double average=sumList.get(i);
            averageList.add(average/countList.get(i));
        }
        return averageList;
    }
    
    void getNodeLevelSum(TreeNode root, List<Integer> countList, List<Double> sumList, int level){
        if(root==null){
            return;
        }
        
        if(level==sumList.size()){
            sumList.add(0D);
            countList.add(0);
        }
        
        countList.set(level,countList.get(level)+1);
        sumList.set(level,sumList.get(level)+root.val);
        getNodeLevelSum(root.left,countList,sumList,level+1);
        getNodeLevelSum(root.right,countList,sumList,level+1);
    }
}