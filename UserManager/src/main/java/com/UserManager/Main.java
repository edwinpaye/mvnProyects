package com.UserManager;

public class Main 
{
    public static void main(String[] args) {

        new Controller().start(new UserManager(new ConectionSql(new DBConfig("./config/dbconfig.properties"))));
        
    }
}