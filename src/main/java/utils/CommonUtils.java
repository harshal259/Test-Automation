package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CommonUtils {
	
	public Select selectDropdown(WebElement s1)
	{
		Select ss = new Select(s1);
		
		return ss;
		
	}
	
	public String ExcelInput(int rowno, int colno, int sheetno, String fileName) throws Exception{
		String ss = null;
		File f = new File(fileName);

		 FileInputStream FIS = new FileInputStream(f);
		 XSSFWorkbook wb  = new XSSFWorkbook(FIS);
		 XSSFSheet s = wb.getSheetAt(sheetno);
		 XSSFCell xc1 = s.getRow(rowno).getCell(colno);
		 CellType ct = xc1.getCellTypeEnum();
		 
		 
		 if(ct == CellType.STRING)
		 {
		  ss = xc1.getStringCellValue();}
		 
		 else if (ct == CellType.NUMERIC)
		 {
			 Long ss1 = (long) xc1.getNumericCellValue();
			  ss = String.valueOf(ss1);
		 }
		 
		return ss;
	}
	
	
}
