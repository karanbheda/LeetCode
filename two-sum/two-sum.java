class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(nums[i])) {
                list = map.get(nums[i]);
            }

            list.add(i);
            map.put(nums[i], list);
        }
        int[] result = new int[2];
        for(int i: map.keySet()) {
            int x = target - i;
            if(map.containsKey(x)) {
                if(i != x) {
                    result[0]=map.get(i).get(0);
                    result[1]=map.get(x).get(0);
                    return result;
                } else {
                    if(map.get(i).size() > 1) {
                        result[0]=map.get(i).get(0);
                        result[1]=map.get(i).get(1);
                        return result;
                    }
                }
            }
        }

        return result;
    }
}