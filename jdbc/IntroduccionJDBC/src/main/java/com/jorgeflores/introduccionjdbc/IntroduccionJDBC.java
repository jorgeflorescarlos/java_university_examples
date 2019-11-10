/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgeflores.introduccionjdbc;

import java.sql.*;

/**
 *
 * @author Jorge Flores Carlos
 */
public class IntroduccionJDBC {
    public static void main(String[] args) {
        // Cadena de conexión a mysql
        String url = "jdbc:mysql://localhost:3306/introduccion_jdbc?serverTimezone=UTC";
        
        try {
            // Objecto de conexión a la base de datos
            Connection conexion = DriverManager.getConnection(url, "jdbc_user", "Jdbc34S;#");
            
            // crear statement
            Statement instruccion = conexion.createStatement();
            
            // Crear query
           String sql = "select id_persona, nombre, apellido, email, telefono from persona";
           
           // Ejecutar query
           ResultSet resultado = instruccion.executeQuery(sql);
           
           // Procesar resultado
           while (resultado.next()){
               System.out.println("Id Persona: " + resultado.getInt(1));
               System.out.println("Nombre: "+ resultado.getString(2));
               System.out.println("Apellido: "+ resultado.getString(3));
               System.out.println("Email: "+ resultado.getString(4));
               System.out.println("Telefono: "+ resultado.getString(5));
               System.out.println("");
           };
           resultado.close();
           instruccion.close();
           conexion.close();
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            //Logger.getLogger(IntroduccionJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
