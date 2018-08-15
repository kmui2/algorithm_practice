
/* Rotate 90 degree for nxn matrix

if rotate 90 degree and in place, it should always be a square matrix. Otherwise not possible.
*/

public class practice_2017 {

    public void rotate90(int[][]matrix,int n){
        int endlimit=n-1;
        for(int layer=0;layer<n/2;layer++){
            for(int offset=0;offset<endlimit-layer;offset++){
                int temp=matrix[layer][layer+offset];
                matrix[layer][layer+offset] = matrix[endlimit-offset][layer];
                matrix[endlimit-offset][layer] = matrix[endlimit][endlimit-offset];
                matrix[endlimit][endlimit-offset] = matrix[layer+offset][endlimit];
                matrix[layer+offset][endlimit] = temp;
            }
            endlimit=endlimit-1;
        }
        //return matrix;
    }
     
public static void main(String[] args){
	 
        practice_2017 obj = new practice_2017();
        int[][]matrix=new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        obj.rotate90(matrix,5);
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print("matrix["+i+"]["+j+"]="+matrix[i][j]+"  ");
            }
            System.out.println("");
        }
}
 }