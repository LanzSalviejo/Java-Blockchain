// Program that generates the hash for the block

import java.security.MessageDigest;

import com.google.gson.GsonBuilder;

public class StringUtility {
	// Applies SHA-256 to a string and returns the result
	// SHA-256 is a hashing algorithim that converts strings unique hashes
	public static String applySHA256(String input) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			
			//Applies SHA-256 to our input,
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			
			StringBuffer hexString = new StringBuffer(); // Contains hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}//try
		catch(Exception e) {
			throw new RuntimeException(e);
		}//catch
	}//applySHA256
	
	//Short hand helper to turn Object into a json string
	public static String getJson(Object o) {
		return new GsonBuilder().setPrettyPrinting().create().toJson(o);
	}//getJson
	
	//Returns difficulty string target, to compare to hash. eg difficulty of 5 will return "00000"  
	public static String getDificultyString(int difficulty) {
		return new String(new char[difficulty]).replace('\0', '0');
	}//getDifficultyString
	
	
}//StringUtility
