package com.example.nextjava;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {


    @Test
    public void calTest(){
        StringCalculator stringCalculator = new StringCalculator();



        String str1 = "1,2";
        assertEquals(3, stringCalculator.add(str1));

        String str2 = "1,2:3";
        assertEquals(6, stringCalculator.add(str2));

        String str3 = "//;\n1;2;3";
        assertEquals(6, stringCalculator.add(str3));

        String str4 = null;
        assertEquals(0, stringCalculator.add(str4));

        String str5 = " ";
        assertEquals(0, stringCalculator.add(str5));

        String str6 = "7";
        assertEquals(7, 7);


    }

    @Test
    public void matcherTest(){
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.pracMatcher();
    }
}
