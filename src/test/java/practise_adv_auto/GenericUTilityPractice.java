package practise_adv_auto;

import java.io.IOException;

import genericUTilities.ExcelFileUTility;
import genericUTilities.JavaUTility;
import genericUTilities.PropertyFileUtility;

public class GenericUTilityPractice {

public static void main(String[] args) throws IOException {
		
PropertyFileUtility putil=new PropertyFileUtility();
String value = putil.readDataFromPropertyFile("username");
System.out.println(value);
	
ExcelFileUTility u1=new ExcelFileUTility();
String data = u1.readDataFromExcelFile("Contacts", 1, 1);
System.out.println(data);

JavaUTility jutil=new JavaUTility();
String ans = jutil.getSystemDate();
System.out.println(ans);
}

}
