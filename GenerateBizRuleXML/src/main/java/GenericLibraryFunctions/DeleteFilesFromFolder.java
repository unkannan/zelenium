package GenericLibraryFunctions;

import java.io.File;

public class DeleteFilesFromFolder {
	public void DeleteExistingBizRuleFiles(String Dir) {
		File dir = new File(Dir);    
		for (File file: dir.listFiles())
		        file.delete();
	}

}
