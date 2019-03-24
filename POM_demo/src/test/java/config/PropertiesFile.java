package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	static Properties prop = new Properties();	
	
	public PropertiesFile(){
		
		String path = System.getProperty("user.dir");
		InputStream input = null;
		try {
			input = new FileInputStream(path+"/src/test/java/config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			
			e.printStackTrace();
		}		
	}
	
	public String getBrowser(){
		return prop.getProperty("browser");
	}
	
	public String getPostpaid_username(){
		return prop.getProperty("postpaid_username");
	}
	
	public String getPostpaid_password(){
		return prop.getProperty("postpaid_password");
	}
	
	public String getURL() {
		return prop.getProperty("URL");
	}

}
