package com.UserManager;

import java.util.ArrayList;

public class DataBaseSelector extends javax.swing.JFrame {

    private UserManager userManager;
    private ArrayList<String> dataBases;
    private ArrayList<String> tables;
    
    public DataBaseSelector(UserManager newUserManager) {
        this.userManager = newUserManager;
        initComponents();
    }

    public void setDataBases(){
        this.dataBases = userManager.getDataBases();
        jcbDataBase.setModel(new javax.swing.DefaultComboBoxModel<>(dataBases.toArray(new String[dataBases.size()])));

    }
    
    public void setTables(){
        this.tables = userManager.getTables();
        jcbTable.setModel(new javax.swing.DefaultComboBoxModel<>(tables.toArray(new String[tables.size()])));
    }
    
//    public void 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcbDataBase = new javax.swing.JComboBox<>();
        jcbTable = new javax.swing.JComboBox<>();
        btnSelectTable = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Data Base Selector");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 260, 40));

        jLabel2.setText("Data base:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        jLabel3.setText("Table:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jcbDataBase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDataBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 80, 140, -1));

        jcbTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 150, 140, -1));

        btnSelectTable.setText("Select Table");
        getContentPane().add(btnSelectTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSelectTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JComboBox<String> jcbDataBase;
    private javax.swing.JComboBox<String> jcbTable;
    // End of variables declaration//GEN-END:variables
}
