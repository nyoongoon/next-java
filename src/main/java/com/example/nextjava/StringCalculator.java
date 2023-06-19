package com.example.nextjava;
public class StringCalculator {

	public static void main(String[] args) {

	}
	public int cal(String str){
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

}
