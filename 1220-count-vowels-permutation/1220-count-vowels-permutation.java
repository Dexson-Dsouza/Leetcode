class Solution {
    public int countVowelPermutation(int n) {
        int mod=(int)(Math.pow(10,9)+7);
        Map<Character,Long> count=new HashMap<>();
        char[] vowels=new char[]{'a','e','i','o','u'};
        for(char ch:vowels){
            count.put(ch,1L);
        }
        
        for(int len=2;len<=n;len++){
            Map<Character,Long> nextPerm=new HashMap<>();
            long countA=count.get('e')+count.get('u')+count.get('i');
            nextPerm.put('a',countA%mod);
            long countE=count.get('i')+count.get('a');
            nextPerm.put('e',countE%mod);
            long countO=count.get('i');
            nextPerm.put('o',countO%mod);
            long countU=count.get('i')+count.get('o');
            nextPerm.put('u',countU%mod);
            
            long countI = count.get('e')+count.get('o');
            nextPerm.put('i',countI%mod);
            count=nextPerm;
        }
        
        long sum=0;
        for(char ch:count.keySet()){
            sum = (sum + count.get(ch))%mod;
        }
        return (int)(sum);
    }
}