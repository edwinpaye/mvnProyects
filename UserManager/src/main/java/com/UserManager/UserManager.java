package com.UserManager;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserManager {

    private ConectionSql connectSql;
    private Connection conection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    //private ResultSetMetaData rsultado;
    private ArrayList<Usuario> lista;
    private ArrayList<String> campos;
    private ArrayList<String> data;
    private String dataBase;
    private String table;
    
    public UserManager(ConectionSql newConnectSql) {
        this.connectSql = newConnectSql;
    }

    public void setDataBase(String dataBase){
        this.dataBase = dataBase;
    }
    
    public void setTable(String table){
        this.table = table;
    }
    
    public void setTable(String dataBase, String table){
        this.dataBase = dataBase;
        this.table = table;
    }
    
    //este metodo es para mantener una coneccion con la ruta a la base de datos!
    public void conectionSql(){
        conection = connectSql.connectDataBase(dataBase);
    }
    
    //el metodo da ordenes consultas a la ase de datos
    public void Consultar(String query) {
        try {
            conectionSql();
            preparedStatement = conection.prepareStatement(query);
        } catch (Exception e) {
//            MessageEmergent("Fail Consultar(): "+e.getMessage());
        }
    }
    
    //el metodo cierra la ruta que hay entre las consultas y java
    public void ExitStatements() {
        try {
            preparedStatement.close();
        } catch (Exception e) {
//            MessageEmergent("Fail ExitStatements(): "+e.getMessage());
        }
    }
    
    //el metodo ejecuta la consulta establesida
    public void EjecutarConsulta() {
        try {
            Consultar("select * from "+table);
            this.resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
//            MessageEmergent("Fail EjecutarConsulta(): "+e.getMessage());
        }
    }
    
    public void EjecutarConsulta(String data) {
        try {
            Consultar("select * from "+table+" where "+data);
            this.resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
//            MessageEmergent("Fail EjecutarConsulta(): "+e.getMessage());
        }
    }
    
    //el metodo cierra coneccion con las consultas hechas a la base de datos
    public void ExitConection(){
        try {
            resultSet.close();
            preparedStatement.close();
            conection.close();
        } catch (Exception e) {
//            MessageEmergent("Fail ExitConection(): "+e.getMessage());
        }
    }
    
    //el metodo lista los resultados obtenidos 
    public ArrayList<Usuario> ListarResultado(String dataBase, String table) {     
        try {
            this.dataBase = dataBase;
            this.table = table;
            EjecutarConsulta();
            lista = new ArrayList<>();
            while (this.resultSet.next()) {
                lista.add(new Usuario(this.resultSet.getInt(campos.get(0)),this.resultSet.getString(campos.get(1)),
                this.resultSet.getString(campos.get(2)),this.resultSet.getInt(campos.get(3)),this.resultSet.getInt(campos.get(4))));
            }
            ExitConection();
        } catch (Exception e) {
//            MessageEmergent("Fail ListarResultado(): "+e.getLocalizedMessage());
        }
        return lista;
    }
    
    //el metodo muestra los nombres de campo en la base de datos
    public ArrayList<String> ListarEtiquetas(String dataBase, String table) {         
        try {
//            EjecutarConsulta();
//            rsultado = resultSet.getMetaData();
//            ExitConection();
            this.dataBase = dataBase;
            this.table = table;
//            Consultar("select * from "+table);
//            this.resultSet = preparedStatement.executeQuery();
            campos = new ArrayList<>();
            resultSet = connectSql.connectDataBase(dataBase).createStatement().executeQuery("desc "+table);
            while (this.resultSet.next()) {
                campos.add(resultSet.getString(1));
            }
//            return new String[]{rsultado.getColumnName(1), rsultado.getColumnName(2),
//            rsultado.getColumnName(3), rsultado.getColumnName(4), rsultado.getColumnName(5)};
        } catch (Exception e) {
//            MessageEmergent("Fail ListarEtiquetas(): "+e.getLocalizedMessage());
        }
        return campos;
    }
    
    public ResultSet getData(){
        return resultSet;
    }
    
    public ArrayList<Object[]> getDataArray(Object[] dimention){
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            resultSet = connectSql.connectDataBase(dataBase).createStatement().executeQuery("desc "+table);
            Object[] info;
            while (resultSet.next()) {
                campos.add(resultSet.getString(1));
                info = dimention;
                for (int i = 0; i < info.length; i++) {
                    info[i] = resultSet.getString(i+1);
                }
                data.add(info);
            }
        } catch (Exception e) {
//            MessageEmergent("Fail ListarEtiquetas(): "+e.getLocalizedMessage());
        }
        return data;
    }
    
    public ArrayList<Object[]> getDataArray(String dataBase, String table){
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            resultSet = connectSql.connectDataBase(dataBase).createStatement().executeQuery("desc "+table);
            Object[] info;
            while (resultSet.next()) {
                info = new Object[ListarEtiquetas(dataBase, table).toArray().length];
                for (int i = 0; i < info.length; i++) {
                    info[i] = resultSet.getString(i+1);
                }
                data.add(info);
            }
        } catch (Exception e) {
//            MessageEmergent("Fail ListarEtiquetas(): "+e.getLocalizedMessage());
        }
        return data;
    }
    
    public ResultSet getResultData(){
        try {
            resultSet.close();
            resultSet = connectSql.connectDataBase(dataBase).createStatement().executeQuery("desc "+table);
        } catch (Exception e) {
//            MessageEmergent("Fail getResultData(): "+e.getLocalizedMessage());
            return null;
        }
        return resultSet;
    }
    
    public void AddUser(String dataBase, String table, Usuario newUsuario) {
        try {
            this.dataBase = dataBase;
            Consultar("INSERT INTO "+table+" ("+campos.get(1)+", "+campos.get(2)+", "+campos.get(3)+", "+campos.get(4)+") VALUES (?,?,?,?)");
            preparedStatement.setString(1, newUsuario.getNombre());
            preparedStatement.setString(2, newUsuario.getApellido());
            preparedStatement.setInt(3, newUsuario.getEdad());
            preparedStatement.setInt(4, newUsuario.getTelefono());
            preparedStatement.executeUpdate();
            MessageEmergent("User added: "+newUsuario.getNombre()+" "+newUsuario.getApellido());
        } catch (Exception e) {
//            MessageEmergent("AddUser() fail "+e.getMessage());
        }
    } 

    public void RemoveUser(String dataBase, String table, int deleteUser){
        try {
            this.dataBase = dataBase;
            Consultar("DELETE FROM "+table+" where "+campos.get(0)+" = ?");
            preparedStatement.setInt(1, deleteUser);
            preparedStatement.executeUpdate();
            MessageEmergent("User Deleted");
        } catch (Exception e) {
//            MessageEmergent("RemoveUser() fail"+e.getMessage());
        }
    }

    public void EditUser(String dataBase, String table, Usuario newUsuario){
        try {
            this.dataBase = dataBase;
            Consultar("UPDATE "+table+" SET "+campos.get(1)+" = ?, "+campos.get(2)+" = ?, "+campos.get(3)+" = ?, "+campos.get(4)+" = ? WHERE "+campos.get(0)+" = ?");
            preparedStatement.setString(1, newUsuario.getNombre());
            preparedStatement.setString(2, newUsuario.getApellido());
            preparedStatement.setInt(3, newUsuario.getEdad());
            preparedStatement.setInt(4, newUsuario.getTelefono());
            preparedStatement.executeUpdate();
            MessageEmergent("Edit User: "+newUsuario.getNombre()+" "+newUsuario.getApellido());
        } catch (Exception e) {
            //MessageEmergent("EditUser() fail "+e.getMessage());
        }
    }
    
    public ArrayList<Usuario> search(String dataBase, String table, String data){
        try {
//            resultSet = connectSql.connect().createStatement().executeQuery("select * from "+table+" where "+data);
            this.dataBase = dataBase;
            this.table = table;
            EjecutarConsulta(data);
            lista = new ArrayList<>();
            while (this.resultSet.next()) {
                lista.add(new Usuario(this.resultSet.getInt(campos.get(0)),this.resultSet.getString(campos.get(1)),
                this.resultSet.getString(campos.get(2)),this.resultSet.getInt(campos.get(3)),this.resultSet.getInt(campos.get(4))));
            }
            ExitConection();
        } catch (Exception e) {
            //MessageEmergent("Fail search(): "+e.getLocalizedMessage());
        }
        return lista;
    }
    
    public ArrayList<String> getDataBases(){
        data = new ArrayList<>();
        try {
            resultSet = connectSql.connectServerMysql().createStatement().executeQuery("show databases");
            while (this.resultSet.next()) {
                data.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            //MessageEmergent("getDataBases fail"+e.getMessage());
        }
        return data;
    }
    
    public ArrayList<String> getTables(String dataBase){
        data.clear();
        try {
            resultSet = connectSql.connectDataBase(dataBase).createStatement().executeQuery("show tables");
            while (this.resultSet.next()) {
                data.add(resultSet.getString(1));
            }
        } catch (Exception e) {
            //MessageEmergent("getTables fail"+e.getMessage());
        }
        return data;
    }
    
    public void MessageEmergent(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}