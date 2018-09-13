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
    }
    
    public void setTables(){
        this.tables = userManager.getTables();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
