package com.test;

public class ReverseAString {
    public static void getReverse(String str){
        String[] st = str.split("");
        String revString = "";
        for(int i=st.length-1; i>=0 ; i --){
            revString = revString + st[i];
        }
        System.out.println("The  String is : "+revString);
        System.out.println("The reverse String is : "+revString);
    }

    public static void main (String []args){
        getReverse("ANKUR123");
    }
}
