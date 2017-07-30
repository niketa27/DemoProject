package dataProvider;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelDataProvider()
	{
		try
		{
		 File src= new File("./ApplicationTestData/AppData.xlsx");
		 FileInputStream stream = new FileInputStream(src);
		 wb = new XSSFWorkbook(stream);
		 
		}
		catch(Exception e)
		{
			System.out.println("Unable to Load excel Sheet");
			System.out.println(e.getMessage());
		}
	}
	public String getData(int sheetno, int row, int cell)
	{
		sheet= wb.getSheetAt(sheetno);
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}
	
	public String getData(String sheetname, int row, int cell)
	{
		sheet= wb.getSheet(sheetname);
		
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}


}
