package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private Workbook workbook;
	private Sheet sheet;
	private String filePath;

	public ExcelUtils(String excelPath, String sheetName) throws IOException {
		this.filePath = excelPath;
		FileInputStream fis = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		if (sheet == null) {
			throw new IllegalArgumentException("Sheet \"" + sheetName + "\" not found!");
		}
	}

	public int getRowCount() {
		return sheet.getLastRowNum();
	}

	public int getColumnCount(int rowNum) {
		Row row = sheet.getRow(rowNum);
		return row != null ? row.getLastCellNum() : 0;
	}

	public String getCellData(int rowNum, int colNum) {
		Cell cell = sheet.getRow(rowNum).getCell(colNum);
		if (cell == null)
			return "";

		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(cell);
	}

	public void setCellData(int rowNum, int colNum, String value) throws IOException {
		Row row = sheet.getRow(rowNum);
		if (row == null)
			row = sheet.createRow(rowNum);

		Cell cell = row.getCell(colNum);
		if (cell == null)
			cell = row.createCell(colNum);

		cell.setCellValue(value);

		FileOutputStream fos = new FileOutputStream(filePath);
		workbook.write(fos);
		fos.close();
	}

	public void close() throws IOException {
		workbook.close();
	}
	
	
	
	
}
