package com.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionSql {
    
    private String path;
    private String user;
    private String password;
    private String dataBaseDefault;
    
    public ConectionSql(String path, String user,String password) {
        this.path = path;
        this.user = user;
        this.password = password;
    }

    public ConectionSql(DBConfig newDBConfig) {
        this.path = "jdbc:mysql://"+newDBConfig.getServer()+":"+newDBConfig.getPort();
        this.user = newDBConfig.getUser();
        this.password = newDBConfig.getPassword();
        this.dataBaseDefault = newDBConfig.getBaseDato();
    }
    
    public Connection connect() {
        try{
            return DriverManager.getConnection(path+"/"+dataBaseDefault, user, password);
        }catch (Exception e) {
            System.out.println("Unable to establish connection " + e.getMessage());
            e.getStackTrace();
        }
        return null;
    }
    
    public Connection connectDataBase(String dataBase) {
        try{
            return DriverManager.getConnection(path+"/"+dataBase, user, password);
        }catch (Exception e) {
            System.out.println("Unable to establish data Base connection " + e.getMessage());
            e.getStackTrace();
        }
        return null;
    }
    
    public Connection connectServerMysql(){
        try{
            return DriverManager.getConnection(path, user, password);
        }catch (Exception e) {
            System.out.println("Unable to establish server connection " + e.getMessage());
            e.getStackTrace();
        }
        return null;
    }
}