package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {
	
	
	/**
	 * This method is used to fetch/read data from Excel Sheet and return the value to caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellum
	 * @throws Throwable
	 * @author mamta
	 * @throws Throwable 
	 * @throws  
	 */
	public String getExcelData(String sheetName,int rowNum,int cellNum) throws  Throwable
	{
		FileInputStream fis1=new FileInputStream("./src/test/resources/VtigerSScenarioData.xlsx");
		
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		
		Cell cell = row.getCell(cellNum);
		String ExcelData= cell.getStringCellValue();
		return ExcelData;
		
		// or return book.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();		
	}
	
	public String getExcelDataUsingDataFormatter(String sheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes=new FileInputStream(IConstantUtility.excelFilepath);
		Workbook book = WorkbookFactory.create(fes);
		Sheet sheet = book.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		 DataFormatter format = new  DataFormatter();
		String ExcelData= format.formatCellValue(cell);
		return ExcelData;
	}
	
	/**
	 * This method will write data into excel file
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param value
	 * @throws Throwable
	 */
	public void writeDatatoExcel(String sheetName, int rowNum,int cellNum,String value) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelFilepath);
		Workbook wb= WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
		
		FileOutputStream fos= new FileOutputStream(IConstantUtility.excelFilepath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method will read multiple data from excel sheet and ghas to given to the data provider
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMultipleData(String SheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstantUtility.excelFilepath);
		Workbook wb= WorkbookFactory.create(fis);
		
		 Sheet sh = wb.getSheet(SheetName);
		 int lastRow=sh.getLastRowNum();
		 int lastCell=sh.getRow(0).getLastCellNum();
		 
		 Object[][]obj=new Object[lastRow][lastCell];
		 for (int i=0;i<lastRow;i++)
		 {
			 for(int j=0;j<lastCell;j++)
			 {
				 obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			 }
		 }
		 return obj;
	}
				 
		
	}
	
	
	
	
	
	
	
	
	
	
	
	


