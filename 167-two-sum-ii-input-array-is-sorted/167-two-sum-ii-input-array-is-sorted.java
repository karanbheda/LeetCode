class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = -1;
        
        for(; index1 < numbers.length; index1++) {
            int req = target - numbers[index1];
            
            int beg = index1 + 1, end = numbers.length - 1;
            
            boolean isSolved = false;
            while(beg <= end) {
                int mid = (beg+end)/2;
                
                if(numbers[mid] == req) {
                    index2 = mid;
                    isSolved = true;
                    break;
                } else if (numbers[mid] > req) {
                    end = mid - 1;
                } else {
                    beg = mid + 1;
                }
            }
            
            if(isSolved) {break;}
        }
        
        return new int[]{index1+1, index2+1};
    }
}