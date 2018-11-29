package MyExcel;

import Bean.Account;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 2017/7/13.
 */
public class ExcelReader {


    public ArrayList<Account> readXls(File file) throws Exception {
        InputStream is = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(is);
        Account account = null;
        ArrayList<Account> list = new ArrayList<Account>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
            Sheet sheet = wb.getSheetAt(numSheet);
            if (sheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if (row != null) {
                    Cell accountString = row.getCell(0);
                    Cell password = row.getCell(1);
                    account = new Account(getValue(accountString)
                            , getValue(password)

                    );
                    list.add(account);
                }
            }
        }
        return list;
    }


    @SuppressWarnings("static-access")
    private String getValue(Cell cell) {
        if (cell != null) {
            if (cell.getCellType() == CellType.BOOLEAN) {
                // 返回布尔类型的值
                return String.valueOf(cell.getBooleanCellValue());
            } else if (cell.getCellType() == CellType.NUMERIC) {
                // 返回数值类型的值
                return String.valueOf(cell.getNumericCellValue());
            } else {
                // 返回字符串类型的值
                return String.valueOf(cell.getStringCellValue());
            }
        } else {
            return "";
        }
    }
}
