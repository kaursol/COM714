/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package solent_campers;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import solent_campers.Modal.Booking;
import solent_campers.Modal.camper_vans;
import solent_campers.Modal.camping_sites;

/**
 *
 * @author kaur
 */
public class BookingPanel extends javax.swing.JPanel {

    /**
     * Creates new form BookingPanel
     */CamperVanHelper cvh;
      CampingSiteHelper csh;
      public static int bookingid=0;
    public BookingPanel() {
        initComponents();
          cvh = new CamperVanHelper();
        csh = new CampingSiteHelper();
        fillVAnCombo();
        fillVanTAble();
        fillSiteTable();
        fillRegion();
    }
  public void fillRegion()
    {
         ArrayList<String> regions = csh.getAllRegion();

        for (int i = 0; i < regions.size(); i++) {
           
            cbRgion.addItem(regions.get(i));

        }
    }
    private void fillSiteTableBasedonRegion() {
        ArrayList<camping_sites> sitelist = csh.getSiteBasedonRegion(cbRgion.getSelectedItem().toString());
        
        String col[] = {"id", "Site Name", "Region"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (int i = 0; i < sitelist.size(); i++) {
            int id = sitelist.get(i).getCs_id();
            String name = sitelist.get(i).getCamping_sites();
            String region = sitelist.get(i).getRegion();

            Object[] data = {id, name, region};
            cbCSts.addItem(id);
            tableModel.addRow(data);

        }
        jTable2.setModel(tableModel);
    }
     private void fillSiteTable() {
        ArrayList<camping_sites> sitelist = csh.getAll();
        String col[] = {"id", "Site Name", "Region"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        for (int i = 0; i < sitelist.size(); i++) {
            int id = sitelist.get(i).getCs_id();
            String name = sitelist.get(i).getCamping_sites();
            String region = sitelist.get(i).getRegion();

            Object[] data = {id, name, region};

            tableModel.addRow(data);

        }
        jTable2.setModel(tableModel);
    }
 public void fillVAnCombo() {
        ArrayList<camper_vans> vanlist = cvh.getAll();

        for (int i = 0; i < vanlist.size(); i++) {
            int id = vanlist.get(i).getCv_id();
            cbVanID.addItem(id);

        }
    }
   private void fillVanTAble() {
       camper_vans van = cvh.getVan(Integer.parseInt(cbVanID.getSelectedItem().toString()));
        String col[] = {"id", "Car Type", "Status"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);
       
            int id = van.getCv_id();
            String type = van.getType();
            String sts = van.getStatus();

            Object[] data = {id, type, sts};

            tableModel.addRow(data);

        
        jTable1.setModel(tableModel);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbRgion = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDT = new javax.swing.JTextField();
        cbVanID = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnBook = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCustomeName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        cbCSts = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel5.setText("Seelct Camp Site :");

        cbRgion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbRgionItemStateChanged(evt);
            }
        });

        jLabel8.setText("Booking Date :");

        jLabel4.setText("Select Region :");

        cbVanID.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbVanIDItemStateChanged(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("i.e DD/MM/YYYY");

        jLabel3.setText("Select Van :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Selected Region - CampSite Detail");

        btnBook.setBackground(new java.awt.Color(204, 255, 204));
        btnBook.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Book Campsote Visit");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Selected Van Detail");

        jLabel7.setText("Customer Name : ");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        cbCSts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCStsItemStateChanged(evt);
            }
        });
        cbCSts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCStsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtDT)
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbRgion, 0, 376, Short.MAX_VALUE)
                                            .addComponent(cbVanID, 0, 376, Short.MAX_VALUE)
                                            .addComponent(cbCSts, 0, 376, Short.MAX_VALUE)
                                            .addComponent(txtCustomeName))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbVanID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbRgion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbCSts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtCustomeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBook, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                        .addGap(26, 26, 26)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbRgionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbRgionItemStateChanged
        // TODO add your handling code here:
        for(int i=0;i<cbCSts.getItemCount();i++)
        {
        cbCSts.removeItemAt(i);
        }
        fillSiteTableBasedonRegion();
    }//GEN-LAST:event_cbRgionItemStateChanged

    private void cbVanIDItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbVanIDItemStateChanged
        // TODO add your handling code here:
        fillVanTAble();
    }//GEN-LAST:event_cbVanIDItemStateChanged

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        BookingHelper bh = new BookingHelper();
        int csid = Integer.parseInt(cbCSts.getSelectedItem().toString());
        int cvid = Integer.parseInt(cbVanID.getSelectedItem().toString());
        String cn = txtCustomeName.getText();
        Date dt = new Date(txtDT.getText());
        bh.AddBooking(new Booking(bookingid++, cvid, csid, cn, dt));
//(bookingid,cvid,cn);
        camper_vans v = cvh.getVan(cvid);
        v.setStatus("Booked");
        JOptionPane.showMessageDialog(this, "Campsite Visit booked Succcessfully!!");
       txtCustomeName.setText(""); txtDT.setText("");
        
    }//GEN-LAST:event_btnBookActionPerformed

    private void cbCStsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCStsItemStateChanged
        // TODO add your handling code here:
        camping_sites sitelist = csh.getSite(Integer.parseInt(cbCSts.getSelectedItem().toString()));
        String col[] = {"id", "Site Name", "Region"};
        DefaultTableModel tableModel = new DefaultTableModel(col, 0);

        int id = sitelist.getCs_id();
        String name = sitelist.getCamping_sites();
        String region = sitelist.getRegion();

        Object[] data = {id, name, region};

        tableModel.addRow(data);


        jTable2.setModel(tableModel);
    }//GEN-LAST:event_cbCStsItemStateChanged

    private void cbCStsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCStsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCStsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JComboBox cbCSts;
    private javax.swing.JComboBox cbRgion;
    private javax.swing.JComboBox cbVanID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtCustomeName;
    private javax.swing.JTextField txtDT;
    // End of variables declaration//GEN-END:variables
}
