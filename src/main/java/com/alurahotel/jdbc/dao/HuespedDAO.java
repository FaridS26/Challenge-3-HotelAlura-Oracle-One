package com.alurahotel.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alurahotel.jdbc.model.Huesped;

public class HuespedDAO {
	private Connection con;

	public HuespedDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Huesped huesped) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO HUESPEDES " + "(Nombre, Apellido, FechaNacimiento, Nacionalidad, Telefono, IdReserva)" + " VALUES (?, ?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setString(1, huesped.getNombre());
				statement.setString(2, huesped.getApellido());
				statement.setString(3, huesped.getFechaDeNacimiento());
				statement.setString(4, huesped.getNacionalidad());
				statement.setString(5, huesped.getTelefono());
				statement.setInt(6, huesped.getIdReserva());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						huesped.setId(resultSet.getInt(1));

						System.out.println(String.format("Fue insertado el huesped: %s", huesped));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Huesped> listar() {
		List<Huesped> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT * FROM HUESPEDES");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huesped(resultSet.getInt("ID"), resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"), resultSet.getString("FECHANACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),resultSet.getString("TELEFONO"),
								resultSet.getInt("IDRESERVA")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public int eliminar(Integer id) {
		try {
			final PreparedStatement statement = con.prepareStatement("DELETE huespedes, reservas "
					+ "FROM huespedes "
					+ "JOIN reservas ON huespedes.IdReserva = reservas.Id "
					+ "WHERE huespedes.id = ?");

			try (statement) {
				statement.setInt(1, id);
			
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int modificar(String nombre, String apellido, String fechaNacimmiento, String nacionalidad, String telefono,
			int id) {
		try {
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE HUESPEDES SET " + " NOMBRE = ?, " + " APELLIDO = ?," + " FECHANACIMIENTO = ?," 
					+ " NACIONALIDAD = ?, TELEFONO = ?"+ " WHERE ID = ?");

			try (statement) {
				statement.setString(1, nombre);
				statement.setString(2, apellido);
				statement.setString(3, fechaNacimmiento);
				statement.setString(4, nacionalidad);
				statement.setString(5, telefono);
				statement.setInt(6, id);
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Huesped> filtroApellido(String apellido) {
		List<Huesped> resultado = new ArrayList<>();
		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT * FROM HUESPEDES WHERE APELLIDO LIKE CONCAT('%',?,'%')");

			try (statement) {
				statement.setString(1, apellido);
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();
				
				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huesped(resultSet.getInt("ID"), resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"), resultSet.getString("FECHANACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),resultSet.getString("TELEFONO"),
								resultSet.getInt("IDRESERVA")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public List<Huesped> filtroId(Integer id) {
		List<Huesped> resultado = new ArrayList<>();
		try {
			final PreparedStatement statement = con
					.prepareStatement("SELECT * FROM HUESPEDES WHERE ID LIKE CONCAT('%',?,'%')");

			try (statement) {
				statement.setInt(1, id);
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();
				
				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Huesped(resultSet.getInt("ID"), resultSet.getString("NOMBRE"),
								resultSet.getString("APELLIDO"), resultSet.getString("FECHANACIMIENTO"),
								resultSet.getString("NACIONALIDAD"),resultSet.getString("TELEFONO"),
								resultSet.getInt("IDRESERVA")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}
}
