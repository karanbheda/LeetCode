class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder("");
        char[] p = a.toCharArray();
        char[] q = b.toCharArray();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while(i >= 0 && j >= 0) {
            int sum = Integer.parseInt(Character.toString(p[i])) + Integer.parseInt(Character.toString(q[j])) + carry;
            if(sum < 2) {
                carry = 0;
            }
            else if(sum == 2) {
                sum = 0;
                carry = 1;
            } else if (sum == 3) {
                sum = 1;
                carry = 1;
            }

            result.append(sum);
            i--;j--;
        }

        while(i >= 0) {
            int sum = Integer.parseInt(Character.toString(p[i])) + carry;
            if(sum < 2) {
                carry = 0;
            }
            else if(sum == 2) {
                sum = 0;
                carry = 1;
            }
            result.append(sum);
            i--;
        }

        while(j >= 0) {
            int sum = Integer.parseInt(Character.toString(q[j])) + carry;
            if(sum < 2) {
                carry = 0;
            }
            else if(sum == 2) {
                sum = 0;
                carry = 1;
            }
            result.append(sum);
            j--;
        }

        if(carry == 1) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}