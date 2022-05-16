package com.qa.CodeAnalysis.RuleDesign.CodeMaintainability;

import com.qa.CodeAnalysis.Antlr.JavaParserBaseListener;

public class MaxVarinClassListener extends JavaParserBaseListener{
	
//	public MaxVarinClass(Path javafile) throws IOException {
//		
//		CodePointCharStream inputStream = (CodePointCharStream) CharStreams.fromPath(javafile);
//		
//		JavaLexer JavaLexer = new JavaLexer(inputStream);
//		CommonTokenStream commonTokenStream = new CommonTokenStream(JavaLexer);
//		JavaParser javaParser = new JavaParser(commonTokenStream);	
//		ParseTree tree = javaParser.compilationUnit();
//		
//		MixedCaseMethodNameListener methodlistener = new MixedCaseMethodNameListener();
//		MaxCharinVarName maxcahrinvar = new 	MaxCharinVarName();		
//		
//		ParseTreeWalker walker = new ParseTreeWalker();
//		walker.walk(methodlistener, tree);
//		walker.walk(maxcahrinvar, tree);
//	}
}
