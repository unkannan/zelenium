package GenericLibraryFunctions;

public class ModifyValueInStringContent {
	 private String ModifyValue(String Content, String ModifyValue) {
		 Content=Content.replaceAll("E0001_P_VETADR_A_H", ModifyValue);
			return Content.trim();
	}
}
