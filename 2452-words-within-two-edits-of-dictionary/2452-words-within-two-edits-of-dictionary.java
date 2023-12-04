class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res=new ArrayList<>();
        
        for(String q:queries){
            char[] sourceArr = q.toCharArray();
            boolean canMake=false;
            for(String w:dictionary){            
                char[] wordArr = w.toCharArray();
                int difference=0;
                for(int i=0;i<w.length();i++){
                    if(sourceArr[i]!=wordArr[i]){
                        difference++;
                    }
                }
                
                if(difference<=2){
                    canMake = true;
                    break;
                }
            }
            if(canMake){
                res.add(q);
            }
        }
        return res;
    }
}