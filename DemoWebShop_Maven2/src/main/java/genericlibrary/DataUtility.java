package genericlibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class DataUtility implements FrameWork_Constants{
	
	public String getDataFromProperties(String key) throws IOException
	{
		FileInputStream Fis = new FileInputStream(properties_path);
	    Properties pobj = new Properties();
	    pobj.load(Fis);
	    return pobj.getProperty(key);
	}    
		
	public String getDataFromExcel(String SheetName,int rownum,int cellNum) throws EncryptedDocumentException, IOException	
	{
		FileInputStream Fis = new FileInputStream(excel_path);
		Workbook book = WorkbookFactory.create(Fis);
		Sheet sh=book.getSheet(SheetName);
		return sh.getRow(rownum).getCell(cellNum).toString();
	}
	
	public static Object [][] getAllDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException
	
	{
		FileInputStream fis = new FileInputStream(excel_path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh1 = book.getSheet(sheetName);
		int lastRowNum = sh1.getPhysicalNumberOfRows();
		int lastcellNum = sh1.getRow(0).getPhysicalNumberOfCells();
		Object [][] arr = new Object[lastRowNum-1][lastcellNum];
		for(int i=1 ; i<lastRowNum ; i++)
		{
		for(int j=0 ; j<lastcellNum; j++)
		{
		arr[i-1][j]	= sh1.getRow(i).getCell(j).toString();
		}	
	}
	return arr;
	}
}

