package com.stratpoint.android;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stratpoint.android.WarmUpExercise;
import com.stratpoint.android.Student;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    private String input;

    @Test
    public void testPalindrome_correctNum(){
        input = "12321";
        assertTrue(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPalindrome_correctWithSpaceNum(){
        input = "02 02";
        assertTrue(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPalindrome_correctLetter(){
        input = "racecar";
        assertTrue(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPalindrome_correctWithSpaceLetter(){
        input = "Stella won   no wallets";
        assertTrue(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPalindrome_incorrect(){
        input = "21";
        assertFalse(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPalindrome_incorrectSym(){
        input = "12-=1";
        assertFalse(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPalindrome_incorrectLetters(){
        input = "121";
        assertFalse(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPalindrome_emptyString(){
        input = "";
        assertFalse(WarmUpExercise.isPalindrome(input));
    }

    @Test
    public void testPrime_notPrime(){
        input = "12";
        assertFalse(WarmUpExercise.isPrime(input));
    }
    @Test
    public void testPrime_emptyString(){
        input = "";
        assertFalse(WarmUpExercise.isPrime(input));
    }

    @Test
    public void testPrime_aPrime(){
        input = "2";
        assertTrue(WarmUpExercise.isPrime(input));
    }

    @Test
    public void testPrime_aLetter(){
        input = "A";
        assertFalse(WarmUpExercise.isPrime(input));
    }
    @Test
    public void testPrime_withLetter(){
        input = "45A";
        assertFalse(WarmUpExercise.isPrime(input));
    }

    @Test
    public void testPrime_aSymbol(){
        input = "-";
        assertFalse(WarmUpExercise.isPrime(input));
    }

    @Test
    public void testPrime_withSymbol(){
        input = "-5";
        assertFalse(WarmUpExercise.isPrime(input));
    }

    @Test
    public void testList(){
        List<Student> students = Arrays.asList(new Student("brooke", 13),new Student("daisy", 14), new Student("minnie", 12));
    }


    public class Student{
        String name;
        int age;

        public Student(String name, int age){
            this.name = name;
            this.age = age;
        }

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
    }
}