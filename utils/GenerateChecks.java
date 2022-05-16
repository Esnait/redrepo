package com.qa.CodeAnalysis.utils;

import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTreeListener;


public class GenerateChecks {
	
	public HashMap<String, ParseTreeListener> ParseTrees() {
		
		HashMap<String, ParseTreeListener> ParseTreeMap = new HashMap<>();
		
		ParseTreeMap.put("Objects should be cleaned properly", null);
		ParseTreeMap.put("Check for hard coded Wait statements", null);
		ParseTreeMap.put("Check for any unnessary object creation", null);
		ParseTreeMap.put("Local variable should be declared with endline comment", null);
		ParseTreeMap.put("Medhod name should be in mixed-case(camel case) starts with a small character", new com.qa.CodeAnalysis.RuleDesign.CodeCoverage.MixedCaseMethodNameListener());
		ParseTreeMap.put("Public/Private keywords should be used only within a class", null);
		ParseTreeMap.put("Code Should be Properly indented", null);
		ParseTreeMap.put("Global variables should not be modified inside any function", null);
		ParseTreeMap.put("Check for any un-used package/library", null);
		ParseTreeMap.put("Check for any hard-coded data given to testcases", null);
		ParseTreeMap.put("Check for code duplication in testcases", null);
		ParseTreeMap.put("Check for proper handling of Null Pointer Exceptions", null);
		ParseTreeMap.put("Check for any validations using Assert/Verify", null);
		ParseTreeMap.put("Test classes name should follow by \"test\" word", null);
		ParseTreeMap.put("All Test classes should be inside \"test\" folder", null);
		ParseTreeMap.put("Check for all setup/connections should be inside @Before method", null);
		ParseTreeMap.put("Check for the drivers destroyed in @After method", null);
		ParseTreeMap.put("Avoid inter-dependency between different tests in a test suite", null);
		ParseTreeMap.put("Maximum characters in a variable name", new com.qa.CodeAnalysis.RuleDesign.CodeMaintainability.MaxCharinVarNameListener());
		ParseTreeMap.put("Maximum number of variables in a class", null);
		
		return ParseTreeMap;
		
	}

	
	public HashMap<String, Object> Objects() {
		
		HashMap<String, Object> ObjectMap = new HashMap<>();
		
		ObjectMap.put("Maximum lines in a scripts",new com.qa.CodeAnalysis.RuleDesign.CodeMaintainability.MaxLinesInFileObject(null));
		ObjectMap.put("Maximum characters in a single Line", new com.qa.CodeAnalysis.RuleDesign.CodeMaintainability.MaxCharinLineObject(null));

		return ObjectMap;
		
	}
	
	public void fetchTrueRules() {
		
		List<String> RulesApplied = IOHandle.jsonContext.read("ruleConfiguration..ruleset..rule");
		
		RulesApplied.size();
		
		
		
	}
	
	
	
}
