package com.example.nextjava;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {


    @Test
    public void calTest(){
        String str1 = "1,2";
        StringCalculator stringCalculator = new StringCalculator();

        assertEquals(3, stringCalculator.cal(str1));

        String str2 = "1,2:3";
        assertEquals(6, stringCalculator.cal(str2));

        String str3 = "//;\n1;2;3";
        assertEquals(6, stringCalculator.cal(str3));
    }

}
