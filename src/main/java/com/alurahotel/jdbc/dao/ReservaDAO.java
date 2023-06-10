package com.alurahotel.jdbc.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alurahotel.jdbc.model.Reserva;

public class ReservaDAO {
	private Connection con;

	public ReservaDAO(Connection con) {
		this.con = con;
	}

	public void guardar(Reserva reserva) {
		try {
			PreparedStatement statement;
			statement = con.prepareStatement(
					"INSERT INTO RESERVAS " + "(FechaEntrada, FechaSalida, Valor, formaPago)" + " VALUES (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);

			try (statement) {
				statement.setString(1, reserva.getFechaEntrada());
				statement.setString(2,reserva.getFechaSalida());
				statement.setInt(3, reserva.getValor());
				statement.setString(4, reserva.getFormaPago());

				statement.execute();

				final ResultSet resultSet = statement.getGeneratedKeys();

				try (resultSet) {
					while (resultSet.next()) {
						reserva.setId(resultSet.getInt(1));

						System.out.println(String.format("Fue insertado la reserva: %s", reserva));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Reserva> listar() {
		List<Reserva> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement("SELECT * "
					+ "FROM reservas "
					+ "INNER JOIN huespedes ON reservas.id = huespedes.idReserva ");

			try (statement) {
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reserva(resultSet.getInt("ID"), resultSet.getString("FECHAENTRADA"),
								resultSet.getString("FECHASALIDA"), resultSet.getInt("VALOR"), resultSet.getString("FORMAPAGO")));
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
					+ "WHERE huespedes.idReserva = ?");

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

	public int modificar(String fechaEntrada, String fechaSalida, Integer valor, String formaPago,Integer id ) {
		try {
			final PreparedStatement statement = con.prepareStatement(
					"UPDATE RESERVAS SET " + "FECHAENTRADA = ?, " + " FECHASALIDA = ?," + " VALOR = ?," 
					+ " FORMAPAGO = ?"+ " WHERE ID = ?");

			try (statement) {
				statement.setString(1, fechaEntrada);
				statement.setString(2, fechaSalida);
				statement.setInt(3, valor);
				statement.setString(4, formaPago);
				statement.setInt(5, id);
				statement.execute();

				int updateCount = statement.getUpdateCount();

				return updateCount;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	public List<Reserva> filtroApellido(String apellido) {
		List<Reserva> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement("SELECT reservas.* "
					+ "FROM reservas "
					+ "INNER JOIN huespedes ON reservas.id = huespedes.idReserva WHERE huespedes.apellido LIKE CONCAT('%',?,'%')");

			try (statement) {
				statement.setString(1, apellido);
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reserva(resultSet.getInt("ID"), resultSet.getString("FECHAENTRADA"),
								resultSet.getString("FECHASALIDA"), resultSet.getInt("VALOR"), resultSet.getString("FORMAPAGO")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}

	public List<Reserva> filtroId(Integer id) {
		List<Reserva> resultado = new ArrayList<>();

		try {
			final PreparedStatement statement = con.prepareStatement("SELECT reservas.* "
					+ "FROM reservas "
					+ "INNER JOIN huespedes ON reservas.id = huespedes.idReserva WHERE reservas.id LIKE CONCAT('%',?,'%')");

			try (statement) {
				statement.setInt(1, id);
				statement.execute();

				final ResultSet resultSet = statement.getResultSet();

				try (resultSet) {
					while (resultSet.next()) {
						resultado.add(new Reserva(resultSet.getInt("ID"), resultSet.getString("FECHAENTRADA"),
								resultSet.getString("FECHASALIDA"), resultSet.getInt("VALOR"), resultSet.getString("FORMAPAGO")));
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}
}

