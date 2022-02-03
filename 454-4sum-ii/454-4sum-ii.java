class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Long, Integer> sum12 = new HashMap<>();
        Map<Long, Integer> sum34 = new HashMap<>();
        
        int n = nums1.length;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                long sum1 = nums1[i] + nums2[j];
                sum12.put(sum1, sum12.getOrDefault(sum1, 0) + 1);
                
                long sum2 = nums3[i] + nums4[j];
                sum34.put(sum2, sum34.getOrDefault(sum2, 0) + 1);
            }
        }
        
        int total = 0;
        for(Long halfSum: sum12.keySet()) {
            if(sum34.containsKey(-halfSum)) {
                total += sum12.get(halfSum) * sum34.get(-halfSum);
            }
        }
        
        return total;
    }
}