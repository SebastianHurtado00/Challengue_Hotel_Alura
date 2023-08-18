package com.alura.jdbc.pruebas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.alura.jdbc.Factory.CreacionDeConexion;

public class PruebaConexion {

    public static void main(String[] args) throws SQLException {
    	 Connection con = new CreacionDeConexion().recuperaConexion();

        System.out.println("Cerrando la conexión");

        con.close();
    }

}
