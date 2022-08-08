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

class nodeIndexPair{
    TreeNode n;
    int index;
    nodeIndexPair(TreeNode n, int index){
        this.n=n;
        this.index=index;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<Integer>[] columnsNodes=new ArrayList[201];
        List<List<Integer>> verticalOrderList=new ArrayList<>();
        Queue<nodeIndexPair> curNodes=new LinkedList<>();
        if(root!=null){
            curNodes.add(new nodeIndexPair(root,100));
        }
        while(curNodes.size()>0){
            int curSize=curNodes.size();
            while(curSize>0){
                curSize--;
                TreeNode node=curNodes.peek().n;
                int index=curNodes.peek().index;
                curNodes.poll();
                if(columnsNodes[index]==null){
                    columnsNodes[index]=new ArrayList<>();
                }
                columnsNodes[index].add(node.val);
                if(node.left!=null){
                    curNodes.add(new nodeIndexPair(node.left,index-1));
                }
                if(node.right!=null){
                    curNodes.add(new nodeIndexPair(node.right,index+1));
                }
            }
        }
        
        for(int i=0;i<=200;i++){
            if(columnsNodes[i]!=null){
                verticalOrderList.add(columnsNodes[i]);
            }
        }
        return verticalOrderList;
    }
    
}