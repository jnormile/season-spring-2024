package com.golf.five;class Main{static void main(String[]a){String b=a[0];int s=0;for(int i=0;i<10;i++){int d=b.charAt(i);int g=(d=='X')?10:(d-48);s+=(10-i)*g;}System.out.println(s%11==0);}}