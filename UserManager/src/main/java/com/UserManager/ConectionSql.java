package com.UserManager;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionSql {
    
    private String path, user, password, table;
    private DBConfig dBConfig;
    
    public ConectionSql(String path, String table,String user,String password) {
        this.path = path;
        this.user = user;
        this.password = password;
        this.table = table;
    }
    
    public String getTable(){
        System.out.println("funciona"+table);
        return table;
    }
    
    public ConectionSql(DBConfig newDBConfig) {
        this.dBConfig = newDBConfig;
        this.path = "jdbc:mysql://"+dBConfig.getServer()+":"+dBConfig.getPort()+"/"+dBConfig.getBaseDato();
        this.user = newDBConfig.getUser();
        this.password = newDBConfig.getPassword();
        this.table = newDBConfig.getDBTable();
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
    
    public Connection serverMysql(){
        try{
            return DriverManager.getConnection("jdbc:mysql://"+dBConfig.getServer()+":"+dBConfig.getPort(),this.user,this.password);
        }catch (Exception e) {
            System.out.println("Unable to establish connection " + e.getMessage());
            e.getStackTrace();
        }
        return null;
    }
}