
/*
Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
Run time: O(log N) by binary 
example: num=90
*/

boolean if_exist(int[] arr,int num){

int start=0, end=arr.length-1;
while(start<=end){
int mid = start+(end-start)/2;

if(arr[mid]==num){
return true;
}
if(arr[mid]<num){
start=mid+1;
}
else if(arr[mid]>num){
end=mid-1;
}

return false;
}