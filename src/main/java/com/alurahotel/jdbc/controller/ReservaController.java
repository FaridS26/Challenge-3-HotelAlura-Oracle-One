package com.alurahotel.jdbc.controller;

import java.util.List;

import com.alurahotel.jdbc.dao.ReservaDAO;
import com.alurahotel.jdbc.factory.ConnectionFactory;
import com.alurahotel.jdbc.model.Reserva;

public class ReservaController {
	private ReservaDAO reservaDao;

	public ReservaController() {
		var factory = new ConnectionFactory();
		this.reservaDao = new ReservaDAO(factory.recuperaConexion());
	}

	public void guardar(Reserva reserva) {
		reservaDao.guardar(reserva);
	}

	public List<Reserva> listar() {
		return reservaDao.listar();
	}

	public int eliminar(Integer id) {
		return reservaDao.eliminar(id);

	}

	public Object modificar(String fechaEntrada, String fechaSalida, int valor, String formaPago, Integer id) {
		return reservaDao.modificar(fechaEntrada, fechaSalida, valor, formaPago, id);
	}

	public List<Reserva> filtroApellido(String apellido) {
		return reservaDao.filtroApellido(apellido);
	}

	public List<Reserva> filtroId(Integer id) {
		return reservaDao.filtroId(id);
	}
}
