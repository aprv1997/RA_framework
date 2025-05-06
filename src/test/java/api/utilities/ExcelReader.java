package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelReader {

    private String path;
    private FileInputStream fi;
    private XSSFWorkbook workbook;
    private DataFormatter formatter;
    private boolean isWorkbookOpen = false;

    public ExcelReader(String path) {
        this.path = path;
        this.formatter = new DataFormatter();
    }

    // Open workbook once for repeated reads
    public void openWorkbook() throws IOException {
        if (!isWorkbookOpen) {
            fi = new FileInputStream(path);
            workbook = new XSSFWorkbook(fi);
            isWorkbookOpen = true;
        }
    }

    // Close workbook and stream
    public void closeWorkbook() throws IOException {
        if (isWorkbookOpen) {
            workbook.close();
            fi.close();
            isWorkbookOpen = false;
        }
    }

    // Get row count
    public int getRowCount(String sheetName) throws IOException {
        try (FileInputStream localFi = new FileInputStream(path);
             XSSFWorkbook localWorkbook = new XSSFWorkbook(localFi)) {

            XSSFSheet sheet = localWorkbook.getSheet(sheetName);
            return (sheet != null) ? sheet.getLastRowNum() : 0;
        }
    }

    // Get cell count for a row
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        try (FileInputStream localFi = new FileInputStream(path);
             XSSFWorkbook localWorkbook = new XSSFWorkbook(localFi)) {

            XSSFSheet sheet = localWorkbook.getSheet(sheetName);
            if (sheet == null) return 0;

            XSSFRow row = sheet.getRow(rowNum);
            return (row != null) ? row.getLastCellNum() : 0;
        }
    }

    // Get cell data using cached workbook (use with openWorkbook())
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        if (!isWorkbookOpen) openWorkbook(); // Ensure workbook is open

        XSSFSheet sheet = workbook.getSheet(sheetName);
        if (sheet == null) return "";

        XSSFRow row = sheet.getRow(rowNum);
        if (row == null) return "";

        XSSFCell cell = row.getCell(colNum);
        if (cell == null) return "";

        return formatter.formatCellValue(cell);
    }
}
