package utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.sql.Timestamp;

public class CommonUtils {

    public Select selectDropdown(WebElement element) {
        Select dropdown = new Select(element);
        return dropdown;
    }

    public String ExcelInput(int rowno, int colno, int sheetno, String fileName) throws Exception {
        String ss = null;
        File f = new File(fileName);

        FileInputStream FIS = new FileInputStream(f);
        XSSFWorkbook wb = new XSSFWorkbook(FIS);
        XSSFSheet s = wb.getSheetAt(sheetno);
        XSSFCell xc1 = s.getRow(rowno).getCell(colno);
        CellType ct = xc1.getCellTypeEnum();


        if (ct == CellType.STRING) {
            ss = xc1.getStringCellValue();
        } else if (ct == CellType.NUMERIC) {
            Long ss1 = (long) xc1.getNumericCellValue();
            ss = String.valueOf(ss1);
        }

        return ss;
    }

    public Map<String, Map<String, String>> getExcelDataMap(String fileName, String sheetName) throws Exception {
        Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String, String>>();

        File f = new File(fileName);

        FileInputStream FIS = new FileInputStream(f);
        XSSFWorkbook workbook = new XSSFWorkbook(FIS);
        XSSFSheet sheet = workbook.getSheet(sheetName);
        int lastRow = sheet.getLastRowNum();
        int lastcell = sheet.getRow(0).getLastCellNum() - 1;

        System.out.println("\n Last rownum is: " + lastRow);
        System.out.println("\n Last colnum is: " + lastcell);

        String tcIDexcel, key, value;

        for (int i = 1; i <= lastRow; i++) {

            //Get TC ID from Excel Cell as Key
            tcIDexcel = sheet.getRow(i).getCell(0).getStringCellValue().trim();
            System.out.println("\n TCID is: " + tcIDexcel);
            Map<String, String> dataMap = new HashMap<String, String>();

            for (int j = 1; j <= lastcell; j++) {
                key = sheet.getRow(0).getCell(j).getStringCellValue().trim();
                value = sheet.getRow(i).getCell(j, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue().trim();
                System.out.println("\n Key is: " + key);
                System.out.println("\n Value is: " + value);

                //Putting key & value in dataMap
                dataMap.put(key, value);
            }
            excelFileMap.put(tcIDexcel, dataMap);
        }
        return excelFileMap;
    }

    public static void takeSnapShot(WebDriver webdriver) throws Exception {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ts = Long.toString(timestamp.getTime());

        String fileWithPath = System.getProperty("user.dir") + "/target/screenshots/" + ts + ".png";

        TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(fileWithPath);
        FileUtils.copyFile(SrcFile, DestFile);
    }


}
