/**
 * 
 * Given a 2D matrix with only '1', '0' and '9' as a maze. '1' is the path 
 * you can go through, while '0' is the wall. The start point is the on the
 * left-top corner, and the cell with '9' is the end point. Find if there is
 * a path to go from the start point to the end point
 * <p>
 * I use DFS to solve this problem. For every cell, there are four directions
 * to go. The four directions could be path, wall or out of boundary. I created
 * another matrix with the same size as the original matrix to record if the
 * cell has been visited. 
 * 
 * 
 * @author Suhan Liu
 * @param	grid 	The maze to find the path
 * @return			Return true 1 if there is a path to go the the end point
 *					and return false if there is no path.
 * 
 */


public class pathMaze {
	public static int maze(int[][] grid){
		int rowLen = grid.length;
		int colLen = grid[0].length;
		
		if(grid == null || rowLen == 0 || colLen == 0){
			return 0;
		}
		
		int[][] visited = new int[rowLen][colLen];
		
		if(findPath(0, 0, grid, visited)){
			return 1;
		}else{
			return 0;
		}
		
	}
	
	/*
	 * recursion part to do DFS
	 */
	
	public static boolean findPath(int i, int j, int[][] grid, int[][] visited){
		if(i >= 0 
		&& i < grid.length 
		&& j >= 0 
		&& j < grid[0].length 
		&&
		grid[i][j] == 9){
			visited[i][j] = 1;
			return true;
		}
		
		if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1 
				&& visited[i][j] == 0){
			visited[i][j] = 1;
			
			if(findPath(i + 1, j, grid, visited)){
				return true;
			}
			if(findPath(i - 1, j, grid, visited)){
				return true;
			}
			if(findPath(i, j + 1, grid, visited)){
				return true;
			}
			if(findPath(i, j - 1, grid, visited)){
				return true;
			}
			visited[i][j] = 0;
			return false;
		}
		return false;
	}
	
	public static void main(String[] args){
		//Testcases 1
		System.out.print("Testcase 1: ");
		int[][] grid = {
				{1, 0, 1, 1, 1, 0, 9},
				{1, 1, 0, 0, 1, 0, 1},
				{0, 1, 1, 1, 0, 1, 1},
				{0, 0, 1, 1, 1, 1 ,1}};
		
		System.out.println(maze(grid));
		
		//Testcase 2
		System.out.print("Testcase 2: ");
		int[][] grid2 = {
				{1, 0, 1, 1, 1, 0, 9},
				{1, 1, 0, 0, 1, 0, 1},
				{0, 1, 1, 1, 0, 1, 1},
				{0, 0, 1, 1, 1, 0 ,1}};
		
		System.out.println(maze(grid2));
	}
}
