package practise_adv_auto;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
//STEP1: OPEN THE DOCMENT IN JAVA READABLE FORMAT	
FileInputStream	fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
//STEP2:CREATE A WORKBOOK
Workbook wb=WorkbookFactory.create(fis);
//STEP3:NAVIGATE TO REQUIRED SHEET OR //to access sheet
Sheet sh=wb.getSheet("Contacts");
//STEP4:NAVIGATE TO REQUIRED ROW
Row rw = sh.getRow(1);
//STEP5: NAVIGATE TO REQUIRED cell
Cell cl = rw.getCell(1);
//STEP6:CAPTURE THE DATA INSIDE THE CELL
String value=cl.getStringCellValue();
System.out.println(value);
//STEP7:close the workbook
wb.close();
	
	
	
	
	
}
}
