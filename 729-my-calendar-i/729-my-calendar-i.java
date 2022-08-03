class MyCalendar {
    List<int[]> bookings;
    
    public MyCalendar() {
        bookings = new ArrayList<>();    
    }
    
    public boolean book(int start, int end) {
        int first = 0, last = bookings.size();
        boolean possible = true;
        
        while(first <= last && first < bookings.size()) {
            int mid = (first + last)/2;
            
            int[] booking = bookings.get(mid);
            //if(start == 18) {System.out.println(mid + " " + Arrays.toString(booking));}
            if(start >= booking[0] && start < booking[1]) {
                possible = false;
                break;
            }
            
            if(end <= booking[0]) {
                last = mid - 1;
            } else if (start >= booking[1]) {
                first = mid + 1;
            } else {
                possible = false;
                break;
            }
        }
        
        if(possible) {
            bookings.add(first, new int[]{start, end});
           // System.out.println(first + " " + bookings.size());
        }
        
        return possible;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */