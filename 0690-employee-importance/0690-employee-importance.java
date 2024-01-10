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
        
        totalImportance = dfs(id,employeeImportanceMap,employeeSubordinateMap);
        
        return totalImportance;
    }
    
    int dfs(int id, Map<Integer,Integer> employeeImportanceMap,
           Map<Integer,List<Integer>> employeeSubordinateMap){
        int imp_sum = employeeImportanceMap.get(id);
        
        for(int sub:employeeSubordinateMap.get(id)){
            imp_sum += dfs(sub,employeeImportanceMap,employeeSubordinateMap);
        }
        
        return imp_sum;
    }
}