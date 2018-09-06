package com.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionSql {
    private String path, user,password;
    
    public ConectionSql(String path,String user,String password) {
        this.path=path;
        this.user=user;
        this.password = password;
    }
    
    public Connection Connect() {
        try{

            return DriverManager.getConnection(path,this.user,this.password);
        }catch (Exception e) {
            System.out.println("Unable to establish connection " + e.getMessage());
            e.getStackTrace();
        }
        return null;
    }
//
}