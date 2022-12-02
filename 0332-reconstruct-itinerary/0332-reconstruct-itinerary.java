class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> adj=new HashMap<>();
        int totalTickets = tickets.size();
        for(List<String> ticket:tickets){
            String from=ticket.get(0);
            String to=ticket.get(1);
            if(adj.containsKey(from)==false){
                adj.put(from,new ArrayList<>());
            }
            if(adj.containsKey(to)==false){
                adj.put(to,new ArrayList<>());
            }
            adj.get(from).add(to);
        }
        for(String node : new ArrayList<>(adj.keySet())){
            List<String> edges = adj.get(node);
            Collections.sort(edges);
            adj.put(node,edges);
        }
        
        String start = "JFK";
        List<String> resultItinerary = new ArrayList<>();
        List<String> currentItinerary = new ArrayList<>();
        currentItinerary.add(start);
        searchIternary(start,adj,currentItinerary,resultItinerary,totalTickets);
        return resultItinerary;
    }
    
    public void searchIternary(String currentLocation, Map<String,List<String>> adj, 
                               List<String> currentItinerary, List<String> resultItinerary, int totalTickets){
        
        if(totalTickets==0){
            for(String t:currentItinerary){
                resultItinerary.add(t);
            }
            return;
        }
        // System.out.println(adj.get(currentLocation));
        for(String neighbour:new ArrayList<>(adj.get(currentLocation))){
            if(resultItinerary.size()!=0){
                break;
            }
            currentItinerary.add(neighbour);
            adj.get(currentLocation).remove(neighbour);
            searchIternary(neighbour,adj,currentItinerary,resultItinerary,totalTickets-1);
            adj.get(currentLocation).add(neighbour);
            currentItinerary.remove(currentItinerary.size()-1);
        }
        // System.out.println(resultItinerary);
    }
    
    public String convertItrToString(List<String> arr){
        StringBuilder sb=new StringBuilder();
        for(String s:arr){
            sb.append(s);
        }
        return sb.toString();
    }
}