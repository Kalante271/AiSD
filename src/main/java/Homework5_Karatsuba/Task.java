package Homework5_Karatsuba;

public class Task {
    public static String multiply(String bin1, String bin2) {
        bin1 = trimLeadingZeros(bin1);
        bin2 = trimLeadingZeros(bin2);

        int length = Math.max(bin1.length(), bin2.length());

        if (length == 0) return "0";

        if (length == 1) {

            return (bin1.equals("1") && bin2.equals("1")) ? "1" : "0";
        }

        length = nextPowOfTwo(length);
        bin1 = addZerosLeft(bin1, length);
        bin2 = addZerosLeft(bin2, length);

        int half = length / 2;

        String left1 = bin1.substring(0, half);
        String right1 = bin1.substring(half);
        String left2 = bin2.substring(0, half);
        String right2 = bin2.substring(half);

        String productLeft = multiply(left1, left2);
        String productRight = multiply(right1, right2);

        String sumLeftRight1 = addBinary(left1, right1);
        String sumLeftRight2 = addBinary(left2, right2);

        String productSum = multiply(sumLeftRight1, sumLeftRight2);

        String middleProduct = subtractBinary(subtractBinary(productSum, productLeft), productRight);

        String result = addBinary(
                addBinary(shiftLeft(productLeft, 2 * (length - half)),
                        shiftLeft(middleProduct, length - half)),
                productRight);

        return trimLeadingZeros(result);
    }

    private static String addZerosLeft(String s, int totalLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < totalLength; i++) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }

    private static String trimLeadingZeros(String s) {
        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') i++;
        return s.substring(i);
    }

    private static int nextPowOfTwo(int n) {
        int pow = 1;
        while (pow < n) {
            pow <<= 1;
        }
        return pow;
    }

    private static String addBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        a = addZerosLeft(a, maxLen);
        b = addZerosLeft(b, maxLen);

        StringBuilder result = new StringBuilder();
        int carry = 0;

        for (int i = maxLen - 1; i >= 0; i--) {
            int bitA = a.charAt(i) - '0';
            int bitB = b.charAt(i) - '0';
            int sum = bitA + bitB + carry;

            result.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    private static String subtractBinary(String a, String b) {
        int maxLen = Math.max(a.length(), b.length());
        a = addZerosLeft(a, maxLen);
        b = addZerosLeft(b, maxLen);

        StringBuilder result = new StringBuilder();
        int borrow = 0;

        for (int i = maxLen - 1; i >= 0; i--) {
            int bitA = a.charAt(i) - '0' - borrow;
            int bitB = b.charAt(i) - '0';

            if (bitA < bitB) {
                bitA += 2;
                borrow = 1;
            } else {
                borrow = 0;
            }

            result.append(bitA - bitB);
        }

        return trimLeadingZeros(result.reverse().toString());
    }

    private static String shiftLeft(String binary, int n) {
        StringBuilder sb = new StringBuilder(binary);
        for (int i = 0; i < n; i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}
