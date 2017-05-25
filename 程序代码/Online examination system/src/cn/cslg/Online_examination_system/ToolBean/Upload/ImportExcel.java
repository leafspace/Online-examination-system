package cn.cslg.Online_examination_system.ToolBean.Upload;

import java.io.File;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by Administrator on 2017/5/25.
 * LastEdit: 2017-5-25
 * Contact me:
 *     Phone: 18852923073
 *     E-mail: 18852923073@163.com
 * 来自网络
 *      http://www.cnblogs.com/wwzyy/p/5962076.html
 */
public class ImportExcel {
    private int[] totalRows = null;                                                                //总行数
    private int[] totalCells = null;                                                               //总列数
    private int totalSheets = 0;                                                                   //总表数
    private ArrayList<List<List<String>>> sheets = null;                                           //表格数据
    private String errorInfo;                                                                      //错误信息

    public ImportExcel() {
    }


    public int getTotalRows(int index) {
        return totalRows[index];
    }

    public int getTotalCells(int index) {
        return totalCells[index];
    }

    public int getTotalSheets() {
        return totalSheets;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    private boolean validateExcel(String filePath) {
        /** 检查文件名是否为空或者是否是Excel格式的文件 */
        if (filePath == null
                || !(WDWUtil.isExcel2003(filePath) || WDWUtil
                .isExcel2007(filePath))) {
            errorInfo = "文件名不是excel格式";
            return false;
        }
        /** 检查文件是否存在 */
        File file = new File(filePath);
        if (file == null || !file.exists()) {
            errorInfo = "文件不存在";
            return false;
        }
        return true;
    }

    public List<List<String>> read(String filePath) {
        List<List<String>> dataList = new ArrayList<List<String>>();
        InputStream inputStream = null;
        try {
            /** 验证文件是否合法 */
            if (!validateExcel(filePath)) {
                System.out.println(errorInfo);
                return null;
            }
            /** 判断文件的类型，是2003还是2007 */
            boolean isExcel2003 = true;
            if (WDWUtil.isExcel2007(filePath)) {
                isExcel2003 = false;
            }
            /** 调用本类提供的根据流读取的方法 */
            File file = new File(filePath);
            inputStream = new FileInputStream(file);

            Workbook workbook = read(inputStream, isExcel2003);

            for(int i = 0; i < this.totalSheets; ++i) {
                dataList = read(workbook, i);
                this.sheets.add(dataList);
            }
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    inputStream = null;
                    e.printStackTrace();
                }
            }
        }
        /** 返回最后读取的结果 */
        return dataList;
    }


    public Workbook read(InputStream inputStream, boolean isExcel2003) {
        Workbook workbook = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            if (isExcel2003) {
                workbook = new HSSFWorkbook(inputStream);
            } else {
                workbook = new XSSFWorkbook(inputStream);
            }
            this.totalSheets = workbook.getNumberOfSheets();
            this.totalRows = new int[this.totalSheets];
            this.totalCells = new int[this.totalSheets];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }


    private List<List<String>> read(Workbook wb, int index) {
        List<List<String>> dataLst = new ArrayList<List<String>>();
        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(index);
        /** 得到Excel的行数 */
        this.totalRows[index] = sheet.getPhysicalNumberOfRows();
        /** 得到Excel的列数 */
        if (this.totalRows[index] >= 1 && sheet.getRow(0) != null) {
            this.totalCells[index] = sheet.getRow(0).getPhysicalNumberOfCells();
        }
        /** 循环Excel的行 */
        for (int r = 0; r < this.totalRows[index]; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            List<String> rowLst = new ArrayList<String>();
            /** 循环Excel的列 */
            for (int c = 0; c < this.getTotalCells(index); c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (null != cell) {
                    // 以下是判断数据的类型
                    switch (cell.getCellType()) {
                        case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                            cellValue = cell.getNumericCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_STRING: // 字符串
                            cellValue = cell.getStringCellValue();
                            break;
                        case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
                            cellValue = cell.getBooleanCellValue() + "";
                            break;
                        case HSSFCell.CELL_TYPE_FORMULA: // 公式
                            cellValue = cell.getCellFormula() + "";
                            break;
                        case HSSFCell.CELL_TYPE_BLANK: // 空值
                            cellValue = "";
                            break;
                        case HSSFCell.CELL_TYPE_ERROR: // 故障
                            cellValue = "非法字符";
                            break;
                        default:
                            cellValue = "未知类型";
                            break;
                    }
                }
                rowLst.add(cellValue);
            }
            /** 保存第r行的第c列 */
            dataLst.add(rowLst);
        }
        return dataLst;
    }

    public boolean checkOver(int sheeets, int rows, int cells) {
        if(sheeets >= this.totalSheets | sheeets < 0 |
                rows >= this.totalRows[sheeets] | rows < 0 |
                cells >= this.totalCells[sheeets] | cells < 0) {
            return false;
        } else {
            return true;
        }
    }

    private String getSheetsData(List<List<String>> list, int rows, int cells) {
        if (list != null) {
            return list.get(rows).get(cells);
        }
        return null;
    }

    public String getSheetsData(int sheeets, int rows, int cells) {
        if(!checkOver(sheeets, rows, cells)) {
            return null;
        }
        return this.getSheetsData(this.sheets.get(sheeets), rows, cells);
    }
}

class WDWUtil {
    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }
    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }
}