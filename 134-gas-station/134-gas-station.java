class Solution {
   public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
       int gasSoFar = 0;
       int start = 0;
       for(int i = 0; i < gas.length; i++) {
           totalGas += gas[i] - cost[i];
           gasSoFar += gas[i] - cost[i];
           if(gasSoFar < 0){
               start = i + 1;
               gasSoFar = 0;
           }
       }
       
       return totalGas >= 0 ? start:-1;
    }
}