import java.util.Arrays;
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int start = 0, end = n - 1;
        int mid = (start+end)/2;
        
        while (start < end) {
            if(arr[mid] == x) {
                break;
            }
            
            if(arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            
            mid = (start+end)/2;
        }
        
        if(arr[mid] != x) {
            int leftVal = Integer.MAX_VALUE, rightVal = Integer.MAX_VALUE, midVal = Math.abs(arr[mid] - x);
            if(mid - 1 >= 0) {
                leftVal = Math.abs(arr[mid-1] - x);
            }
            
            if(mid + 1 < n) {
                rightVal = Math.abs(arr[mid+1] - x);
            }
            
            if(leftVal <= rightVal && leftVal <= midVal) {
                mid -= 1;
            } else if(rightVal < leftVal && rightVal < midVal) {
                mid += 1;
            }
        }
        
        int left = mid, right = mid + 1;
        int leftVal = Integer.MAX_VALUE, rightVal = Integer.MAX_VALUE;
        LinkedList<Integer> result = new LinkedList<>();
        while(right - left <= k) {
            //System.out.println(left + " " + right);
            leftVal = Integer.MAX_VALUE;
            rightVal = Integer.MAX_VALUE;
            if(left >= 0) {
                leftVal = Math.abs(arr[left] - x);
            }
            
            if(right < n) {
                rightVal = Math.abs(arr[right] - x);
            }
            
            if(leftVal <= rightVal) {
                result.addFirst(arr[left]);
                left--;
            } else {
                result.addLast(arr[right]);
                right++;
            }
        }
        
        return result;
    }
}