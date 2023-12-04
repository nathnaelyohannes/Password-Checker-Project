import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() throws LengthException {
		
		try {
            assertFalse (PasswordCheckerUtility.isValidPassword("abc"));
            assertTrue (PasswordCheckerUtility.isValidPassword("abcdef"));
            
        } 
		
		catch (LengthException e) {
            assertEquals ( "The password must be at least 6 characters long" , e.getMessage());
            
        } 
		
		catch (Exception e) {
            fail (e.getMessage());
        }
    }

	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha() throws NoUpperAlphaException{
		try {
            assertFalse (PasswordCheckerUtility.isValidPassword("mynameis1"));
            assertTrue (PasswordCheckerUtility.isValidPassword("Mynameis2"));
        } 
		
		catch (NoUpperAlphaException e) {
            assertEquals ("INVALID: Password has no uppercase.", e.getMessage());
        } 
		
		catch (Exception e) {
            fail (e.getMessage());
        }
    }

	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha() throws NoLowerAlphaException
	{
		try {
            assertFalse (PasswordCheckerUtility.isValidPassword("MYNAMEIS1"));
            assertTrue (PasswordCheckerUtility.isValidPassword("MyNameIs2"));
        } 
		
		catch (NoLowerAlphaException e) {
            assertEquals ("The password must contain at least one lowercase alphabetic character", e.getMessage());
        } 
		
		catch (Exception e) {
            fail (e.getMessage());
        }
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
            assertTrue (PasswordCheckerUtility.isWeakPassword("Haha"));
            assertFalse (PasswordCheckerUtility.isWeakPassword("Mynameis"));
        } 
		
		catch (WeakPasswordException e) {
            assertEquals ("INVALID: Password is weak.", e.getMessage());
        } 
		
		catch (Exception e) {
            fail (e.getMessage());
        }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
            assertFalse (PasswordCheckerUtility.isValidPassword("password111"));
            assertTrue (PasswordCheckerUtility.isValidPassword("ValidPassword2"));
        } 
		
		catch (InvalidSequenceException e) {
            assertEquals ("INVALID: Password contains more than two of the same characters in sequence.", e.getMessage());
        } 
		
		catch (Exception e) {
            fail (e.getMessage());
        }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
            assertFalse (PasswordCheckerUtility.isValidPassword("MyNameIS"));
            assertTrue (PasswordCheckerUtility.isValidPassword("MyNameIS251"));
        } 
		
		catch (NoDigitException e) {
            assertEquals ("INVALID: Password has no digits", e.getMessage());
        } 
		
		catch (Exception e) {
            fail (e.getMessage());
        }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
            assertTrue(PasswordCheckerUtility.isValidPassword("ValidPassword1$"));
        } 
		
		catch (Exception e) {
            fail(e.getMessage());
        }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords = new ArrayList<>();
        passwords.add("a1A#b1Bc1Cd1D");
        passwords.add("334455BB#");
        passwords.add("Im2cool4u#");
        passwords.add("george2ZZZ#");
        passwords.add("4Sale#");
        passwords.add("bertha22");
        passwords.add("4wardMarch#");

        ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);

        assertEquals("The password must be at least 6 characters long", invalidPasswords.get(0));
        assertEquals("INVALID: Password has no uppercase.", invalidPasswords.get(1));
        assertEquals("The password must contain at least one lowercase alphabetic character", invalidPasswords.get(2));
        assertEquals("INVALID: Password is weak.", invalidPasswords.get(3));
        assertEquals("INVALID: Password has two of the same characters in sequence.", invalidPasswords.get(4));
        assertEquals("INVALID: Password has no digits", invalidPasswords.get(5));
        assertEquals("Passwords do not match", invalidPasswords.get(6));
	}
	
}