package genericUTilities;

import java.util.Date;

/*this class consist of reusable methods related to java
 * @author nidheesh m
 * 
 * 
 * 
 * */

public class JavaUTility {
	/*
	 * This method will retur the current date
	 * 
	 * 
	 * */
	
public  String getSystemDate()	{
	Date d=new Date();
	String[]dArr=d.toString().split("");
String currentdate=dArr[2]+"-"+dArr[1]+"-"+dArr[5]+" "+dArr[3].replace(":","-" );
	return currentdate;
	
	
}
	

}
