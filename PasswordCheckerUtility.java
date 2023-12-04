import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PasswordCheckerUtility {

	public static void main(String[] args)
	{
		

	}
	
	public static boolean isValidPassword(String passwordString) 
			throws LengthException,
                   NoDigitException,
                   NoUpperAlphaException,
                   NoLowerAlphaException,
                   InvalidSequenceException, 
                   NoSpecialCharacterException,
                   UnmatchedException,
                   WeakPasswordException
           
                   {
		if (passwordString.length() < 6) 
		{
			throw new LengthException("The password must be at least 6 characters long");
			
		}else if (!(passwordString.matches(".*\\d.*"))) 
		{
			throw new NoDigitException("INVALID: Password has no digits");
				
		}else if (!(passwordString.matches(".*[A-Z].*"))) 
		{
			throw new NoUpperAlphaException("INVALID: Password has no uppercase.");
		
		}else if (!(passwordString.matches(".*[a-z].*"))) 
		{
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		
		}
		else if (!(passwordString.matches(".*[$&+,:;=\\\\?@#|/'<>.^*()%!-].*"))) 
		{
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		
		}
		else if(NoSameCharInSequence(passwordString)) {
			
			throw new InvalidSequenceException("INVALID: Password contains more than two of the same characters in sequence.");
		}
		else if(!(passwordString.matches(passwordString))) {
			throw new UnmatchedException("Passwords do not match");
		}
		else if(!(passwordString.length() > 9 && passwordString.length() < 6 )) {
			
			throw new WeakPasswordException("INVALID: Password is weak.");
		}
			
		else {
			return true;
		}
	}
		
	

	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		if(password.length() > 9 && password.length() < 6) {
			return false;
			
		}
		else {
			throw new WeakPasswordException("INVALID: Password is weak.");
		}
		
		
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for(String password : passwords) {
			
			try {
				if(!isValidPassword(password));
				invalidPasswords.add(passwords + "INVALID Password");
			}
			
			catch(LengthException e) {
				invalidPasswords.add(passwords + " " + e.getMessage());
			}
			catch(NoUpperAlphaException e) {
			invalidPasswords.add(passwords + " " + e.getMessage());
			
			
		}	catch(NoLowerAlphaException e) {
			invalidPasswords.add(passwords + " " + e.getMessage());
			
		}	catch(NoDigitException e) {
			invalidPasswords.add(passwords + " " + e.getMessage());
			
		}	catch(NoSpecialCharacterException e) {
			invalidPasswords.add(passwords + " " + e.getMessage());
			
		}	catch(InvalidSequenceException e) {
			invalidPasswords.add(passwords + " " + e.getMessage());
		}
			catch(UnmatchedException e) {
			invalidPasswords.add(passwords + " " + e.getMessage());
		}
			catch(WeakPasswordException e) {
			invalidPasswords.add(passwords + " " + e.getMessage());
			}
			
		}
		return invalidPasswords;
		
		
	}



	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		
		if(!(password.equals(passwordConfirm))){
			
			throw new UnmatchedException("Passwords do not match");
		}
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		
		if(passwordConfirm.equals(password)) {
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public static boolean hasBetweenSixAndNineChars(String password) {
		
		if(password.length() < 6 && password.length() > 9) {
			
			return false;
		}
		
		else {
			
			return true;
		}
	}
	
	public static boolean hasDigit(String password) throws NoDigitException {
		
		if(!(password.matches(".*\\d.*"))) {
			
			throw new NoDigitException("INVALID: Password has no digits");
		}
		
		else {
			
			return true;
		}
	}
	
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
		
		if(!(password.matches(".*[a-z].*"))) {
			
			throw new NoLowerAlphaException("The password must contain at least one lowercase alphabetic character");
		}
		
		else {
			
			return true;
		}
	}
	
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		
		if(!(password.matches(".*[$&+,:;=\\\\?@#|/'<>.^*()%!-].*"))) {
			
			throw new NoSpecialCharacterException("The password must contain at least one special character");
		}
		
		else {
			
			return true;
		}
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
		
		if(!(password.matches(".*[A-Z].*"))){
			
			throw new NoUpperAlphaException("INVALID: Password has no uppercase.");
		}
			return true;
		}
	
	public static boolean isValidLength(String password) throws LengthException {
		
		if(password.length() >= 6 ) {
			return true;
		}
		
		else {
			
			throw new LengthException("The password must be at least 6 characters long");
		}
	}
	
	
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException{
		
		char prevChar = '\0';
		int sequenceCount = 1;
		for(char currentChar : password.toCharArray()) {
			if(currentChar == prevChar) {
				sequenceCount++;
				if(sequenceCount > 2) {
					throw new InvalidSequenceException("INVALID: Password contains more than two of the same characters in sequence.");
					
				}
			}
			else {
				
				sequenceCount = 1;
				
			}
			
			prevChar = currentChar;
			
		
		}
		return false;}}

