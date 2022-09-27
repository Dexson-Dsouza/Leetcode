class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, new HashSet<>( wordDict), new HashMap<String, LinkedList<String>>());
    }       

    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        List<String>res = new ArrayList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        return res;
    }
}