package com.UserManager;

import java.io.FileInputStream;
import java.util.Properties;

public final class DBConfig {
    
    private Properties prop;

    public DBConfig(String path) {
        Path(path);
    }
    
    public void Path(String path) {
        prop = new Properties();
        try {
            prop.load(new FileInputStream(path));
        } catch (Exception e) {
            System.out.println("error en la ruta establesida!"+e.getMessage());
        }
    }
    
    public String getUser(){
        return prop.getProperty("BDUsuario");
    }
    
    public String getPassword() {
        return prop.getProperty("BDPassword");
    }
    
    public String getServer() {
        return prop.getProperty("BDServer");
    }
    
    public String getPort() {
        return prop.getProperty("BDPort");
    }
    
    public String getBaseDato() {
        return prop.getProperty("BDadm");
    }
    
    public String getDBCreate() {
        return prop.getProperty("createdb"); 
    }
    
    public String getDBTable(){
        return prop.getProperty("BDTable");
    }
}