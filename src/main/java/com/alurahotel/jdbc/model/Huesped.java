package com.alurahotel.jdbc.model;

public class Huesped {
	private Integer id;
	private String nombre;
	private String apellido;
	private String fechaDeNacimiento;
	private String nacionalidad;
	private String telefono;
	private Integer idReserva;

	public Huesped(String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono,
			Integer idReserva) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public Huesped(int id, String nombre, String apellido, String fechaNacimiento,
						String nacionalidad, String telefono, int idReserva) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaDeNacimiento = fechaNacimiento;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.idReserva = idReserva;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Integer idReserva) {
		this.idReserva = idReserva;
	}

	@Override
	public String toString() {
		return String.format(
				"{ id: %d, Nombre: %s, Apellido: %s, Fecha Nacimiento: %s, Nacionalidad: %s, Telefono: %s, Id Reserva: %d}",
				this.id, this.nombre, this.apellido, this.fechaDeNacimiento, this.nacionalidad, this.telefono,
				this.idReserva);
	}

}
