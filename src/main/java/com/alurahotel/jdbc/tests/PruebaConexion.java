package com.alurahotel.jdbc.tests;

import java.sql.Connection;
import java.sql.SQLException;

import com.alurahotel.jdbc.factory.ConnectionFactory;

public class PruebaConexion {
	public static void main(String[] args) throws SQLException {
		ConnectionFactory factory = new ConnectionFactory();
		Connection con = factory.recuperaConexion();

		System.out.println("Cerrando la conexión");

		con.close();
	}
}
