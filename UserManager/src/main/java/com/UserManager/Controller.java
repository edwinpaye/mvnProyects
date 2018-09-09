package com.UserManager;

public class Controller {

    public Controller(){}

    public void start(UserManager newUserManager){
//        EditionWindow editionWindow = new EditionWindow(new UserManager(newConectionSql));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditionWindow(newUserManager).setVisible(true);
            }
        });
    }
}