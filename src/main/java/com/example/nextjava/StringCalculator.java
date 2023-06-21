package com.example.nextjava;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class StringCalculator {


    public int addMyAnswer(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isDigit(c) && (c - '0') < 0) {
                throw new RuntimeException();
            }

            if (Character.isDigit(c)) {
                result += (c - '0');
            }
        }

        return result;
    }

    public int add(String text) {
        String[] tokens;
        if (text == null || text.isEmpty()) {
            return 0;
        }

        if (text.length() == 1) {
            return Integer.parseInt(text);
        }

        //if (text.length() == 3 && text.charAt(1) == ',') { // 숫자가 1의자리가 아닐 수도 있음 ...
        if(text.contains(",")){
            tokens = text.split(",");
            return sum(tokens);
        }

        if (!Character.isDigit(text.charAt(0))) {

            tokens = matchCustomDelimeter(text);
            return sum(tokens);
        }

        tokens = text.split(",|:");
        return sum(tokens);
    }

    public String[] matchCustomDelimeter(String text){
        String[] tokens = new String[0];
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if(m.find()){
            String customDelimeter = m.group(1);
            tokens = m.group(2).split(customDelimeter);
        }
        return tokens;
    }

    public int sum(String[] tokens) {
        int result = 0;
        int[] intArr = new int[tokens.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(tokens[i]);
        }

        if (haveMinus(intArr)) {
            throw new RuntimeException();
        }

        for (int i = 0; i < intArr.length; i++) {
            result += intArr[i];
        }

        return result;
    }

    public boolean haveMinus(int[] intArr) {
        return IntStream.of(intArr).anyMatch(x -> x < 0);
    }

    public void pracMatcher() {
        String text = "//;\n1;2;3";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            System.out.println("group0 == " + m.group(0));
            System.out.println("group1 == " + m.group(1));
            System.out.println("group2 == " + m.group(2));
        } else {
            System.out.println("NOTHING TO FIND");
        }
    }

}
