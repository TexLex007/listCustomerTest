package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public String getValueOf(String key) throws IOException {
		String path = "src\\main\\java\\config\\config.properties";
		FileInputStream fi = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fi);
		String value = prop.getProperty(key);
		return value;
	}
}