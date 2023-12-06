package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils{
public static FileInputStream fi;
public static FileOutputStream fo;
public static XSSFWorkbook wb;
public static XSSFSheet ws;
public static XSSFRow row;
public static XSSFCell cell;
public static int getRowCount(String xlFile, String xlSheet) throws IOException {
fi = new FileInputStream(xlFile);
wb = new XSSFWorkbook(fi);
ws = wb.getSheet(xlSheet);
int rowCount = ws.getLastRowNum();
wb.close();
fi.close();
return rowCount;
}
    public static int getCellCount(String xlFile, String xlSheet, int rowNum) throws IOException{
fi = new FileInputStream(xlFile);
wb = new XSSFWorkbook(fi);
ws = wb.getSheet(xlSheet);
row = ws.getRow(rowNum);
int columnCount = row.getLastCellNum();
wb.close();
fi.close();
return columnCount;
}
public static String getCellData(String xlFile, String xlSheet, int rowNum, int columnNum) throws IOException{
fi = new FileInputStream(xlFile);
wb = new XSSFWorkbook(fi);
ws = wb.getSheet(xlSheet);
row = ws.getRow(rowNum);
cell = row.getCell(columnNum);
String data;
try {
DataFormatter formatter = new DataFormatter();
data = formatter.formatCellValue(cell);
} catch (Exception e) {
data = "";
}
wb.close();
fi.close();
return data;
}
public static void setCellData(String xlFile, String xlSheet, int rowNum, int columnNum, String data) throws IOException {
fi = new FileInputStream(xlFile);
wb = new XSSFWorkbook(fi);
ws = wb.getSheet(xlSheet);
row = ws.getRow(rowNum);
cell = row.createCell(columnNum);
cell.setCellValue(data);
fo = new FileOutputStream(xlFile);
wb.write(fo);
wb.close();
fo.close();
fi.close();
}


/*
 * import java.io.FileInputStream; import java.io.FileOutputStream; import
 * java.io.IOException;
 * 
 * import org.apache.poi.ss.usermodel.CellStyle; import
 * org.apache.poi.ss.usermodel.DataFormatter; import
 * org.apache.poi.xssf.usermodel.XSSFCell; import
 * org.apache.poi.xssf.usermodel.XSSFRow; import
 * org.apache.poi.xssf.usermodel.XSSFSheet; import
 * org.apache.poi.xssf.usermodel.XSSFWorkbook;
 * 
 * public class XLUtility {
 * 
 * public FileInputStream fi; public FileOutputStream fo; public XSSFWorkbook
 * workbook; public XSSFSheet sheet; public XSSFRow row; public XSSFCell cell;
 * public CellStyle style; String path;
 * 
 * public XLUtility(String path) { this.path=path; }
 * 
 * 
 * public int getRowCount(String sheetname)throws IOException { fi=new
 * FileInputStream(path); //workbook=XSSFWorkbook(fi);
 * sheet=workbook.getSheet(sheetname); int rowcount=sheet.getLastRowNum();
 * fi.close(); return rowcount; } public int getCellCount(String sheetname,int
 * rownum)throws IOException { fi=new FileInputStream(path); workbook=new
 * XSSFWorkbook(fi); sheet=workbook.getSheet(sheetname);
 * row=sheet.getRow(rownum); int cellcount=row.getLastCellNum();
 * workbook.close(); fi.close(); return cellcount; }
 * 
 * public String getCellData( String sheetName,int rownum, int column)throws
 * IOException {
 * 
 * fi=new FileInputStream(path); workbook=new XSSFWorkbook(fi);
 * sheet=workbook.getSheet(sheetName); row=sheet.getRow(rownum);
 * cell=row.getCell(column);
 * 
 * 
 * DataFormatter formatter=new DataFormatter(); String data; return sheetName;
 */

}


