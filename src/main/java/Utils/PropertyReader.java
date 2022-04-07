package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	public static void main(String[] args) throws IOException {

	}
	
	public String readProperty(String key) throws IOException {
		String propFileName = "application.properties";
		 Properties p=new Properties(); 
		 InputStream is = getClass().getClassLoader().getResourceAsStream(propFileName);
		 if(is != null) {
			 p.load(is);
		 }
		 else {
			 throw new FileNotFoundException("property file " +propFileName + " not found in classpath" );
		 }
		  return p.getProperty(key);
		  
		    
	}

}
