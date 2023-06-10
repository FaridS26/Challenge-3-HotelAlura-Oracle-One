package com.alurahotel.jdbc.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {
	 private DataSource dataSource;
	    
	    public ConnectionFactory() {
	        var comboPooledDataSource = new ComboPooledDataSource();
	        String databaseName = "hotelalura";
	        String user = "root";
	        String password = "admin";
	        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/"+databaseName+"?useTimeZone=true&serverTimeZone=UTC");
	        comboPooledDataSource.setUser(user);
	        comboPooledDataSource.setPassword(password);
	        comboPooledDataSource.setMaxPoolSize(10);
	        this.dataSource = comboPooledDataSource;
	    }

	    public Connection recuperaConexion() {
	        try {
	            return this.dataSource.getConnection();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
}
