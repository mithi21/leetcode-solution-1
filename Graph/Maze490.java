/**
There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).

Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.


Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
Output: false
Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
Example 3:

Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
Output: false

Constraints:

1 <= maze.length, maze[i].length <= 100
maze[i][j] is 0 or 1.
start.length == 2
destination.length == 2
0 <= startrow, destinationrow <= maze.length
0 <= startcol, destinationcol <= maze[i].length
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The maze contains at least 2 empty spaces.


Worked on Leetcode :YES
Time complexity : O(M*N)
Space complexity : O(M+N)

**/


class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        
        dirs = [[1,0],[-1,0],[0,1],[0,-1]]
        
        stack = deque()
        
        stack.append(start)
        
        
        while stack :
            pos = stack.pop()
            # set visited
            maze[pos[0]][pos[1]] = 2
            # check for destination
            if pos[0] == destination[0] and pos[1] == destination[1] :
                return True
            for dir in  dirs :
                r = pos[0]
                c = pos[1]
                
                while (r >=0 and r< len(maze) and c >=0 and c < len(maze[0]) and maze[r][c] != 1) :
                    r += dir[0]
                    c += dir[1]
                
                
                r -= dir[0]
                c -= dir[1]
                
                # if it is not visited  then add position to stack
                if maze[r][c] != 2 :
                    stack.append([r,c])
                    
                
            
        return False;
