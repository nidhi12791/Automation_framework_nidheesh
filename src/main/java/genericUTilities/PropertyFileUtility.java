package genericUTilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
 * this class consist of reusable methods related to property file 
 * @nidheesh
 * 
 * 
 * 
 * */
public class PropertyFileUtility {	
	/*
	 * this method will read data from property file and return the value to the caller
	 * @parameter key
	 * @return value
	 * @throws IOException 
	 * */
	
public String readDataFromPropertyFile(String Key ) throws IOException {
	FileInputStream	fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	Properties p=new Properties();
	p.load(fis);
	String value=p.getProperty(Key);
	return value;	
}}


