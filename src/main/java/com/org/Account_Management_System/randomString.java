package com.org.Account_Management_System;

import java.util.Random;

public class randomString {
public static String getRandomString(int n) {
	int leftLimit = 97; // letter 'a'
	 int rightLimit = 122; // letter 'z'
	 int targetStringLength =n;
	 Random random = new Random();
   StringBuilder buffer = new StringBuilder(targetStringLength);
   for (int i = 0; i < targetStringLength; i++) {
       int randomLimitedInt = leftLimit + (int) 
         (random.nextFloat() * (rightLimit - leftLimit + 1));
       buffer.append((char) randomLimitedInt);
   }
   String generatedString = buffer.toString();
   return generatedString;
}
}
