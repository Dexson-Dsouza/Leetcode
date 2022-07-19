/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,List<Integer>> employeeSubordinateMap=new HashMap<>();
        Map<Integer,Integer> employeeImportanceMap=new HashMap<>();
        
        for(Employee cur:employees){
            int employeeId=cur.id;
            int importance=cur.importance;
            List<Integer> subordinates = cur.subordinates;
            employeeSubordinateMap.put(employeeId,subordinates);
            employeeImportanceMap.put(employeeId,importance);
        }
        
        int totalImportance=0;
        
        Queue<Integer> curEmployees=new LinkedList<>();
        curEmployees.add(id);
        while(curEmployees.size()>0){
            int curQueueSize=curEmployees.size();
            while(curQueueSize>0){
                curQueueSize--;
                int curEmployeeId=curEmployees.poll();
                totalImportance+=employeeImportanceMap.get(curEmployeeId);
                for(int subordinateId:employeeSubordinateMap.get(curEmployeeId)){
                    curEmployees.add(subordinateId);
                }
            }
        }
        
        return totalImportance;
    }
}