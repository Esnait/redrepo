package com.qa.CodeAnalysis.RuleDesign.CodeMaintainability;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;

import com.qa.CodeAnalysis.Antlr.JavaParserBaseListener;
import com.qa.CodeAnalysis.utils.IOHandle;

public class MaxLinesInFileObject extends JavaParserBaseListener {

	public MaxLinesInFileObject(Path path) {
		
		long lines=0;
		try {
		      Scanner sc = new Scanner(path.toFile());

		      while(sc.hasNextLine()) {
		        sc.nextLine();
		        lines++;
		      }
		      		      
			if(lines>3000)  Error.add("Maximum lines in a script should be less than 3000");

		      sc.close();
		    } catch (Exception e) {
		    	IOHandle.logger.log(Level.SEVERE, "Error in File handling", e);
		    }
	}
}
