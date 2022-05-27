class Solution {
    public int numberOfSteps(int num) {
        if(num == 0) {
            return 0;
        }
        int count = 0;
        
        while(num > 1) {
            if(num%2 == 1) {
                count+=2;
            } else {
                count++;
            }
            num/=2;
        }
        
        return ++count;
    }
}