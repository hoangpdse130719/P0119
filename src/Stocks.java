
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phamduchoang
 */
public class Stocks extends javax.swing.JFrame {

    /**
     * Creates new form Stocks
     */
    public Stocks() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnInsert = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnInsert.setText("Insert to DB");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Stock one", "No1-washington street", "11/05/2010", null},
                {"2", "Stock two", "372 cave town-001 Banks", "09/07/2011", null},
                {"3", "Stock three", "Nary angel-890 Number one", "13/05/2010", "Store dangerous"},
                {"4", "Stock four", "Twin tower-01 Main street", "04/07/2015", null},
                {"5", "Stock five", "Victory anniversary district", "08/03/2014", null}
            },
            new String [] {
                "StockID", "StockName", "Address", "DateAvailable", "Note"
            }
        ));
        jScrollPane2.setViewportView(tblStock);
        if (tblStock.getColumnModel().getColumnCount() > 0) {
            tblStock.getColumnModel().getColumn(1).setResizable(false);
            tblStock.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(btnInsert)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 510, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInsert, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            Vector<StockDTO> vec = new Vector();
            for (int i = 0; i < tblStock.getRowCount(); i++) {
                String id = (String) tblStock.getValueAt(i, 0);
                String name = (String) tblStock.getValueAt(i, 1);
                String address = (String) tblStock.getValueAt(i, 2);
                String date = (String) tblStock.getValueAt(i, 3);
                SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
                Date dates = formatter.parse(date);
                formatter.applyPattern("mm/dd/yyyy");
                date = formatter.format(dates);
                String note = (String) tblStock.getValueAt(i, 4);
                vec.add(new StockDTO(id, name, address, date, note));
            }
            StockDAO dao = new StockDAO();
            dao.insert(vec);
            JOptionPane.showMessageDialog(this, "Insert successful");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInsertActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Stocks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Stocks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInsert;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblStock;
    // End of variables declaration//GEN-END:variables
}































//try {
//            Vector<StockDTO> vec = new Vector();
//            for (int i = 0; i < tblStock.getRowCount(); i++) {
//                String id = (String) tblStock.getValueAt(i, 0);
//                String name = (String) tblStock.getValueAt(i, 1);
//                String address = (String) tblStock.getValueAt(i, 2);
//                String date = (String) tblStock.getValueAt(i, 3);
//                SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
//                Date dates = formatter.parse(date);
//                formatter.applyPattern("mm/dd/yyyy");
//                date = formatter.format(dates);
//                String note = (String) tblStock.getValueAt(i, 4);
//                vec.add(new StockDTO(id, name, address, date, note));
//            }
//            StockDAO dao = new StockDAO();
//            dao.insert(vec);
//            JOptionPane.showMessageDialog(this, "Insert successful");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }