class Solution {
    public String alienOrder(String[] words) {
        StringBuilder order=new StringBuilder();
        Map<Character,Set<Character>> adj=new HashMap<>();
        
        Map<Character,Integer> indeg=new HashMap<>();
        
        for(String word:words){
            for(char c:word.toCharArray()){
                indeg.put(c,0);
            }
        }
        
        int totalWords=words.length;
        for(int word=0;word<totalWords-1;word++){
            String currentWord=words[word];
            String nextWord=words[word+1];
            if (currentWord.length() > nextWord.length() && currentWord.startsWith(nextWord)) {
                return "";
            }
            int minLen=Math.min(currentWord.length(),nextWord.length());
            for(int index=0;index<minLen;index++){
                char charInCurrentWord=currentWord.charAt(index);
                char charInNextWord=nextWord.charAt(index);
                if(charInCurrentWord!=charInNextWord){
                    Set<Character> nextCharactors=new HashSet<>();
                    if(adj.containsKey(charInCurrentWord)){
                        nextCharactors=adj.get(charInCurrentWord);
                    }
                    if(nextCharactors.contains(charInNextWord)==false){
                        nextCharactors.add(charInNextWord);
                        indeg.put(charInNextWord,indeg.getOrDefault(charInNextWord,0)+1);
                        adj.put(charInCurrentWord,nextCharactors);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> currentNodes=new LinkedList<>();
        
        for(char c='a';c<='z';c++){
            if(indeg.containsKey(c) && indeg.get(c)==0){
                currentNodes.add(c);                
            }
        }
        
        while(currentNodes.size()>0){
            int curSize=currentNodes.size();
            while(curSize>0){
                
                curSize--;
                char curentChar=currentNodes.poll();
                order.append(curentChar);
                // System.out.println(order+" "+indeg.size());
                if(adj.containsKey(curentChar)==false){
                    continue;
                }
                for(char neighbour:adj.get(curentChar)){
                    indeg.put(neighbour,indeg.get(neighbour)-1);
                    if(indeg.get(neighbour)==0){
                        currentNodes.add(neighbour);
                    }
                }
            }
        }
        return order.length()==indeg.size()?order.toString():"";
    }
}