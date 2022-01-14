class Solution {
    public int myAtoi(String s) {
        Long value = 0L;
        char[] c = s.toCharArray();
        int i = 0;
        //ignore white spaces

        if(c.length > 0) {
            while(i < c.length && c[i] == ' ') {
                i++;
            }

            int factor = 1;
            if(i < c.length && c[i] == '+'){
                //nothing
                i++;
            } else if(i < c.length && c[i] == '-') {
                factor = -1;
                i++;
            }

            while(i < c.length && c[i] >= '0' && c[i] <= '9') {
                value =  value * 10 + (factor *  (long)(c[i] - '0'));
                i++;
                if(value > Integer.MAX_VALUE) {return Integer.MAX_VALUE;}
                else if (value < Integer.MIN_VALUE) {return Integer.MIN_VALUE;}
            }
        }


        return value.intValue();
    }
}