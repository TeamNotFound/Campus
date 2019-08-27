package util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptUtil {

	public static String hashPsw(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public static boolean checkPs2(String password, String salt) {
		return BCrypt.checkpw(password, salt);
	}
}
