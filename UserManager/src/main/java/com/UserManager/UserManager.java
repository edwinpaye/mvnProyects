package com.UserManager;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UserManager {
    
    private ConectionSql connectSql;
    private Connection conection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private ResultSetMetaData rsultado;
    private ArrayList<Usuario> lista;
    
    public UserManager(ConectionSql connectSql) {
        this.connectSql=connectSql;
    }
    
    //este metodo es para mantener una coneccion con la ruta a la base de datos!
    public void conectionSql(){
        conection = connectSql.Connect();
    }
    
    //el metodo da ordenes consultas a la ase de datos
    public void Consultar(String query) {
        try {
            conectionSql();
            preparedStatement = conection.prepareStatement(query);
        } catch (Exception e) {
            MessageEmergent("Fail Consultar(): "+e.getMessage());
        }
    }
    
    //el metodo cierra la ruta que hay entre las consultas y java
    public void ExitStatements() {
        try {
            preparedStatement.close();
        } catch (Exception e) {
            MessageEmergent("Fail ExitStatements(): "+e.getMessage());
        }
    }
    
    //el metodo ejecuta la consulta establesida
    public void EjecutarConsulta() {
        try {
            Consultar("select * from users");
            this.resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            MessageEmergent("Fail EjecutarConsulta(): "+e.getMessage());
        }
    }
    
    public void EjecutarConsulta(String data) {
        try {
            Consultar("select * from users where "+data);
            this.resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            MessageEmergent("Fail EjecutarConsulta(): "+e.getMessage());
        }
    }
    
    //el metodo cierra coneccion con las consultas hechas a la base de datos
    public void ExitConection(){
        try {
            resultSet.close();
            preparedStatement.close();
            conection.close();
        } catch (Exception e) {
            MessageEmergent("Fail ExitConection(): "+e.getMessage());
        }
    }
    
    
    //el metodo lista los resultados obtenidos 
    public ArrayList<Usuario> ListarResultado() {     
        try {
            EjecutarConsulta();
            lista = new ArrayList<>();
            while (this.resultSet.next()) {
                lista.add(new Usuario(this.resultSet.getInt("id"),this.resultSet.getString("name"),
                this.resultSet.getString("lastname"),this.resultSet.getInt("age"),this.resultSet.getInt("phone")));
            }
            ExitConection();
            return lista;
        } catch (Exception e) {
            MessageEmergent("Fail ListarResultado(): "+e.getLocalizedMessage());
        }
        return lista;
    }
    
    //el metodo muestra los nombres de campo en la base de datos
    public String[] ListarEtiquetas() {         
        try {
            EjecutarConsulta();
            rsultado = resultSet.getMetaData();
            ExitConection();
            return new String[]{rsultado.getColumnName(1), rsultado.getColumnName(2),
            rsultado.getColumnName(3), rsultado.getColumnName(4), rsultado.getColumnName(5)};
        } catch (Exception e) {
            MessageEmergent("Fail ListarEtiquetas(): "+e.getLocalizedMessage());
        }
        return null;
    }
    
    public void AddUser(Usuario newUsuario) {
        try {
            Consultar("INSERT INTO users (name, lastname, age, phone) VALUES (?,?,?,?)");
            preparedStatement.setString(1, newUsuario.getNombre());
            preparedStatement.setString(2, newUsuario.getApellido());
            preparedStatement.setInt(3, newUsuario.getEdad());
            preparedStatement.setInt(4, newUsuario.getTelefono());
            preparedStatement.executeUpdate();
            MessageEmergent("User added: "+newUsuario.getNombre()+" "+newUsuario.getApellido());
        } catch (Exception e) {
            MessageEmergent("AddUser() fail "+e.getMessage());
        }
    } 

    public void RemoveUser(int deleteUser){
        try {
            Consultar("DELETE FROM users where id = ?");
            preparedStatement.setInt(1, deleteUser);
            preparedStatement.executeUpdate();
            MessageEmergent("User Deleted");
        } catch (Exception e) {
            MessageEmergent("RemoveUser() fail"+e.getMessage());
        }
    }

    public void EditUser(Usuario newUsuario ,int id){
        try {
            Consultar("UPDATE users SET name = ?, lastname = ?, age = ?, phone = ? WHERE id = ?");
            preparedStatement.setString(1, newUsuario.getNombre());
            preparedStatement.setString(2, newUsuario.getApellido());
            preparedStatement.setInt(3, newUsuario.getEdad());
            preparedStatement.setInt(4, newUsuario.getTelefono());
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();
            MessageEmergent("Edit User: "+newUsuario.getNombre()+" "+newUsuario.getApellido());
        } catch (Exception e) {
            MessageEmergent("EditUser() fail "+e.getMessage());
        }
    }
    
    public ArrayList<Usuario> search(String data){
        try {
            resultSet = connectSql.Connect().createStatement().executeQuery("select * from users where "+data);
            lista = new ArrayList<>();
            while (this.resultSet.next()) {
                lista.add(new Usuario(this.resultSet.getInt("id"),this.resultSet.getString("name"),
                this.resultSet.getString("lastname"),this.resultSet.getInt("age"),this.resultSet.getInt("phone")));
            }
            ExitConection();
            return lista;
        } catch (Exception e) {
            MessageEmergent("Fail search(): "+e.getLocalizedMessage());
        }
        return lista;
    }
    
    public void MessageEmergent(String message){
        JOptionPane.showMessageDialog(null, message);
    }
}