class Solution {
    class Event implements Comparable<Event>{
        int time;
        boolean pickup;
        int passengers;

        Event(int time, boolean pickup, int passengers) {
            this.time = time;
            this.pickup = pickup;
            this.passengers = passengers;
        }

        @Override
        public int compareTo(Event e) {
            if(this.time == e.time) {
                return (this.pickup?1:0) - (e.pickup ? 1:0);
            }
            return this.time - e.time;
        }
    }

    public boolean carPooling(int[][] trips, int capacity) {
        List<Event> events = new ArrayList<>();

        for(int i = 0; i < trips.length; i++) {
            Event pickup = new Event(trips[i][1], true, trips[i][0]);
            Event drop = new Event(trips[i][2], false, trips[i][0]);
            events.add(pickup);
            events.add(drop);
        }

        Collections.sort(events);
        int total = 0;
        for(Event e: events) {
            if(e.pickup) {
                total += e.passengers;
            } else {
                total -= e.passengers;
            }

            if(total > capacity) {return false;}
        }

        return true;
    }
}