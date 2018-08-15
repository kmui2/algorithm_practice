/*
Bubble sort
Time complexity
worst case: O(n^2)
best case when array is sorted: O(n)

Space complexity
O(1)
*/

void bubble_sort(int[] arr){
	boolean swapped;
	int tot_to_travel = arr.length-1;
	int j=0;
	while(tot_to_travel>0){
		swapped = false;
		for(int i=0;i<tot_to_travel;i++){
			j=i+1;
			if(arr[i]>arr[j]){
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j]=temp;
			swapped = true;
			}
			
		}
		tot_to_travel--;
		if(swapped==false){ // the arr is sorted as no swapping occured
		break;
		}
	}
}

/*
Quick Sort
time complexity
Best, average: O(nlogn)
Worst case: O(n^2)

Space complexity
O(logn)
*/

void quickSort(int[] A, int p, int r){
	if(r>p){
		int q = partitionSort(A,p,r); //get index of pivot
		quickSort(A,p, q-1); // first half sort
		quickSort(A,q+1,r);
	}
	
}

int partitionSort(int[] A, int p, int r){
		int i=p-1;
		int j=p;
		while(j<r){
			if(A[j]>A[r]){
				j++;
			}
			else{
				swap(A,i+1,j);
				i++;
				j++;
			}
		}
		swap(A,i+1,r); //swap the pivot value
		
		return i+1;
			
}

void swap(int[] A, int x, int y){
		int temp = A[x];
		A[x]=A[y];
		A[y]=temp;
}


/*
merge sort
Time complexity
Best case, Worst case: O(nlogn)

Space complexity
O(n)
*/

void mergeSort(int[] A, int p, int r){
	if(r>p){
		int q = (r+p)/2; //mid index
		mergeSort(A,p,q-1);
		mergeSort(A,q+1,r);
		merge(A,p,q,r);
	}
}

void merge(int[] A, int p,int q, int r){
	int[] LA = new int[q-p+1];
	int[] RA = new int[r-q];
	
	for(int i=0;i<LA.length;i++){
		LA[i] = A[p+i];
	}
	for(int j=0;j<RA.length;j++){
		RA[j] = A[q+j+1];
	}
	i=0;j=0;
	int k=p;
	while(i<LA.length && j<RA.length){
		if(LA[i]<=RA[j]){
			A[k]=LA[i];
			i=i+1;
		}
		else{
			A[k]=RA[j];
			j=j+1;
		}
		k++;
	}
	while(i<LA.length){
		A[k]=LA[i];
		i++; k++;
	}
	while(j<RA.length){
		A[k]=RA[j];
		j++; k++;
	}
}




















