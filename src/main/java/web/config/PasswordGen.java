package web.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGen {
	public static void main(String[] args) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPass = bCryptPasswordEncoder.encode("admin");
		
		System.out.print(encodedPass);
	}
}
