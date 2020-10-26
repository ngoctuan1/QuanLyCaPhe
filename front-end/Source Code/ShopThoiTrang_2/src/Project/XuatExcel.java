/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author loith
 */
public class XuatExcel {

    File file;
    FileOutputStream outFile;
    String SheetName;
    XSSFCell cell;
    XSSFRow row;
    XSSFSheet sheet;
    XSSFWorkbook workbook = null;
    FileOutputStream excelFOU = null;
    BufferedOutputStream excelBOU = null;
    DefaultTableModel model = new DefaultTableModel();
    String columnNames[];

    public XuatExcel(JTable table, String columnNames[], String SheetName) throws IOException {

        this.SheetName = SheetName;
        
        model = (DefaultTableModel) table.getModel();
        
        this.columnNames = columnNames;

        TaoFileExcel();
    }

    private static XSSFCellStyle TaoStyleHeader(XSSFWorkbook workbook) {
        XSSFColor matteBlue = new XSSFColor(new java.awt.Color(14, 142, 233));
        XSSFColor white = new XSSFColor(new java.awt.Color(255, 255, 255));
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setColor(white);
        XSSFCellStyle style = workbook.createCellStyle();
        ((XSSFCellStyle) style).setFillBackgroundColor(matteBlue);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setFillForegroundColor(matteBlue);

        style.setFont(font);

        return style;
    }

    private XSSFCellStyle NumberStyle(XSSFWorkbook workbook) {
        XSSFCellStyle style = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat();
        style.setDataFormat(format.getFormat("#,##.0"));
        return style;

    }

    public void TaoFileExcel() throws IOException {
        workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(SheetName);

        JFileChooser choose = new JFileChooser();
        choose.setDialogTitle("Save as");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        choose.setFileFilter(fnef);
        int excelchooser = choose.showSaveDialog(null);
        
        if(excelchooser == JFileChooser.APPROVE_OPTION)
        {
            XSSFCellStyle style = TaoStyleHeader(workbook);
            XSSFCellStyle NumberStyle = NumberStyle(workbook);

            for (int i = 0; i < model.getRowCount(); i++) {
                row = sheet.createRow(i);
                for (int j = 0; j < columnNames.length; j++) {
                    cell = row.createCell(j);
                    cell.setCellValue(columnNames[j]);
                    cell.setCellStyle(style);
                }
            }

            for (int i = 0; i < model.getRowCount(); i++) {
                row = sheet.createRow(i+1);

                for (int j = 0; j < model.getColumnCount(); j++) {

                    cell = row.createCell(j);
                    
                    if (model.getValueAt(i, j) != null) 
                        cell.setCellValue(model.getValueAt(i, j).toString());
                    else cell.setCellValue("");
                    
                    sheet.autoSizeColumn(j);
                }
            }

            try {
                excelFOU = new FileOutputStream(choose.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                workbook.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Xuất thành công!");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception ex) {
                Logger.getLogger(ChiTietKMFrame.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }
                    if (workbook != null) {
                        workbook.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
        }
    }
}
