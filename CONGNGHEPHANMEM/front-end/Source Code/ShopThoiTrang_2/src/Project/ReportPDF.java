/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import com.itextpdf.text.Element;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;

/**
 *
 * @author LLOST
 */
public class ReportPDF {
    FileOutputStream file = null;
    DefaultTableModel model;
    PdfPTable tbl;
    String columnNames[];
    float Tong = 0;
    
    public ReportPDF() throws DocumentException{

    }
    
    public void reportAll(JTable table, String columnNames[]) throws DocumentException{
        model = (DefaultTableModel) table.getModel();
        
        this.columnNames = columnNames;
        
        JFileChooser chosser = new JFileChooser();
        chosser.setDialogTitle("Report");
        int x = chosser.showSaveDialog(null);
        
        if(x == JFileChooser.APPROVE_OPTION){
            try {     
                Document doc = new Document();
                
                PdfWriter.getInstance(doc, new FileOutputStream(chosser.getSelectedFile()+".pdf"));
                
                doc.open();
                PdfPTable tbl = new PdfPTable(model.getColumnCount());
                for (int j = 0; j < columnNames.length; j++) {
                    tbl.addCell(model.getColumnName(j).toString());
                }
                for (int i = 0; i < model.getRowCount(); i++){
                    String data = new String();
                    
                    for (int j = 0; j < model.getColumnCount(); j++){
                        data = model.getValueAt(i, j).toString();
                        tbl.addCell(data);
                    }          
                }
                
                doc.add(tbl);
                doc.add(new Paragraph("\n\n Tổng cộng:............."+tinhTongCong(model)));
                doc.close();
                JOptionPane.showMessageDialog(null, "In thành công!");
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ReportPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }
    
        public float tinhTongCong(DefaultTableModel model)
    {
        float sum = 0;
        int columnNamePos = -1;
        for(int i = 0; i < model.getColumnCount(); ++i)
        {
            if(model.getColumnName(i).equals("Tổng tiền"))
            {
                columnNamePos = i;
                break;
            }
        }
        
        for(int i = 0; i < model.getRowCount(); ++i)
        {
            sum += Float.parseFloat(model.getValueAt(i, columnNamePos).toString());
        }
        
        return sum;
    }
    
//    public void reportHoaDon(JTable table, int k) throws DocumentException {
//        model = (DefaultTableModel) table.getModel();
//        
//        JFileChooser chosser = new JFileChooser();
//        chosser.setDialogTitle("Report");
//        int x = chosser.showSaveDialog(null);
//
//        if (x == JFileChooser.APPROVE_OPTION) {
//            try {
//                Document doc = new Document();
//                PdfWriter.getInstance(doc, new FileOutputStream(chosser.getSelectedFile() + ".pdf"));
//                doc.open();
//
//                Paragraph content = new Paragraph("Content:............");
//                Phrase content_info = new Phrase("Payment orders");
//                Paragraph maHD = new Paragraph("BillID:.............");;
//                Phrase maHD_info = new Phrase((String)model.getValueAt(k, 1));
//                
//                content.add(content_info);
//                maHD.add(maHD_info);
//                
//                doc.add(content);
//                doc.add(maHD);
//                doc.close();
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(ReportPDF.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
