/*


    In a given grid, each cell can have one of three values:

    the value 0 representing an empty cell;
    the value 1 representing a fresh orange;
    the value 2 representing a rotten orange.
    Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

    Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead

/*


    Time Complexity : O(N*M)
    Space complexity : O(N*M) 
    is worked on leetcode : YES
*/

public class RottenOranges {
    
   
    public int orangesRotting(int[][] grid) {
        
        if (grid == null || grid.length == 0) return 0;
        
        int row = grid.length;
        int col = grid[0].length;
        int fresh_count =0;
        int time=0;
        int first_roten = 0;
        Queue<int []> q = new LinkedList();
        for(int i =0;i< row;i++){
            for (int j =0;j< col;j++){
//                 if fresh update the count
                if( grid[i][j]  == 1){
                    fresh_count++;
                }
//                 rotten then put it for processing in queue
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
                
            }
        }
        
        if (fresh_count == 0 ) return 0;
        
//         process the queue
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int k=0;k< size;k++){
                    int [] o_loc = q.poll();
            
                for(int [] dir : dirs){
                    int r = o_loc[0] + dir[0];
                    int c = o_loc[1] + dir[1];
                    if ( r >= 0 && r <= row-1 && c>= 0 && c<= col-1 && grid[r][c] == 1){
    //                     if fresh orange found in neighbour rott it
                        grid[r][c] = 2;
                        q.add(new int[]{r,c});
                        fresh_count--;
                    }
                
                }
            }
            
            
            time++;
        }
        
        // System.out.pri
        if (fresh_count > 0 ) return -1;
        
        return time-1;
        
        
    }
}