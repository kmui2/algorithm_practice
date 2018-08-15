/*
Median of Array
There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).

The overall run time complexity should be O(log (m+n)).

Sample Input

A : [1 4 5]
B : [2 3]

Sample Output

3
 NOTE: IF the number of elements in the merged array is even, then the median is the average of n / 2 th and n/2 + 1th element. 
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5 

Reference: https://www.youtube.com/watch?v=LPFhl65R7ww

*/

public class practice {
	
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int lena = a.size();
		int lenb = b.size();
		if(lena==0 && lenb==0){
		    return -1;
		}
		
		if(lena==0 && lenb>0){
		    int mid = lenb/2;
		    if(lenb%2==0){
		        return (double)(b.get(mid-1)+b.get(mid))/2;
		    }
		    else{
		        return (double)(b.get(mid));
		    }
		    
		}
		
		if(lena>lenb){
		    return findMedianSortedArrays(b,a);
		}
		
		int starta=0;
		int enda=a.size();
		
		while(starta<=enda){
			int partitiona = (enda-starta)/2+starta;
			int partitionb = (a.size()+b.size()+1)/2 - partitiona;
			
			int maxLefta = (partitiona ==0) ? Integer.MIN_VALUE : a.get(partitiona-1);
			int minRighta =(partitiona == lena) ? Integer.MAX_VALUE : a.get(partitiona);
			
			int maxLeftb = (partitionb == 0) ? Integer.MIN_VALUE : b.get(partitionb -1);
			int minRightb = (partitionb == lenb) ? Integer.MAX_VALUE : b.get(partitionb);
			
			if(maxLefta<=minRightb && maxLeftb<=minRighta){
				//found correct partition
				if((lena+lenb)%2>0) { //total odd counts
					return (double)Math.max(maxLefta,maxLeftb);
				}
				else{ //total count is even
					System.out.println("maxLefta= "+maxLefta);
					System.out.println("maxLeftb= "+maxLeftb);
					System.out.println("minRighta= "+minRighta);
					System.out.println("minRightb= "+minRightb);
	                return (double)(Math.max(maxLefta,maxLeftb)+Math.min(minRighta,minRightb))/2;
				}
			}
			
			else if(maxLefta>minRightb){
				enda = partitiona-1;
			}
			else{
				starta = partitiona+1;
			}
			
		}
		
		return -1;
		}
	
	public static void main(String[] args){
		practice obj = new practice();
					//System.out.println("cal= "+Math.pow(-1, 1)%20);
			List<Integer> l1 = new ArrayList<Integer>();
			List<Integer> l2 = new ArrayList<Integer>();
			
			l1.add(-50); l1.add(-41); l1.add(-40); l1.add(-19); l1.add(5);
			l1.add(21); l1.add(28);
			
			l2.add(-50); l2.add(-21); l2.add(-10);
			System.out.println(obj.findMedianSortedArrays(l1,l2));
		
	}
	
}










