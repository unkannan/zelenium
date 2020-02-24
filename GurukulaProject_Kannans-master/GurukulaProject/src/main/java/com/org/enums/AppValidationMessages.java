package com.org.enums;

public class AppValidationMessages {
	
	//password
	public static final String FivecharslengthWarningMessageForPasswordstr="Your password is required to be at least 5 characters.";
	public static final String MoreThanFiftycharslengthWarningMessageForPasswordstr="Your password cannot be longer than 50 characters.";
	public static final String Passwordrequiredstr="Your password is required.";
	
	//confirmPassword
	public static final String ConfirmPasswordrequiredstr="Your confirmation password is required.";
	public static final String FivecharslengthWarningMessageForConfirmPasswordstr="Your confirmation password is required to be at least 5 characters.";
	public static final String 	MoreThanFiftycharslengthWarningMessageForConfirmPasswordstr="Your confirmation password cannot be longer than 50 characters.";
	 
	//Text used to enter in fields
	public static final String MaxCharsStr="safdsfsfdsfsdfsfsfsfsfsddddasfdsfsdfsdfsdfsdfsdfsfsfsfsdafsafs";
	public static final String NoCharStr="";
	public static final String MinCharStr="saf";
	public static final String SpecialChar="@";
	
	//Login
	public static final String MoreThanFiftycharslengthWarningMessageForLoginstr="Your Login cannot be longer than 50 characters.";	
	public static final String LoginRquiredStr="Your login is required.";
	public static final String specialCharsCheckStr="Your login can only contain lower-case letters and digits.";
	
	//ResetPassword
public static final String EmailIDUsedtoRegsterstr="Enter the e-mail address you used to register";
public static final String EmailIDisntRegiseredstr="E-Mail address isn't registered!";
public static final String ResetPasswordTitle="Reset your password";
public static final String InvalidEmailidErrorMessageExpected="Your e-mail is invalid.";
public static final String InvalidEmailid5charsErrorMessageExpected="Your e-mail is required to be at least 5 characters.";
public static final String InvalidEmailid50charsErrorMessageExpected="Your e-mail cannot be longer than 50 characters.";
public static final String EmailidRequireErrorMessageExpected="Your e-mail is required.";
	
	//Generic Strings
	public static final String FiftyCharsCheck="50chars";
	public static final String specialCharsCheck="specialCharsCheck";
	public static final String NoTextEntry="NoTextEntry";
	public static final String MinCharCheck="MinCharCheck";
	
	//Registration Functionality Validation messages
	public static final String LoginNameAlreadyRegisteredElementStr="Login name already registered!";
	public static final String RegistrationfailedEleStr="Registration failed!";
	public static final String RegistrationSuccessEleStr="Registration Success!";
	public static final String ExistingUser="ExistingUser";
	public static final String SuccessUser="Success";
	
	public static final String PasswordConfirmationMatchTextStr="The password and its confirmation do not match!";
	public static final String SettingPagetitle="User settings for [";
	public static final String SettingsSavedMsg = "Settings saved!";
	public static final String StaffsPagetitle = "Staffs";
	public static final String CreateorEditStaffpopuptitle = "Create or edit a Staff";
	
	//Staff
	public static final String BranchesPagetitle = "Branches";
	public static final String MoreThanFiftycharslengthWarningMessageForStaffNameStr="This field cannot be longer than 50 characters.";
	
	public static final String firstnameRequiredMsgStr="Your first name is required.";
	public static final String lastnameRequiredMsgStr="Your last name is required.";
	public static final String FivecharslengthWarningMessageForEmailstr="Your e-mail is required to be at least 5 characters.";
	public static final String InvalidEmailidMessagestr="Your e-mail is invalid.";
	public static final String EmailRequiredMsgStr = "Your e-mail is required.";
	
	//Branch
	public static final String CreateorEditBranchpopupStr="Create or edit a Branch";
	public static final String BranchDetailTitleStr="Branch";
	public static final String NewBranchNameTextfieldValidationMsgfieldRequiredstr="This field is required.";
	public static final String Maxtwentytwocharlengthvalidationstr="This field cannot be longer than 20 characters.";
	
	//public static final String NewBranchNameTextfieldValidationMsgfieldRequiredstr = null;
	public static final String minimumcharlengthvalidationstr="This field is required to be at least 5 characters.";
	//public static final String minimumtwocharlengthvalidationstr="This field is required to be at least 2 characters.";
	public static final String minimumtwocharlengthvalidationstr="This field is required to be at least 2 characters.";
	
	
	public static final String PatternfollowedTextFieldvalidationstr ="This field should follow pattern ^[A-Z0-9]*$.";
	public static final String MintwoCharStr = "7";
}