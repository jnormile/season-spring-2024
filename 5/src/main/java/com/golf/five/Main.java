package com.golf.five;class Main{static void main(String[]a){String b=a[0];int s=0;for(int i=0;i<9;i++){int d=b.charAt(i)-48;s+=(10-i)*d;}char r=b.charAt(9);int g=(r=='X')?10:(r-48);System.out.println((s+g)%11==0);}}