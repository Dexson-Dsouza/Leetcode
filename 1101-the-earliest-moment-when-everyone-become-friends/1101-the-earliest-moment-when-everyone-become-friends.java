class friendGroups{
    int[] group;
    int groupCount;
    
    friendGroups(int n){
        group=new int[n];
        for(int index=0;index<n;index++){
            group[index]=index;
        }
        groupCount=n;    
    }
    
    int findGroup(int person){
        if(group[person]==person){
            return person;
        }
        return group[person]=findGroup(group[person]);
    }
    
    void combine(int p1, int p2){
        int group1=findGroup(p1);
        int group2=findGroup(p2);
        if(group1!=group2){
            group[group1]=group2;
            groupCount--;
        }
    }
    
    int getGroupCount(){
        return groupCount;
    }
    
}
class Solution {
    
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a,b)-> a[0]-b[0]);
        
        friendGroups currentGroups=new friendGroups(n);
        
        for(int[] log:logs){
            int time=log[0];
            int p1=log[1];
            int p2=log[2];
            currentGroups.combine(p1,p2);
            if(currentGroups.getGroupCount()==1){
                return time;
            }
        }
        return -1;
    }
}