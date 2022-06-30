class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int medianIdx = (n-1)/2;
        int medianValue = nums[medianIdx];
        int moves = 0;
        for(int i: nums) {
            moves += Math.abs(i-medianValue);
        }

        if(n%2 == 0) {
            medianIdx = n/2;
            medianValue = nums[medianIdx];
            int moves2 = 0;
            for(int i: nums) {
                moves2 += Math.abs(i-medianValue);
            }
            moves = Math.min(moves, moves2);
        }
        return moves;
    }
}