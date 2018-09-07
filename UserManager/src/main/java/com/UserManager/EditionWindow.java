package com.UserManager;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EditionWindow extends javax.swing.JFrame {

    private ArrayList<Usuario> userList;
    private UserManager userManager;
    private String[] etiquetas;
    
    public EditionWindow(UserManager newUserManager) {
        userManager = newUserManager;
        etiquetas = userManager.ListarEtiquetas();
        initComponents();
    }
    
    private Object[][] getInformation(ArrayList<Usuario> newUserList){
        Object[][] listOfInformation = new Object[newUserList.size()][etiquetas.length];
        for (int i = 0; i < newUserList.size(); i++) {
            listOfInformation[i][0] = newUserList.get(i).getId_user();
            listOfInformation[i][1] = newUserList.get(i).getNombre();
            listOfInformation[i][2] = newUserList.get(i).getApellido();
            listOfInformation[i][3] = newUserList.get(i).getEdad();
            listOfInformation[i][4] = newUserList.get(i).getTelefono();
        }
        return listOfInformation;
    }
    
    public void setDataTable(ArrayList<Usuario> newUserList){
        userList = newUserList;
        jTable1.setModel(new javax.swing.table.DefaultTableModel(getInformation(newUserList), etiquetas));
    }
    
    public void enableButtons(boolean enable){
        btnUserList.setEnabled(enable);
        btnExit.setEnabled(enable);
        btnAddUser.setEnabled(enable);
        btnDeleteUser.setEnabled(enable);
        btnSearchUser.setEnabled(enable);
        btnEditUser.setEnabled(enable);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUserList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblTitle = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnAddUser = new javax.swing.JButton();
        btnDeleteUser = new javax.swing.JButton();
        btnSearchUser = new javax.swing.JButton();
        btnEditUser = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnUserList.setText("User List");
        btnUserList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserListActionPerformed(evt);
            }
        });
        getContentPane().add(btnUserList, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 317, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 62, 530, 237));

        lblTitle.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        lblTitle.setText("Edition Window");
        getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 15, -1, -1));

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        getContentPane().add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 13, -1, -1));

        btnAddUser.setText("Add User");
        btnAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 317, -1, -1));

        btnDeleteUser.setText("Delete User");
        btnDeleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(211, 317, -1, -1));

        btnSearchUser.setText("Search User");
        btnSearchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnSearchUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        btnEditUser.setText("Edit User");
        btnEditUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditUserActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 317, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    public EditionWindow getWindow(){
        return this;
    }
    
    private void btnSearchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchUserActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataEntryWindow(userManager, getWindow()).setVisible(true);
            }
        });
    }//GEN-LAST:event_btnSearchUserActionPerformed

    private void btnAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddUserWindow(userManager).setVisible(true);
            }
        });
    }//GEN-LAST:event_btnAddUserActionPerformed

    private void btnUserListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserListActionPerformed
        setDataTable(userManager.ListarResultado());
    }//GEN-LAST:event_btnUserListActionPerformed

    private void btnDeleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteUserActionPerformed
        if (jTable1.getSelectedRow() > -1 && JOptionPane.showConfirmDialog(null, "Confirm deleted?", "Confirm deleted", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
            userManager.RemoveUser(userList.get(jTable1.getSelectedRow()).getId_user());
            setDataTable(userManager.ListarResultado());
        }
    }//GEN-LAST:event_btnDeleteUserActionPerformed

    private void btnEditUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditUserActionPerformed
        if (jTable1.getSelectedRow() > -1) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new EditUserWindow(userManager, userList.get(jTable1.getSelectedRow())).setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_btnEditUserActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddUser;
    private javax.swing.JButton btnDeleteUser;
    private javax.swing.JButton btnEditUser;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSearchUser;
    private javax.swing.JButton btnUserList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
