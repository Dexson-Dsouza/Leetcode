/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> visitedUrls=new HashSet<>();
        
        Queue<String> currentUrls=new LinkedList<>();
        currentUrls.add(startUrl);
        visitedUrls.add(startUrl);
        while(currentUrls.size()>0){
            String currentUrl = currentUrls.poll();
            
            String sourceHostName = getHostName(currentUrl);
            for(String nextUrl:htmlParser.getUrls(currentUrl)){
                String neighbourHostName = getHostName(nextUrl);
                if(neighbourHostName.equals(sourceHostName) && visitedUrls.contains(nextUrl)==false){
                    visitedUrls.add(nextUrl);
                    currentUrls.add(nextUrl);
                }
            }
        }
        return new ArrayList<>(visitedUrls);
    }
    
    public String getHostName(String currentUrl){
        int startIndex = currentUrl.indexOf("//")+2;
        int endIndex = currentUrl.indexOf("/",startIndex);
        if(endIndex==-1){
            endIndex=currentUrl.length();
        }
        return currentUrl.substring(startIndex,endIndex);
    }
}