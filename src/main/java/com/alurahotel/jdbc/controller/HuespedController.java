package com.alurahotel.jdbc.controller;

import java.util.List;


import com.alurahotel.jdbc.dao.HuespedDAO;
import com.alurahotel.jdbc.factory.ConnectionFactory;
import com.alurahotel.jdbc.model.Huesped;

public class HuespedController {

	private HuespedDAO huespedDao;

	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDAO(factory.recuperaConexion());
	}
	
	public void guardar(Huesped huesped) {
		huespedDao.guardar(huesped);
	}

	public List<Huesped> listar() {
		return huespedDao.listar();
	}

	public int eliminar(Integer id) {
		return huespedDao.eliminar(id);
	}

	public int modificar(String nombre, String apellido, String fechaNacimmiento, String nacionalidad,
			String telefono, int id) {
		return huespedDao.modificar(nombre, apellido, fechaNacimmiento, nacionalidad, telefono, id);
	}


	public List<Huesped> filtroApellido(String apellido) {
		return huespedDao.filtroApellido(apellido);
	}
	
	public List<Huesped> filtroId(Integer id) {
		return huespedDao.filtroId(id);
	}


}