class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0, end = arr.length;
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {return mid;}
            
            if(arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {end = mid;}
            else {start = mid + 1;}
        }
        
        return start;
    }
}