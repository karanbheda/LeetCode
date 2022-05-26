/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long beg = 1, end = n, idx = (end + beg)/2;
        boolean version = isBadVersion((int)idx);
        while(beg < end) {
            //System.out.println(idx + " " + beg + " " + end + " " + version);
            if(version) {
                if(idx == beg || !isBadVersion((int)(idx - 1))) {
                    return (int)idx;
                }
                
                if(end != idx) {end = idx;}
                else {break;}
            } else {
                if(beg != idx) {beg = idx;}
                else {break;}
            }
            
            idx = (end + beg)/2;
            version = isBadVersion((int)idx);
        }
        
        if(!version) {
            while(++idx <= end) {
                if(isBadVersion((int)idx)) {
                    return (int)idx;
                }
            }
        }
        
        return (int)idx;
    }
}