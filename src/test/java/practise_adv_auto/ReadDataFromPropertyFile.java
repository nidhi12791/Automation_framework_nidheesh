package practise_adv_auto;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

public static void main(String[] args) throws IOException {
//step 1:open the document in java readable format
FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");

//step 2: create object of properties class from java.util
Properties pobj=new Properties();

//step 3:load the file input stream to properties class
pobj.load(fis);	

//step 4:provide key and read the value
String value =pobj.getProperty("abc");
System.out.println(value);
}

}
