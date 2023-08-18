package com.alura.jdbc.controller;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alura.jdbc.Factory.CreacionDeConexion;
import com.alura.jdbc.factory.ConnectionFactory;

import java.util.HashMap;

public class ProductoController {

	public void modificar(String nombre, String descripcion, Integer id) {
		// TODO
	}

	public void eliminar(Integer id) {
		// TODO
	}

	public List<Map<String, String>> listar() throws SQLException {

		// ABRIENDO CONEXION CON BASE DE DATOS
		Connection con = new CreacionDeConexion().recuperaConexion();

		// HACIENDO LA LOGICA DE CONSULTA
		PreparedStatement preparedStatement = con
				.prepareStatement("SELECT ID , Nombre, DESCRIPCION , CANTIDAD FROM tbproducto");
		boolean result = preparedStatement.executeQuery() != null;

		// LOGICA PARA QUE LA CONSULTA SEA VISIBLE
		ResultSet resultsetV = preparedStatement.getResultSet();
		List<Map<String, String>> resultado = new ArrayList<>();

		while (resultsetV.next()) {
			Map<String, String> fila = new HashMap<>();
			fila.put("ID", String.valueOf(resultsetV.getInt("ID")));
			fila.put("Nombre", resultsetV.getString("Nombre"));
			fila.put("DESCRIPCION", resultsetV.getString("DESCRIPCION"));
			fila.put("CANTIDAD", String.valueOf(resultsetV.getInt("CANTIDAD")));
			resultado.add(fila);
		}

		con.close();
		return resultado;
	}

	public void guardar(Map<String, String> producto) throws SQLException {
	  
	    Connection con = ConnectionFactory().recuperaConexion();

	    Statement statement = (Statement) con.createStatement();
	    statement.execute(
	            "INSERT INTO PRODUCTO (nombre, descripcion, cantidad)"
	                    + " VALUES ('" + producto.get("NOMBRE") + "', '"
	                    + producto.get("DESCRIPCION") + "', '" + producto.get("CANTIDAD") + "')",
	                    Statement.RETURN_GENERATED_KEYS);

	    ResultSet resultSet = ((java.sql.Statement) statement).getGeneratedKeys();

	    while(resultSet.next()) {
	        System.out.println(String.format(
	                "Fue insertado el producto de ID: %d",
	                resultSet.getInt(1)));
	    }
	}
	
}



