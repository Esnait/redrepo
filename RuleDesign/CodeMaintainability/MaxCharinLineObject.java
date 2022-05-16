package com.qa.CodeAnalysis.RuleDesign.CodeMaintainability;

import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;

import com.qa.CodeAnalysis.Antlr.JavaParserBaseListener;
import com.qa.CodeAnalysis.utils.IOHandle;

public class MaxCharinLineObject extends JavaParserBaseListener{

	public MaxCharinLineObject(Path path) {

		long lines=0;
		int lineLength;
		try {
		      Scanner sc = new Scanner(path.toFile());

		      while(sc.hasNextLine()) {	
		    	  lines++;
		    	  lineLength = sc.nextLine().length();
		    	  if(lineLength > 82) 
		    		  Error.add("line: "+lines+" :: Maximum characters in a line should "
		    		  		+ "be less than 82");				
		      }
		      sc.close();
		    } catch (Exception e) {
		    	IOHandle.logger.log(Level.SEVERE, "Error in File handling", e);
		    }
	}
}
