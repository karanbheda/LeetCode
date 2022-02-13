/**
 * // This is Sea's API interface.
 * // You should not implement it, or speculate about its implementation
 * class Sea {
 *     public boolean hasShips(int[] topRight, int[] bottomLeft);
 * }
 */

class Solution {
    int count = 0;
    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
//         Queue<int[][]> stack = new LinkedList<>();
//         stack.add(new int[][]{topRight, bottomLeft});
        
//         while(!stack.isEmpty()) {
//             int[][] pos = stack.poll();
//             int[] tr = pos[0];
//             int[] bl = pos[1];
            
//             int l = tr[0] - bl[0];
//             int h = tr[1] - bl[1];
//             if(l < 0 || h < 0) {
//                 continue;
//             }
            
//             if(sea.hasShips(tr, bl)) {
//                 if(l == 0 && h == 0) {
//                     System.out.println(Arrays.toString(tr) + " " + Arrays.toString(bl));
//                     count++;
//                     continue;
//                 }
                
//                 int mx = (tr[0]+bl[0])/2, my = (tr[1]+bl[1])/2;

//                 stack.add(new int[][]{new int[]{mx, my}, bl});
//                 stack.add(new int[][]{new int[]{tr[0], my}, new int[]{mx, bl[1]}});
//                 stack.add(new int[][]{new int[]{mx, tr[1]}, new int[]{bl[0], my}});
//                 stack.add(new int[][]{tr, new int[]{mx, my}});
//             }
//         }
        rec(sea, topRight, bottomLeft);
        return count;
    }
    
    private void rec(Sea sea, int[] top, int[] bottom) {
        if(top[0] < bottom[0] || top[1] < bottom[1]) {
            return;
        }
        if(sea.hasShips(top, bottom)) {
            if(top[0] - bottom[0] == 0 && top[1] - bottom[1] == 0) {
                count++;
                return;
            }
            
            int mx = (top[0]+bottom[0])/2, my = (top[1]+bottom[1])/2;
            
            rec(sea, new int[]{mx, my}, bottom);
            rec(sea, new int[]{top[0], my}, new int[]{mx+1, bottom[1]});
            rec(sea, new int[]{mx, top[1]}, new int[]{bottom[0], my+1});
            rec(sea, top, new int[]{mx+1, my+1});
        }
    }
}