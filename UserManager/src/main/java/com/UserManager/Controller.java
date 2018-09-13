package com.UserManager;

public class Controller {

    public Controller(){}

    public void start(UserManager newUserManager){

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBaseSelector(newUserManager).setVisible(true);
            }
        });
        
//        if (newUserManager.getConnectSql().getDataBase() != null && newUserManager.getConnectSql().getTable() != null) {
//            java.awt.EventQueue.invokeLater(new Runnable() {
//                public void run() {
//                    new EditionWindow(newUserManager).setVisible(true);
//                }
//            });    
//        }
        
    }
}