package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {

	// Load Properties File From Folder
	
	public static Properties config = 
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
	// Load objectRepo Data
	
	public static Properties objectRepo = 
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\config\\objectRepo.properties");
	
	// load test Data
	public static Properties testData = 
			loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\data\\testData.properties");

	public static Properties loadProperties(String path) {
		
		Properties prop = new Properties();
		// Stream for reading file
		try {
			FileInputStream stream = new FileInputStream(path);
			prop.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("Error Occured" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error Occured" + e.getMessage());
		}catch (NullPointerException e) {
			System.out.println("Error Occured" + e.getMessage());
		}
		
		
		return prop;
	}
}
