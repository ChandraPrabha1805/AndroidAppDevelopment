package com.test;

public class AscendingArray {

    public static void getAscending(int [] numArrays) {
        for (int i = 0; i < numArrays.length; i++) {
            for (int j = i + 1; j < numArrays.length; j++) {
                if (numArrays[i] < numArrays[j]) {
                    int temp = numArrays[i];
                    numArrays[i] = numArrays[j];
                    numArrays[j] = temp;
                }
            }
        }
        for (int a = 0; a < numArrays.length; a++) {
            System.out.print(numArrays[a]+",");
        }
    }
    public static void main (String[] args) {
        getAscending(new int[]{22,1,3,11,8,100,7,2,21,25,10});
        }

}