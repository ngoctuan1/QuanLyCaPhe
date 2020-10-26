/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author LLOST
 */
public class nhapExcel {

    File excelFile;
    FileInputStream excelFIS = null;
    BufferedInputStream excelBIS = null;
    XSSFWorkbook workbook = null;
    DefaultTableModel modelBefore;
    DefaultTableModel model = new DefaultTableModel();
    JTable table;

    public nhapExcel(JTable table) {
        modelBefore = (DefaultTableModel) table.getModel();
    }

    public DefaultTableModel importExcel() {

        JFileChooser chosser = new JFileChooser();
        chosser.setDialogTitle("Select excel file");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        chosser.setFileFilter(fnef);
        
        int excelChosser = chosser.showOpenDialog(null);
        if (excelChosser == JFileChooser.APPROVE_OPTION) {
            Vector header = new Vector();
            for(int i = 0; i < modelBefore.getColumnCount(); ++i)
            {
                header.add(modelBefore.getColumnName(i));
            }
            if (model.getRowCount() == 0) {
                model = new DefaultTableModel(header, 0);
            }
            
            try {  
                excelFile = chosser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                workbook = new XSSFWorkbook(excelBIS);
                XSSFSheet Sheet = workbook.getSheetAt(0);

                for (int row = 1; row <= Sheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = Sheet.getRow(row);
                    Vector modelRow = new Vector();
                    
                    for(int i = 0; i < modelBefore.getColumnCount(); ++i)
                    {
                        XSSFCell cell = excelRow.getCell(i);
                        
                        modelRow.add(cell.getStringCellValue());
                    }

                    model.addRow(modelRow);
                    
                }
                JOptionPane.showMessageDialog(null, "Import Successfully!");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (workbook != null) {
                        workbook.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
        return model;
    }
}
