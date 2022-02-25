class Solution {
    public int compareVersion(String version1, String version2) {
        int v1 = 0, v2 = 0;
        int i = 0;
        for(String v: version1.split("\\.")) {
            i++;
            v1 = v1*10 + Integer.parseInt(v);
        }
        
        while(4-i > 0) {
            v1 *= 10;
            i++;
        }
        i = 0;
        for(String v: version2.split("\\.")) {
            i++;
            v2 = v2*10 + Integer.parseInt(v);
        }
        //System.out.println(v1 + " " + v2 + " " + i);
        while(4-i > 0) {
            v2 *= 10;
            i++;
        }
        //System.out.println(v1 + " " + v2 + " " + i);
        if(v2 > v1) return -1;
        
        if(v1 > v2) return 1;
        
        return 0;
    }
}