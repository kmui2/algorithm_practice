/*
Count number of occurrences (or frequency) in a sorted array
Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)

Examples:

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
  Output: 4 // x (or 2) occurs 4 times in arr[]

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
  Output: 1 

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 1
  Output: 2 

  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 4
  Output: -1 // 4 doesn't occur in arr[] 
  */
  
  public int occurrences (int[] arr, int x){
	  
	  int first_occurence = find_first_occurence(arr, x, 0, arr.length-1);
	  
	  if(first_occurence==-1){
		  return -1;
	  }
	  
	  int last_occurence = find_last_occurence(arr, arr.length, x, 0, arr.length-1);
	  
	  int count = last_occurence - first_occurence +1;
	  
	  return count;
	  
  }
  
  public int find_first_occurence(int[] arr, int x, int start, int end){
	  
	  if(end<start){
		  return -1;
	  }
	  
	  
	  int mid=(end-start)/2 + start;
	  
	  if(arr[mid]==x && (mid==0 || arr[mid-1]<x) ){
		  return mid;
	  }
	  else{
		  if(arr[mid]<x){
				return find_first_occurence(arr,x,mid+1,end);
		  }
		  else {
				return find_first_occurence(arr,x,start,mid-1);
		  }
	  }
  }
  
   public int find_last_occurence(int[] arr, int n, int x, int start, int end){
	  
	  if(end<start){
		  return -1;
	  }
	  
	  
	  int mid=(end-start)/2 + start;
	  
	  if(arr[mid]==x && (mid==n-1 || arr[mid+1]>x) ){
		  return mid;
	  }
	  else{
		  if(arr[mid]>x){
				return find_last_occurence(arr,n,x,start,mid-1);
		  }
		  else {
				return find_last_occurence(arr,n,x,mid+1,end);
		  }
	  }
  }
   
  
  
  
  
  
  
  
  
  
  