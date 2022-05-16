package com.qa.CodeAnalysis;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.qa.CodeAnalysis.Antlr.JavaLexer;
import com.qa.CodeAnalysis.Antlr.JavaParser;
import com.qa.CodeAnalysis.Antlr.JavaParserBaseListener;
import com.qa.CodeAnalysis.RuleDesign.CodeCoverage.MixedCaseMethodNameListener;
import com.qa.CodeAnalysis.RuleDesign.CodeMaintainability.MaxCharinVarNameListener;
import com.qa.CodeAnalysis.RuleDesign.CodeMaintainability.MaxCharinLineObject;
import com.qa.CodeAnalysis.utils.IOHandle;

import net.minidev.json.parser.ParseException;


public class App {
	
	public static void walkTree(Path javaFile, ParseTreeListener node) throws IOException {
		
		CodePointCharStream inputStream = (CodePointCharStream) CharStreams.fromPath(javaFile);
		
		JavaLexer JavaLexer = new JavaLexer(inputStream);
		CommonTokenStream commonTokenStream = new CommonTokenStream(JavaLexer);
		JavaParser javaParser = new JavaParser(commonTokenStream);	
		ParseTree tree = javaParser.compilationUnit();

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(node, tree);		
		
	}
	
	public static void main(String[] args) throws IOException, ParseException {
		
		IOHandle.getJsonConfig();
				
		List<Path> javaFiles;
		
		if(args.length > 0) IOHandle.logger_setup(args[1]);
		
		else IOHandle.logger_setup("mylogger.log");
		
		IOHandle.checkLogCalculation();
		
		long start = System.currentTimeMillis();
		
		IOHandle.logger.info("\nCollecting Java Files...");
		
		if(args.length != 0) javaFiles = IOHandle.getJavaFiles(args[0]);
		
		else javaFiles = IOHandle.getJavaFiles("C:/eclipse wk/CRAFT_Maven");
		
		long end = System.currentTimeMillis();
		
		IOHandle.logger.info("Collected :: "+javaFiles.size()+" Java files in "+(end-start)+" milliseconds");
		
		IOHandle.logger.info("\nStarting Analysis...");
		
		long Analysisstart = System.currentTimeMillis();
				
		for(Path javaFile : javaFiles) {
			IOHandle.path = javaFile.toString();	
			
			MixedCaseMethodNameListener methodlistener = new MixedCaseMethodNameListener();
			MaxCharinVarNameListener maxcahrinvar = new MaxCharinVarNameListener();		
			
			walkTree(javaFile, methodlistener);
			walkTree(javaFile, maxcahrinvar);
						
			new MaxCharinLineObject(javaFile);	
			
			if(JavaParserBaseListener.Error.size()!=0) {
				IOHandle.logger.info("\n"+IOHandle.path);
				
				for(String e : JavaParserBaseListener.Error)
					IOHandle.logger.info(e);
				
				JavaParserBaseListener.Error = new ArrayList<>();;
			}
			
		}
		
		long Analysisend = System.currentTimeMillis();
		
		IOHandle.logger.info("\nAnalysis Completed in "+(Analysisend-Analysisstart) +" milliseconds");
		
		System.out.println("Log file generated successfully");
	}

}










