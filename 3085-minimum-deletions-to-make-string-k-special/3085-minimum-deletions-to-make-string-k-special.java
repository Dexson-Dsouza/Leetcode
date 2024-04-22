class Solution {
    public int minimumDeletions(String word, int k) {
        int[] cnt=new int[26];
        
        for(char ch:word.toCharArray()){
            cnt[ch-'a']++;
        }
        
        List<Integer> countList=new ArrayList<>();
        for(int i=0;i<26;i++){
            if(cnt[i]>0){
                countList.add(cnt[i]);
            }
        }
        
        Collections.sort(countList);
        
        return findMinDel(countList,0,countList.size()-1,k);
    }
    
    int findMinDel(List<Integer> countList, int i, int j, int k){
        if(i==j){
            return 0;
        }
        
        int lc=countList.get(i);
        int rc=countList.get(j);
        if(rc-lc<=k){
            return 0;
        }
        
        return Math.min(lc + findMinDel(countList,i+1,j,k) , rc-(lc+k) + findMinDel(countList,i,j-1,k));
    }
}