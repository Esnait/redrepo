package com.qa.CodeAnalysis.utils;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;


public class IOHandle {
	
	public static String path="Analyze";
	public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	public static DocumentContext jsonContext;
	
	public static List<Path> getJavaFiles(String FolderPath) throws IOException {
		
		return Files.walk(Paths.get(FolderPath))
                .filter(t -> t.toString().endsWith(".java"))
                .collect(Collectors.toList());
	}

	public static void logger_setup(String logFileName) {
		LogManager.getLogManager().reset();
		
		FileHandler fh = null;
		try {
			fh = new FileHandler(logFileName);
		} catch (SecurityException | IOException e) {
			logger.log(Level.SEVERE, "Logger Error", e);
		}
		
		System.setProperty("java.util.logging.SimpleFormatter.format",
	              "%5$s %n");
		
		fh.setFormatter(new SimpleFormatter());
		logger.addHandler(fh);
		
	}
	
	public static void getJsonConfig() throws IOException, ParseException {
				
		FileReader file = new FileReader("C:\\eclipse wk\\static-code-analysis\\src\\main\\java\\com\\qa\\CodeAnalysis\\Config\\Configuration.json");
		
		@SuppressWarnings("deprecation")
		JSONParser jparser = new JSONParser();
		Object jobj = jparser.parse(file);
		
		jsonContext = JsonPath.parse(jobj);				
		
	}
	
	public static void checkLogCalculation() {
		
		List<String> TotalRules = jsonContext.read("ruleConfiguration..ruleset..rule");
		List<String> RulesApplied = jsonContext.read("ruleConfiguration..ruleset[?(@.options.analyze=='yes')]..rule");
		
		logger.info("Calculating configurations....\n\nNumber of checks applied :: "+RulesApplied.size()+"/"+TotalRules.size());
		logger.info("Applied checks ::");
		for(String ra : RulesApplied)
			logger.info(ra);
		
		
		
	}
	
	
}
