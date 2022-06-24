class Solution {
    public boolean isPossible(int[] target) {
        int sum = Arrays.stream(target).sum();
        int n = target.length - 1;
        boolean flag = check(target);
        while(flag) {
            Arrays.sort(target);
            int largest = target[n];
            sum -= target[n];
            if(sum == 0) {return false;}
            target[n] %= sum;
            if(sum == 1) {target[n]++;}
            sum += target[n];
            if(target[n] == largest) {return false;}
            flag = check(target);
        }

        for(int i: target) {
            if(i != 1){return false;}
        }

        return true;
    }

    private boolean check(int[] target) {
        for(int i: target) {
            if(i < 1) {return false;}
            else if(i > 1) {return true;}
        }

        return false;
    }

}