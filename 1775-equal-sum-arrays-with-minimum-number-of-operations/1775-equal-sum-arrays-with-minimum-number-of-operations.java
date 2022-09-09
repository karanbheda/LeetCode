class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length * 6 || nums2.length > nums1.length * 6) {
            return -1;
        }
        
        int sum1 = Arrays.stream(nums1).sum();
        int sum2 = Arrays.stream(nums2).sum();
        
        if(sum1 > sum2) {
            return minOperations(nums2, nums1);
        }
        
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i: nums1) {minQ.add(i);}
        for(int i: nums2) {maxQ.add(i);}
        
        int count = 0;
        while(sum1 < sum2) {
            if(maxQ.isEmpty() || maxQ.peek() - 1 < 6 - minQ.peek()) {
                sum1 += 6 - minQ.poll();
            } else {
                sum2 -= maxQ.poll() - 1;
            }
            count++;
        }
        
        return count;
    }
}