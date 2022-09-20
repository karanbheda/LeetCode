class Solution {
    public String multiply(String num1, String num2) {
        if(num2.length() > num1.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        if(num2.equals("0")) {return "0";}
        
        int m = num1.length();
        int n = num2.length();
        
        String[] mults = new String[10];
        int pow = 0;
        
        String ans = "0";
        for(int i = n - 1; i >= 0; i--) {
            int d = num2.charAt(i) - '0';
            if(mults[d] != null) {
                StringBuilder sb = new StringBuilder(mults[d]);
                for(int k = 1; k <= pow; k++) {
                    sb.append(0);
                }
                ans = add(ans, sb.toString());
                pow++;
                continue;
            }
            
            StringBuilder sb = new StringBuilder();
            
            
            int carry = 0;
            for(int j = m - 1; j >= 0; j--) {
                int f = num1.charAt(j) - '0';
               // System.out.println(d + " " + f);
                int s = d*f+carry;
                carry = s/10;
                sb.append(s%10);
            }
            if(carry != 0)
                sb.append(carry);
            sb = sb.reverse();
            mults[d] = sb.toString();
            
            for(int k = 1; k <= pow; k++) {
                sb.append(0);
            }
            ans = add(ans, sb.toString());
            pow++;
            
            // System.out.println( sb.toString());
            // System.out.println( ans);
            // System.out.println(Arrays.toString(mults));
        }
        

        
        return ans;
    }
    
    private String add(String s1, String s2) {
        int index1 = s1.length() - 1, index2 = s2.length() - 1;
        
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(index1 >= 0 && index2 >= 0) {
            int d = s1.charAt(index1) - '0';
            int f = s2.charAt(index2) - '0';
            
            int s = (d+f+carry);
            carry = s/10;
            sb.append(s%10);
            
            index1--;
            index2--;
        }
        
        while(index1 >= 0) {
            int d = s1.charAt(index1) - '0';
            
            int s = (d+carry);
            carry = s/10;
            sb.append(s%10);
            
            index1--;
        }
        
        while(index2 >= 0) {
            int d = s2.charAt(index2) - '0';
            
            int s = (d+carry);
            carry = s/10;
            sb.append(s%10);
            
            index2--;
        }
        
        if(carry != 0)
            sb.append(carry);
        sb = sb.reverse();
       // System.out.println(s1 + " " + s2 + " " + sb.toString());
        return sb.toString();
    }
}