class Solution {
    public int minAnagramLength(String s) {
        int[] cnt=new int[26];
        
        for(char ch:s.toCharArray()){
            cnt[ch-'a']++;
        }
        
        
        
        int[] test = new int[26];
        for(int i=0;i<s.length();i++){
            test[s.charAt(i)-'a']++;
            
            Set<Integer> divs=new HashSet<>();
            boolean posi=true;
            for(int ii=0;ii<26;ii++){
                if(cnt[ii]>0){
                    if(test[ii]>0 && cnt[ii]%test[ii]==0){
                        divs.add(cnt[ii]/test[ii]);
                    } else{
                        posi=false;
                    }
                }
            }
            
            
            // System.out.println(i + " "+divs);
            
            if(posi && divs.size()==1){
                int len= i+1;
                // System.out.println("try "+len);
                int[] subArr=new int[26];

                for(int ii=0;ii<len;ii++){
                    subArr[s.charAt(ii)-'a']++;
                }
                boolean isvalid=true;
                int j=len;
                while(j<s.length()){
                    int[] curCnt=new int[26];
                    for(int ii=j;ii<j+len;ii++){
                        curCnt[s.charAt(ii)-'a']++;
                    }
                    
                    for(int ii=0;ii<26;ii++){
                        if(curCnt[ii]!=subArr[ii]){
                            isvalid=false;
                        }
                    }
                    j+=len;
                }
                
                if(isvalid){
                    return len;
                }
            }
        }
        
        
//         int lowest=Integer.MAX_VALUE;
        
//         for(int i=0;i<26;i++){
//             if(cnt[i]>0)
//                 lowest=Math.min(lowest,cnt[i]);
//         }
//         int res=s.length();
        
//         int len = s.length()/lowest;
//         int[] subArr=new int[26];
        
//         for(int i=0;i<len;i++){
//             subArr[s.charAt(i)-'a']++;
//         }
        
//         int j=len;
//         while(j<s.length()){
//             int[] curCnt=new int[26];
//             for(int i=j;i<j+len;i++){
//                 curCnt[s.charAt(i)-'a']++;
//             }
            
//             for(int i=0;i<26;i++){
//                 if(curCnt[i]!=subArr[i]){
//                     return s.length();
//                 }
//             }
//             j+=len;
//         }
        return s.length();
    }
}