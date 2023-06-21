package com.example.nextjava;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    public StringCalculator cal;
    @BeforeEach
    public void setup(){
        cal = new StringCalculator();
    }

    @Test
    public void add_null_또는_빈문자(){
        assertEquals(0, cal.add(null));
        assertEquals(0, cal.add(""));
    }


    @Test
    public void matcherTest(){
        StringCalculator stringCalculator = new StringCalculator();
        stringCalculator.pracMatcher();
    }

    @Test
    public void split(){
        assertArrayEquals(new String[]{"1"}, "1".split(","));
        assertArrayEquals(new String[]{"1","2"}, "1,2".split(","));
    }
}
