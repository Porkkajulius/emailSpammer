package com.spam.util;

import org.springframework.security.crypto.password.StandardPasswordEncoder;


public class HetuKryptaaja {
	
	public String crypted (String hetu) {
		
		StandardPasswordEncoder spe = new StandardPasswordEncoder();
		
		String c = spe.encode(hetu);
		
		return c;
	}

}