class Solution {
    
    private static class Node{
        String name;
        String website;
        int timeStamp;
        Node(String name, String website, int timeStamp){
            this.name=name;
            this.website=website;
            this.timeStamp=timeStamp;
        }
    
    }
    
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {        
        List<Node> inputTuples=new ArrayList<>();
        for(int i=0;i<username.length;i++){
            inputTuples.add(new Node(username[i],website[i],timestamp[i]));
        }
        Collections.sort(inputTuples,(a,b)->a.timeStamp-b.timeStamp);
        
        Map<String,List<String>> userWebsiteMap=new HashMap<>();
        
        for(Node userNode:inputTuples){
            String name = userNode.name;
            String websiteName = userNode.website;
            if(userWebsiteMap.containsKey(name)==false){
                userWebsiteMap.put(name,new ArrayList<>());
            }
            userWebsiteMap.get(name).add(websiteName);
        }
        int maxCount=0;
        String maxPattern="";
        
        Map<String,Integer> patternCount=new HashMap<>();
        for(String name:userWebsiteMap.keySet()){
            List<String> websites=userWebsiteMap.get(name);
            int listSize=websites.size();
            Set<String> patterns=new HashSet<>();
            for(int i=0;i<listSize;i++){
                for(int j=i+1;j<listSize;j++){
                    for(int k=j+1;k<listSize;k++){
                        String key= websites.get(i)+"_"+websites.get(j)+"_"+websites.get(k);
                        patterns.add(key);
                    }
                }
            }
            
            for(String pattern:patterns){
                patternCount.put(pattern,patternCount.getOrDefault(pattern,0)+1);
                int count = patternCount.get(pattern);
                // System.out.println(key+" "+ count);
                if(count>maxCount){
                    maxCount=count;
                    maxPattern=pattern;
                }else if(count==maxCount && pattern.compareTo(maxPattern)<0){
                    maxPattern=pattern;
                }
            }
        }
        
        String[] patternWebsites=maxPattern.split("_");
        List<String> mostVisitedPatternList=new ArrayList<>();
        for(String websiteName:patternWebsites){
            mostVisitedPatternList.add(websiteName);
        }
        return mostVisitedPatternList;
    }
}