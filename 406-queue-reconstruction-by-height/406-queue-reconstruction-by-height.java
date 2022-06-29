class Solution {

    public int[][] reconstructQueue(int[][] people) {
        Map<Integer, Integer> positionStats = new HashMap<>();
        for(int[] person: people) {
            positionStats.put(person[0]*1000000+person[1], 0);
        }

        int index = -1;
        while(++index < people.length) {
            int[] candidate = null;
            int swapIdx = index;
            for(int i = index; i < people.length; i++) {
                if(people[i][1] == positionStats.get(people[i][0]*1000000+people[i][1])) {
                    if(candidate == null || candidate[0] > people[i][0]) {
                        candidate = people[i];
                        swapIdx = i;
                    }
                }
            }

            if(index != swapIdx) {
                int[] temp = people[swapIdx];
                people[swapIdx] = people[index];
                people[index] = temp;
            }


            for(int i = index; i < people.length; i++) {
                if(people[i][0] <= people[index][0]) {
                    positionStats.put(people[i][0]*1000000+people[i][1], positionStats.get(people[i][0]*1000000+people[i][1])+1);
                }
            }
        }

        return people;
    }
}