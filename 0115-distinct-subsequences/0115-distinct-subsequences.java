class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] subs_count = new Integer[s.length()][t.length()];
        
        return find_distinct_subs(s,t,0,0,subs_count);
    }
    
    int find_distinct_subs(String s, String t, int i, int j, Integer[][] subs_count){
        if(j==t.length()){
            return 1;
        }
        if(i==s.length()){
            return 0;
        }
        
        if(subs_count[i][j]!=null){
            return subs_count[i][j];
        }
        
        int count = 0;
        // count if ignore i th char
        
        count += find_distinct_subs(s,t,i+1,j,subs_count);
        
        // count if i and j are same
        
        if(s.charAt(i) == t.charAt(j)){
            count += find_distinct_subs(s,t,i+1,j+1,subs_count);
        }
        subs_count[i][j]=count;
        return count;
        
    }
}