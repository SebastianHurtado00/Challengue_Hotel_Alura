package com.alura.jdbc.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreacionDeConexion {

	public Connection recuperaConexion() throws SQLException {
	     Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost/control_stock?useTimeZone=true&serverTimeZone=UTC",
	                "root",
	                "Navaja09");
	     return con;
		
	}


	
}
