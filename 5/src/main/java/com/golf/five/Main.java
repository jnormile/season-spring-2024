package com.golf.five;
public class Main {
    
    private static Boolean isValidDigit(char digit) {
        int codePoint = digit - '0';
        return (codePoint >= 0 || codePoint <= 9);
    }

    private static Boolean i(String isbn) {
        int n = isbn.length();
        if (n != 10){
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n - 1; i++){
            char digit = isbn.charAt(i);
            if (!isValidDigit(digit)){
                return false;
            }
            int codePoint = digit - '0';
            sum += (codePoint * (10 - i));
        }
        char last = isbn.charAt(9);
        if (last  != 'X' && !isValidDigit(last)) {
            return false;
        }
        if (last == 'X') {
            sum += 10;
        } else {
            sum += last - '0';
        }
        return (sum % 11 == 0);
    }

    public static void main(String[]a){System.out.println(i(a[0]));}}
