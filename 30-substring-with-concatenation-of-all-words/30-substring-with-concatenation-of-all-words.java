class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Arrays.sort(words);
        StringBuilder resultStr=new StringBuilder();
        for(String w:words){
            resultStr.append(w);
        }
        int wordLen=words[0].length();
        List<Integer> indexes=new ArrayList<>();
        int len=resultStr.length();
        for(int i=len;i<=s.length();i++){
            // System.out.println(s.substring(i-len,i));
            int start=i-len;
            if(valid(s.substring(start,i),wordLen,resultStr)){
                indexes.add(start);
            }
        }
        return indexes;
    }
    
    boolean valid(String s, int len, StringBuilder resultStr){
        int i=0;
        List<String> words=new ArrayList<>();
        StringBuilder word=new StringBuilder();
        while(i<s.length()){
            word.append(s.charAt(i));
            if(word.length()==len){
                words.add(word.toString());
                word=new StringBuilder();
            }
            i++;
        }
        Collections.sort(words);
        StringBuilder inputStr=new StringBuilder();
        for(String w:words){
            inputStr.append(w);
        }
        return inputStr.toString().equals(resultStr.toString());
    }
}