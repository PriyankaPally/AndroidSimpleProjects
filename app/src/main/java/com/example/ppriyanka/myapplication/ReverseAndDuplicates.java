package com.example.ppriyanka.myapplication;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseAndDuplicates {

    public static void main(String args[]) {
        String sName,strWithoutSpace;
        Scanner nameScanner = new Scanner(System.in);
        System.out.println("Enter name");
        sName = nameScanner.nextLine();
        System.out.println("Name is " + sName);
        Map<String, Integer> duplicatesArray = new HashMap<>();

        strWithoutSpace = sName.replaceAll(" ", "");


        StringBuilder revDupBuilder=new StringBuilder();

        for (int i = strWithoutSpace.length()-1; i >=0; i--) {

            String st=strWithoutSpace.substring(i, i+1);

            Integer value = duplicatesArray.get(st);
            if (duplicatesArray.get(st) == null) {
                duplicatesArray.put(st, 0);
            } else {
                value++;
                duplicatesArray.put(st, value);
            }

            if (revDupBuilder.indexOf(st)==-1) {
                revDupBuilder.append(st);
            }

        }

        System.out.println(revDupBuilder);
        for (Map.Entry<String, Integer> duplicateValue: duplicatesArray.entrySet()){
            if(duplicateValue.getValue()>0){
                System.out.println("" + duplicateValue.getKey() + "\t" + duplicateValue.getValue());
            }
        }
    }
}
