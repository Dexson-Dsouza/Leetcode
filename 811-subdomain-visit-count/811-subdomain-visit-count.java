class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> visitCountMap=new HashMap<>();
        
        for(String cpdomain:cpdomains){
            String[] cpdomainArr= cpdomain.split(" ");
            int count = Integer.parseInt(cpdomainArr[0]);
            StringBuilder domain = new StringBuilder(cpdomainArr[1]);
            
            while(true){
                String domainStr=domain.toString();
                visitCountMap.put(domainStr,visitCountMap.getOrDefault(domainStr,0)+count);
                if(domain.indexOf(".")==-1){
                    break;
                }
                int dotIndex = domain.indexOf(".");
                domain = new StringBuilder(domain.substring(dotIndex+1));
            }
        }
        List<String> countPairedList=new ArrayList<>();
        for(String domain:visitCountMap.keySet()){
            countPairedList.add(String.valueOf(visitCountMap.get(domain))+" "+domain);
        }
        return countPairedList;
    }
}