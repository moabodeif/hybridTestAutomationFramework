package base;

import data.LoadProperties;

/**
 * It's used to Constans Variables
 * 
 *
 */

public class Constants {

	//Config
	public static String broswerName = LoadProperties.config.getProperty("broswer");
	public static String url = LoadProperties.config.getProperty("url");
	public static String searchKeyword = LoadProperties.config.getProperty("searchKeyword");
	
	//Home Page
	public static String textBarlocator = LoadProperties.objectRepo.getProperty("textBar_name");
	public static String searchSuggestionslocator = LoadProperties.objectRepo.getProperty("searchSuggestions_xpath");
	public static String pageNumber2locator = LoadProperties.objectRepo.getProperty("pageNumber_xpath");
	
	//Second Page
	public static String suggestionResultslocator2 = LoadProperties.objectRepo.getProperty("suggestionResultsPage2_xpath");
	public static String pageNumber3locator = LoadProperties.objectRepo.getProperty("pageNumber3_xpath");
	
	//Third Page
	public static String suggestionResultslocator3 = LoadProperties.objectRepo.getProperty("suggestionResultsPage3_xpath");

	//Paths
	public static String configPath = LoadProperties.config.getProperty("configPropertiesFilePath");
	public static String objectRepositoryPath = LoadProperties.config.getProperty("objectRepositoryFilePath");
	public static String chromePath = LoadProperties.config.getProperty("chromeDriverPath");
	public static String firefoxPath = LoadProperties.config.getProperty("firefoxDriverPath");
	public static String iePath = LoadProperties.config.getProperty("ieDriverPath");
	public static String reportPath = LoadProperties.config.getProperty("reportPath");

	//Keywords
	public static String chrome = LoadProperties.config.getProperty("chrome");
	public static String firefox = LoadProperties.config.getProperty("firefox");
	public static String ie = LoadProperties.config.getProperty("ie");
	public static String node = LoadProperties.config.getProperty("node");
	public static String downloadPath = System.getProperty("user.dir")+LoadProperties.config.getProperty("downloadPath");
	public static String searchBarElement = LoadProperties.config.getProperty("searchBarElement");
	public static String pageNumber2 = LoadProperties.config.getProperty("pageNumber2");
	public static String pageNumber3 = LoadProperties.config.getProperty("pageNumber3");
}
