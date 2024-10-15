package application;

/*
 * Class: CMSC 203 
 * Instructor: Huseyin Aygun
 * Description: Assignment 3
 * Due: 10/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: Anthony Le
*/

/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * Author: Farnaz Eivazi
 * Version: 7/16/2022
 */

public class CryptoManager 
{
	// lower bound
    private static final int LOWER_BOUND = ' '; 
    // upper bound
    private static final int UPPER_BOUND = '_'; 
    // number of valid characters
    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1; 

    /**
     * Encrypts a string using the Caesar Cipher.
     *
     * @param plainText the string to be encrypted
     * @param key the integer key for Caesar Cipher
     * @return the encrypted string
     */
    public static String caesarEncryption(String plainText, int key) 
    {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) 
        {
            char ch = plainText.charAt(i);
            if (ch < LOWER_BOUND || ch > UPPER_BOUND) 
            {
            	// invalid character
                return ""; 
            }
            int encryptedChar = ch + key;
            while (encryptedChar > UPPER_BOUND) 
            {
            	//valid bounds 
                encryptedChar -= RANGE; 
            }
            encrypted.append((char) encryptedChar);
        }

        return encrypted.toString();
    }

    /**
     * Decrypts a string using the Caesar Cipher.
     *
     * @param encryptedText the encrypted string
     * @param key the integer key for Caesar Cipher
     * @return the decrypted string
     */
    public static String caesarDecryption(String encryptedText, int key) 
    {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) 
        {
            char ch = encryptedText.charAt(i);
            if (ch < LOWER_BOUND || ch > UPPER_BOUND) 
            {
                return ""; // invalid character
            }
            int decryptedChar = ch - key;
            while (decryptedChar < LOWER_BOUND) 
            {
            	//valid bound
                decryptedChar += RANGE; 
            }
            decrypted.append((char) decryptedChar);
        }

        return decrypted.toString();
    }

    /**
     * Encrypts a string using the Bellaso Cipher.
     *
     * @param plainText the string to be encrypted
     * @param key the string key for Bellaso Cipher
     * @return the encrypted string
     */
    public static String bellasoEncryption(String plainText, String key) 
    {
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < plainText.length(); i++) 
        {
            char ch = plainText.charAt(i);
         // key characters
            char keyChar = key.charAt(i % key.length()); 
            if (ch < LOWER_BOUND || ch > UPPER_BOUND) 
            {
            	// invalid character
                return ""; 
            }
            int encryptedChar = ch + keyChar;
            while (encryptedChar > UPPER_BOUND) 
            {
            	// valid bound
                encryptedChar -= RANGE; 
            }
            encrypted.append((char) encryptedChar);
        }

        return encrypted.toString();
    }

    /**
     * Decrypts a string using the Bellaso Cipher.
     *
     * @param encryptedText the encrypted string
     * @param key the string key for Bellaso Cipher
     * @return the decrypted string
     */
    public static String bellasoDecryption(String encryptedText, String key) 
    {
        StringBuilder decrypted = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) 
        {
            char ch = encryptedText.charAt(i);
         // key characters
            char keyChar = key.charAt(i % key.length()); 
            if (ch < LOWER_BOUND || ch > UPPER_BOUND) 
            {
            	// invalid character
                return ""; 
            }
            int decryptedChar = ch - keyChar;
            while (decryptedChar < LOWER_BOUND) 
            {
            	// valid bound
                decryptedChar += RANGE; 
            }
            decrypted.append((char) decryptedChar);
        }

        return decrypted.toString();
    }
}

