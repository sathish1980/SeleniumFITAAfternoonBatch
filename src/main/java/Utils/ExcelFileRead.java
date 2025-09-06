package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

public class ExcelFileRead {
	
	String filePath = "C:\\Users\\DELL\\eclipse-workspace\\SeleniumFITAAfternoonBatch\\Input\\MakemyTrip.xlsx";
	Workbook workbook ;
	Object[][] value;
	public void ReadExcel(String sheetName) throws IOException
	{
		File F = new File(filePath);
		FileInputStream FS = new FileInputStream(F);
		if(filePath.endsWith(".xlsx"))
		{
		workbook =  new XSSFWorkbook(FS);
		}
		else
		{
		workbook =  new HSSFWorkbook(FS);
		}
		
		Sheet Wbsheet = workbook.getSheet(sheetName);
		//get totatl used Rows
		int totalRows = Wbsheet.getPhysicalNumberOfRows();
		Row row1 = Wbsheet.getRow(0);
		int usedColumns = row1.getLastCellNum();
		value=new Object[totalRows][usedColumns];
		for (int i=0;i<totalRows;i++)
		{
			Row row = Wbsheet.getRow(i);
			int usedColumn = row.getLastCellNum(); // get the total used column
			for(int j = 0; j<usedColumn;j++)
			{
				Cell eachCell = row.getCell(j);
				value[i][j] =ReadAsSuch(eachCell);
				System.out.println(ReadAsSuch(eachCell));
			}
		}
		
		FS.close();
	}
	
	public Object ReadAsSuch(Cell cellvalue)
	{
		if(cellvalue.getCellType().toString().equals("STRING"))
		{
			return cellvalue.getStringCellValue();
		}
		else if(cellvalue.getCellType().toString().equals("NUMERIC"))
		{
			/*DataFormatter Data =  new DataFormatter();
			return Data.formatCellValue(cellvalue);*/
			return cellvalue.getNumericCellValue();
		}
		return null;
	}
	
	public void printoutput()
	{
		//Object[][] value;
		System.out.println(value.length);
		for(int i=0;i<value.length;i++)
		{
			int coulumnSize= value[i].length;
			System.out.println("column size " +value[i].length);
			for(int j = 0;j<coulumnSize;j++)
			{
				System.out.println(value[i][j]);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelFileRead E = new ExcelFileRead();
		E.ReadExcel("Validsearch");
		E.printoutput();
	}

}
