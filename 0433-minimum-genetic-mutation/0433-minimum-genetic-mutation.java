class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if(start.equals(end)){
            return 0;
        }
        Set<String> geneSet=new HashSet<>();
        
        for(String gene:bank){
            geneSet.add(gene);
        }
        geneSet.remove(start);
        Queue<String> currentGenes=new LinkedList<>();
        currentGenes.add(start);
        int mutationCount=0;
        while(currentGenes.size()>0){
            mutationCount++;
            int currentLevelSize=currentGenes.size();
            while(currentLevelSize>0){
                currentLevelSize--;
                String currentGene=currentGenes.poll();
                char[] geneArr=currentGene.toCharArray();
                for(int index=0;index<currentGene.length();index++){
                    char temp=geneArr[index];
                    for(int charIndex=0;charIndex<26;charIndex++){
                        char ch= (char)('A'+charIndex);
                        geneArr[index]=ch;
                        String mutatedString=new String(geneArr);
                        // System.out.println(mutatedString);
                        if(geneSet.contains(mutatedString)==false){
                            continue;
                        }
                        if(mutatedString.equals(end)){
                            return mutationCount;
                        }
                        if(geneSet.contains(mutatedString)){
                            geneSet.remove(mutatedString);
                            currentGenes.add(mutatedString);
                        }
                    }
                    geneArr[index]=temp;
                }
            }
        }
        return -1;
    }
}