class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        Integer firstLowerDigit = Integer.parseInt(String.valueOf(low).substring(0, 1));
        Integer firstHigherDigit = Integer.parseInt(String.valueOf(high).substring(0, 1));
        
        for(int i = 1; i <= 9; i++) {
            int sum = i;
            for(int j = String.valueOf(low).length(); j <= String.valueOf(high).length(); j++) {
                sum = this.calcSum(j, sum);
                if(sum >= low && sum <= high) {
                    result.add(new Integer(sum));
                } else if (sum > high) {break;}
            }
        }
        
        Collections.sort(result);
        return result;
    }
    
    public int calcSum(int size, int sum) {
        while(String.valueOf(sum).length() < size) {
            int lastDigit = sum%10;
            if(lastDigit == 9) {
                return -1;
            }
            sum *= 10;
            sum += lastDigit + 1;
        }
        return sum;
    }
}