package com.stratpoint.android;

import java.util.Comparator;

public class Student{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Name: " + name + "age: " + age;
    }
}

    class NameComparator implements Comparator<Student> {
        @Override
        public int compare (Student o1, Student o2){
            return o1.getName().compareTo(o2.getName());
        }
    }



