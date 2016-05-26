/**
 * Number of Islands
 * 
 * Given a 2d grid map of 'true's (land) and 'false's (water), 
 * count the number of islands. An island is surrounded by 
 * water and is formed by connecting adjacent lands horizontally 
 * or vertically. You may assume all four edges of the grid are 
 * all surrounded by water.
 * <p>
 * I decide to use BFS for this problem. I want to traverse all
 * cells in the matrix and I did two for loops. I also create a
 * new matrix with the same dimension as the original matrix to
 * record if this cell has been visited before. For every cell,
 * if it has not been visited and it is a part of an island, then
 * I do the BFS to go over all the members of the island and mark
 * them to be visited.
 * 
 * @author Suhan Liu
 * @param   grid    a boolean 2D matrix
 * @return          number of islands
 * 
 */

import java.util.*;

public class numberIsland {
    
    
    public static int numIslands(boolean[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        
        boolean[][] visited = new boolean[row][col];
        
        
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
            	
                if(visited[i][j] == false && grid[i][j] == true){
                    Queue<Pair> queue = new LinkedList<Pair>();
                    
                    queue.add(new Pair(i,j));
                    count++;
                    
                    
                    visited[i][j] = true;
                    
                    
                    while(!queue.isEmpty()){
                    	
                        Pair head = queue.peek();
                        
                        int m = head.row;
                        int n = head.col;
                        
                        if(m - 1 >= 0 && grid[m - 1][n] == true && visited[m - 1][n] == false){
                            queue.add(new Pair(m - 1, n));
                            visited[m - 1][n] = true;
                           
                        }
                        
                        if(m + 1 < grid.length && grid[m + 1][n] == true && visited[m + 1][n] == false){
                            queue.add(new Pair(m + 1, n));
                            visited[m + 1][n] = true;
                            
                        }
                        
                        if(n - 1 >= 0 && grid[m][n - 1] == true && visited[m][n - 1] == false){
                            queue.add(new Pair(m, n - 1));
                            visited[m][n - 1] = true;
                            
                        }
                        
                        if(n + 1 < grid[0].length && grid[m][n + 1] == true && visited[m][n + 1] == false){
                            queue.add(new Pair(m, n + 1));
                            visited[m][n + 1] = true;
                            
                        }
                        
                        //System.out.println(head.row + " col: " + head.col);
                        
                        queue.remove();
                    }
                    
                }
                
            }
        }
        
        return count;
        
    }
    
    public static class Pair{
        int row;
        int col;
        
        Pair(int i, int j){
            this.row = i;
            this.col = j;
        }
    }
    
    
    public static void main(String[] args){

    	       //Testcase 1
        System.out.print("Testcase1: ");
        boolean[][] grid = {{true,false,false,false,false},
                            {false,true,true,false,false},
                            {false,false,false,false,false},
                            {false,false,false,true,true},
                            {false,false,false,true,false}};
        System.out.println(numIslands(grid));
        
        //Testcase 2
        System.out.print("Testcase2: ");
        boolean[][] grid2 = {{true,true,false,false,false},
                            {false,true,true,false,false},
                            {false,false,false,false,false},
                            {false,false,false,true,true},
                            {false,false,false,true,false}};
        System.out.println(numIslands(grid2));
        
        //Testcase 3
        System.out.print("Testcase3: ");
        boolean[][] grid3 = {{true,true,true,true,true},
                            {true,true,true,true,true},
                            {true,true,true,true,true},
                            {true,true,true,true,true},
                            {true,true,true,true,false}};
        System.out.println(numIslands(grid3));
    }
}