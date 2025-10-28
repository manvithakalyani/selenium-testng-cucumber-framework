package utils;

import java.util.Random;

public class RandomDataGenerator {
	 private static final String EMAIL_DOMAIN = "@example.com";
	    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    private static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

	    private static Random random = new Random();

	    public static String getRandomFirstName() {
	        return generateRandomString(6);  // Example length 6
	    }

	    public static String getRandomLastName() {
	        return generateRandomString(8);  // Example length 8
	    }

	    public static String getRandomEmail() {
	        return generateRandomString(8).toLowerCase() + EMAIL_DOMAIN;
	    }

	    public static String getRandomPassword() {
	        // Example password pattern: 10 chars alphanumeric
	        return generateRandomAlphanumeric(10);
	    }

	    private static String generateRandomString(int length) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(ALPHABET.length());
	            sb.append(ALPHABET.charAt(index));
	        }
	        return sb.toString();
	    }
	    public static String getRandomGender() {
	        return random.nextBoolean() ? "Male" : "Female";
	    }

	    private static String generateRandomAlphanumeric(int length) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(ALPHANUMERIC.length());
	            sb.append(ALPHANUMERIC.charAt(index));
	        }
	        return sb.toString();
	    }
}
