/*

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 

Constraints:

1 <= numCourses <= 105
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

*/


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int [numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i< prerequisites.length; i++) {
            // (ai,  bi) : bi ->ai
            if(!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList());
            }
            List<Integer> curr = map.get(prerequisites[i][1]);
            curr.add(prerequisites[i][0]);
            map.put(prerequisites[i][1], curr);
            
            indegree[prerequisites[i][0]] += 1;
            
        }
        
        System.out.println("map"+map);
        
        
        Queue<Integer> courseQueue = new LinkedList();
        
//          add all course having zero prequesite
        for(int i = 0;  i < indegree.length;i++) {
            System.out.println(" i "+ i + " indegree : "+indegree[i]);
            if(indegree[i] == 0) {
                courseQueue.add(i);
            }
        }
        
        while(!courseQueue.isEmpty()) {
            Integer coursetaken = courseQueue.poll();
            System.out.println("courseTal"+coursetaken);
            List<Integer> li = map.get(coursetaken);
            if(li != null) {
                for(int j = 0; j< li.size(); j++) {
                    indegree[li.get(j)] -= 1;
                    if(indegree[li.get(j)] == 0) {
                        courseQueue.add(li.get(j));
                    }
                }
                
            }
            
        }
        
        for(int i = 0;  i < indegree.length;i++) {
            if(indegree[i] > 0) {
                return false;
            }
        }
        
        
        
        return true;
    }
}
