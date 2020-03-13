package com.stratpoint.android;

import java.util.*;

public class AgeComparator implements Comparator<Student> {
    public int compare(Student a1, Student a2){
        if (a1.getAge() == a2.getAge()){
            return 0;
        }else if (a1.getAge() > a2.getAge()){
            return 1;
        }else
            return -1;
    }
}