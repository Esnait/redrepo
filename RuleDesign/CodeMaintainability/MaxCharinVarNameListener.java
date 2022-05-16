package com.qa.CodeAnalysis.RuleDesign.CodeMaintainability;

import org.antlr.v4.runtime.Token;

import com.qa.CodeAnalysis.Antlr.JavaParser;
import com.qa.CodeAnalysis.Antlr.JavaParserBaseListener;

public class MaxCharinVarNameListener extends JavaParserBaseListener {
		
	@Override 
	public void enterVariableDeclaratorId(JavaParser.VariableDeclaratorIdContext ctx) {
				
		Token token = ctx.identifier().getStart();
		String VariableName = ctx.getText();
								
		if(VariableName.length() > 32) Error.add("line: "+token.getLine()+", "
				+ "col "+token.getCharPositionInLine() +" :: Characters in variable "+VariableName+
				" should be less than 32");
	
	}
	
}
