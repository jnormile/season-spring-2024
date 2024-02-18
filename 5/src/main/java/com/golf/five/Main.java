package com.golf.five;class Main{
    static Boolean i(String b) {
        if (b.length() != 10) return false;
        
        int s = 0;
        for (int i = 0; i < 9; i++) {
            int digit = b.charAt(i) - '0';
            if (digit < 0 || digit > 9) return false;
            s += (10 - i) * digit;
        }
        
        char lastChar = b.charAt(9);
        int lastDigit = (lastChar=='X')?10:(lastChar-'0');return(s+lastDigit)%11==0;}static void main(String[]a){System.out.println(i(a[0]));}}