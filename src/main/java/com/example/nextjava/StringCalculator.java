package com.example.nextjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {


	public int add(String str){
		if(str == null || str.isEmpty()){
			return 0;
		}

		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			char c  = str.charAt(i);

			if(Character.isDigit(c) && (c-'0')<0){
				throw new RuntimeException();
			}

			if(Character.isDigit(c)){
				result += (c-'0');
			}
		}

		return result;
	}

	public int addWithHint(String str){
		if(str == null || str.isEmpty()){
			return 0;
		}

		return 0;
	}

	public void pracMatcher(){
		String text = "//;\n1;2;3";
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

//		System.out.println(m.group(0));
		System.out.println(m.group(1));
		System.out.println(m.group(2));
	}

}
