class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> list = new HashSet<>();
        combine(candidates, target, new ArrayList<>(), list);
        return new ArrayList<>(list);
    }
    
    private void combine(int[] candidates, int target, List<Integer> soFar, Set<List<Integer>> list) {
        if(target < 0) {
            return;
        }
        
        if(target == 0) {
            Collections.sort(soFar);
            list.add(soFar);
            return;
        }
        
        for(int i = 0; i < candidates.length; i++) {
            if(target - candidates[i] >= 0) {
                List<Integer> copy = new ArrayList<>(soFar);
                copy.add(candidates[i]);
                combine(candidates, target - candidates[i], copy, list);
            }
        }
    }
}