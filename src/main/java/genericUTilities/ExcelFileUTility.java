package genericUTilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/*
 * this class consist of reusable methods related to excel file
 * @author nidheesh m
 * 
 * 
 * */

public class ExcelFileUTility {
/*this method will read data from  given excel file and return the value to caller
 * @param sheetname
 * @param rownum
 * @param cellnum
 * @return value
 * @throws EncryptedDocumentException
 * @IOException
 * 
 * */
	
	public String readDataFromExcelFile(String Contacts,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		
	FileInputStream	fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");	
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet("Contacts");
	String data = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
	return data;
		
}
	
}
