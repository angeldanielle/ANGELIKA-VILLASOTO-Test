package com.stratpoint.android;

import java.util.ArrayList;
import java.util.Collections;

public class WarmUpExercise {

    public static boolean isPalindrome(String str){
        int aPalindrome = 1;
        //if string does not include anything from A-z, 0-9 or *space* is not a palindrome
        if (str.matches("[^A-z0-9_ ]")) {
            aPalindrome = 0;
        }else {
            //sets string to lower case and replaces *space* with ""
            str = str.toLowerCase().replaceAll("\\s", "");
            int countTop = 0, countBottom = str.length() - 1;
            while (countTop < countBottom) {
                if (str.charAt(countTop) != str.charAt(countBottom)) {
                    aPalindrome = 0;
                }
                countTop++;
                countBottom--;
                aPalindrome = 1;
            }
        }
        if (aPalindrome == 0){
            return false;
        }else{
            return true;
        }

    }

    public void sortStudentListByName(ArrayList<Student> students){
        Collections.sort(students, new NameComparator());
    }

    // Complete the function
    public void sortStudentListByAge(ArrayList<Student> students){
        Collections.sort(students, new AgeComparator());
    }

    public static boolean isPrime(String str){
        int aPrime = 1;
        //of string does not have any digits from 0-9 then it is not a number therefore not a prime number
        if (!str.matches("[0-9]")) {
            aPrime = 0;
        }else{
            //parses the string to interger
            int num = Integer.parseInt(str);
            for (int count = 2 ; count <= num/2 ; ++count){
                if(num % count == 0){
                    aPrime = 1;
                    break;
                }
                aPrime = 1;
            }
        }
        if (aPrime == 0)
            return false;
        else
            return true;
    }
}
