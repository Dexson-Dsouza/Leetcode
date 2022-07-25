class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> prevPoints=new Stack<>();
        int curPoints=0;
        
        for(char ch:s.toCharArray()){
            if(ch=='('){
                prevPoints.push(curPoints);
                curPoints=0;
            }else{
                curPoints = Math.max(curPoints*2,1);
                if(prevPoints.size()>0){
                    curPoints+=prevPoints.pop();
                }
                
            }
        }
        if(prevPoints.size()>0){
            curPoints+=prevPoints.pop();
        }
        return curPoints;
    }
}