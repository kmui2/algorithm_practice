/*
Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according to the layout rules described above. Note that the puzzle represented by grid does not have to be solvable.

Example

For

grid = [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        ['.', '.', '.', '5', '.', '.', '.', '7', '.']]
the output should be
sudoku2(grid) = true;

For

grid = [['.', '.', '.', '.', '2', '.', '.', '9', '.'],
        ['.', '.', '.', '.', '6', '.', '.', '.', '.'],
        ['7', '1', '.', '.', '7', '5', '.', '.', '.'],
        ['.', '7', '.', '.', '.', '.', '.', '.', '.'],
        ['.', '.', '.', '.', '8', '3', '.', '.', '.'],
        ['.', '.', '8', '.', '.', '7', '.', '6', '.'],
        ['.', '.', '.', '.', '.', '2', '.', '.', '.'],
        ['.', '1', '.', '2', '.', '.', '.', '.', '.'],
        ['.', '2', '.', '.', '3', '.', '.', '.', '.']]
the output should be
sudoku2(grid) = false.

The given grid is not correct because there are two 1s in the second column. Each column, each row, and each 3 × 3 subgrid can only contain the numbers 1 through 9 one time.
*/


boolean row_unique(char[][] grid,int col_start,int col_end,int row_start,int row_end){
    
    for(int i=row_start;i<row_end;i++){
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
		//instead of map, we can use Set. Set<Character> mp = new HashSet<Character>();
        for(int j=col_start;j<col_end;j++){
            if(grid[i][j]!='.'){
              if(mp.containsKey(grid[i][j])){
                return false;
              } 
              else{
                  mp.put(grid[i][j],1);
              }  
            }
            
        }
    }
    return true;
}

boolean column_unique(char[][] grid,int col_start,int col_end,int row_start,int row_end){
    
    for(int i=col_start;i<col_end;i++){
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        for(int j=row_start;j<row_end;j++){
            if(grid[j][i]!='.'){
              if(mp.containsKey(grid[j][i])){
                return false;
              } 
              else{
                  mp.put(grid[j][i],1);
              }  
            }
            
        }
    }
    return true;
}

boolean unique_3x3(char[][] grid,int col_start,int col_end,int row_start,int row_end){
    
    Map<Character, Integer> mp = new HashMap<Character, Integer>();
    for(int i=row_start;i<row_end;i++){        
        for(int j=col_start;j<col_end;j++){
            if(grid[i][j]!='.'){
              if(mp.containsKey(grid[i][j])){
                return false;
              } 
              else{
                  mp.put(grid[i][j],1);
              }  
            }
            
        }
    }
    return true;
}

boolean sudoku2(char[][] grid) {

    boolean unique_in_row = row_unique(grid,0,9,0,9);
    if(!unique_in_row){return false;}
    boolean unique_in_column = column_unique(grid,0,9,0,9);
    if(!unique_in_column){return false;}
    
    int row=0,column=0;
    while(row<9){
        while(column<9){
            boolean unique_3x3 = unique_3x3(grid,column,column+3,row,row+3);
            if(!unique_3x3){return false;}
            column=column+3;
        }
        column=0;
        row=row+3;
        
    }
    return true;
}
