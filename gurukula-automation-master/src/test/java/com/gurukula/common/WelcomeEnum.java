/**
 * 
 */
package com.gurukula.common;

/**
 * @author AnujKumar
 *
 */
public enum WelcomeEnum {

	LOGIN_LINK("login"), REGISTER_LINK("Register a new account"), AUTHENTICATE("Authenticate"), REGISTER("Register");

	String val;

	private WelcomeEnum(String val) {
		this.val = val;
	}

	public String getVal() {
		return val;
	}
}
