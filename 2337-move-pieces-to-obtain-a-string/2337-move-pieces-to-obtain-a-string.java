class Solution {
    public boolean canChange(String start, String target) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<target.length();i++){
            char ch=target.charAt(i);
            if(ch!='_'){
                q.add(i);
            }
        }
        
        for(int i=0;i<start.length();i++){
            char ch=start.charAt(i);
            if(ch!='_'){
                if(q.size()==0 || target.charAt(q.peek())!=ch){
                    return false;
                }
                
                if(ch=='L' && q.peek()>i){
                    return false;
                }
                if(ch=='R' && q.peek()<i){
                    return false;
                }
                q.poll();
            }
        }
        return q.size()==0;
    }
}