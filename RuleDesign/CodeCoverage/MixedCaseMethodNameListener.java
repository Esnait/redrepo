package com.qa.CodeAnalysis.RuleDesign.CodeCoverage;

import java.util.regex.Pattern;

import org.antlr.v4.runtime.Token;

import com.qa.CodeAnalysis.Antlr.JavaParser;
import com.qa.CodeAnalysis.Antlr.JavaParserBaseListener;

public class MixedCaseMethodNameListener extends JavaParserBaseListener {
	
	@Override 
	public void enterMethodDeclaration(JavaParser.MethodDeclarationContext ctx) {
				
		Token token = ctx.identifier().getStart();
		String methodName = ctx.identifier().getText();
		
		boolean match = Pattern.matches("^[a-z]*|^[a-z]*[A-Z]*[a-z]*|^[a-z]*[A-z]*[0-9]*"
				+ "|^[a-z]*[A-z]*[0-9]*", methodName);
		
		if(! match)
			Error.add("line: "+token.getLine()+", "
				+ "col "+token.getCharPositionInLine() +" :: Method name "+methodName+" should be in "
						+ "mixedcase and first character must be in lower case eg, mIxedCaSe");
			
	}
}
