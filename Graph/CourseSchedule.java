/*
    here are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

    Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 

    Example 1:

    Input: numCourses = 2, prerequisites = [[1,0]]
    Output: true
    Explanation: There are a total of 2 courses to take. 
                To take course 1 you should have finished course 0. So it is possible.
    Example 2:

    Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
    Output: false
    Explanation: There are a total of 2 courses to take. 
                To take course 1 you should have finished course 0, and to take course 0 you should
                also have finished course 1. So it is impossible.
    

    Constraints:

    The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
    You may assume that there are no duplicate edges in the input prerequisites.
    1 <= numCourses <= 10^5


*/

/*

    Time Complexity : O(V+E) V = no of  courses, E = no of edges (list of courses associted with course)

    Space Complexity : O(V+E) V = no of  courses, E = no of edges (list of courses associted with course)

    is worked on leetcode :YES

*/


import java.util.Queue;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.ArrayList;


public class CourseSchedule {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 0 = prereq
        //         [1,0] [2,0]
        //         [3,1]
        //         [4,2]
        //         [5,3],[5,4]
                //   0,1,2,3,4,5
        //         indegree [0,1,1,1,1,2]
        //                     hashmap 
        //                          0 -> [1,2]
        //                          1 -> [3]
        //                          2 -> [4]
        //                          3 -> [5]
                        //  4 -> [5]
                        //  5 -> []
        //           
        
            
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] indegrees = new int[numCourses];
        HashMap<Integer, ArrayList<Integer> >map = new HashMap();
        
        
        for(int i = 0 ;i < prerequisites.length; i++){
            indegrees[prerequisites[i][0]] += 1;
            if(!map.containsKey(prerequisites[i][1])){
                map.put(prerequisites[i][1],new ArrayList<>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
    //  put all the zero prerequesite couse to queue
        for(int i=0;i<indegrees.length;i++){
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int course = queue.poll();
            ArrayList<Integer> depedency = map.get(course);
            if(depedency != null){
                // now we have take the course from queue, we will decrese indegree with the course associated with this
                // and if the course indegree becomes zero we wil add to the queue
                for( int i : depedency){
                    indegrees[i]--;
                    if(indegrees[i] == 0){
                        queue.add(i);
                    }
                }     
            }
        }
        
    //         now check if all indegress  are zero or not if not return false

        for(int i : indegrees){
            System.out.println("i "+i);
            if(i > 0) return false;
        }
    
    
        return true;
                    
    }

}