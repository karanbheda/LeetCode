class Solution {
    class Interval implements Comparable<Interval> {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Interval i) {
            if(i.start == this.start) {
                return this.end - i.end;
            }

            return this.start - i.start;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        int min = 0;
        List<Interval> intervalList = new ArrayList<>();
        for(int[] interval: intervals) {
            intervalList.add(new Interval(interval[0], interval[1]));
        }
        Collections.sort(intervalList);
        List<Integer> meetingTimeList = new LinkedList<>();

        for(Interval interval: intervalList) {
            boolean foundRoom = false;
            if(!meetingTimeList.isEmpty()) {
                for(int i = 0; i < meetingTimeList.size(); i++) {
                    if(interval.start >= meetingTimeList.get(i)) {
                        meetingTimeList.remove(i);
                        meetingTimeList.add(i, interval.end);
                        foundRoom = true;
                        break;
                    }
                }
            }

            if(!foundRoom) {
                meetingTimeList.add(interval.end);
            }

            min = Math.max(min, meetingTimeList.size());
        }

        return min;
    }
}