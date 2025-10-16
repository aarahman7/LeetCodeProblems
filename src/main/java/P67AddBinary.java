public class P67AddBinary {

    public static void main(String[] args) {
        P67AddBinary p67AddBinary = new P67AddBinary();
        System.out.println(p67AddBinary.addBinary("0", "0"));
        System.out.println(p67AddBinary.addBinary("11", "1"));
    }

    public String addBinary(String a, String b) {
        int carry = 0;
        String finalResult = "";

        int maxLength = Math.max(a.length(), b.length());
        int index = 0;
        while(index < maxLength) {
            int sum = 0;
            sum += carry;
            if(a.length() - 1 - index >= 0) {
                sum += Integer.parseInt(a.charAt(a.length() - 1 - index) + "");
            }
            if(b.length() - 1 - index >= 0) {
                sum += Integer.parseInt(b.charAt(b.length() - 1 - index) + "");
            }

            if(sum == 3) {
                carry = 1;
                finalResult = "1" + finalResult;
            } else if (sum == 2) {
                carry = 1;
                finalResult = "0" + finalResult;
            } else if (sum == 1) {
                carry = 0;
                finalResult = "1" + finalResult;
            } else {
                carry = 0;
                finalResult = "0" + finalResult;
            }
            index ++;
        }
        if(carry == 1) {
            finalResult = "1" + finalResult;
        }
        return finalResult.toString();
    }
}
