package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExelReader {
	public String path = "C:\\Users\\pudas\\SeleniumTutorials\\anotherTry\\src\\main\\java\\testData\\exlData.xlsx";
	public FileInputStream fi = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	public String getValueOfColumn(String colName, int rowNum) throws EncryptedDocumentException, IOException {
		
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheetAt(0);
		int col_num = 0;
		
		row = sheet.getRow(0);
		for (int i = 0; i < row.getLastCellNum(); i++) {
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim())) {
				col_num = i;
			}
		}
		row = sheet.getRow(rowNum - 1);
		cell = row.getCell(col_num);
		
		return cell.getStringCellValue();
	}

}
