class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b) -> {
            if(a[1] == b[1]) {return a[0]-b[0];}
            return a[1]-b[1];
        });
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        int time = 0;
        for(int[] course: courses) {
            if(course[0] > course[1]) {continue;}

            if(time + course[0] <= course[1]) {
                queue.add(course);
                time += course[0];
            }
            else if (!queue.isEmpty() && course[0] < queue.peek()[0]) {
                int[] top = queue.peek();
                int temp = time;
                temp -= top[0];
                if(temp + course[0] <= course[1]) {
                    queue.poll();
                    queue.add(course);
                    temp += course[0];
                    time = temp;
                }
            }
        }

        return queue.size();
    }
}