/**
 * 
 */
package com.gurukula.common;

public enum AccountEnum {

	Settings("Settings"), Password("Password"), Sessions("Sessions"), Logout("Log out");
	String val;

	private AccountEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}

}
