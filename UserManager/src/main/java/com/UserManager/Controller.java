package com.UserManager;

public class Controller {

    public Controller(){}
    
    private Controller getController(){
        return this;
    }

    public void start(UserManager newUserManager){

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DataBaseSelector(newUserManager, getController()).setVisible(true);
            }
        });
        
    }
    
    public void runEditionWindow(String newDataBase, String newTable, UserManager newUserManager){
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new EditionWindow(newUserManager, newDataBase, newTable).setVisible(true);
                }
            });            
    }
}