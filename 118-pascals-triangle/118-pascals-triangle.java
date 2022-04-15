class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>() {{ add(1); }});
        
        calc(2, numRows, result);
        return result;
    }
    
    private void calc(int i, int n, List<List<Integer>> result) {
        if(i > n) {return;}
        
        List<Integer> list = new ArrayList<>();
        list.add(1);
        List<Integer> prev = result.get(result.size() - 1);
        for(int j = 0; j < prev.size() - 1; j++) {
            list.add(prev.get(j) + prev.get(j+1));
        }
        
        list.add(1);
        
        result.add(list);
        calc(i+1, n, result);
    }
}