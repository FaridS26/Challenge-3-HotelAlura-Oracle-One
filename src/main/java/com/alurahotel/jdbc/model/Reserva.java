package com.alurahotel.jdbc.model;

import java.util.List;

public class Reserva {
	private Integer id;
	private String fechaEntrada;
	private String fechaSalida;
	private Integer valor;
	private String formaPago;
	
	public Reserva(String fechaEntrada, String fechaSalida, Integer valor, String formaPago) {
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	public Reserva(int id, String fechaEntrada, String fechaSalida, int valor, String formaPago) {
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.valor = valor;
		this.formaPago = formaPago;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFechaEntrada() {
		return fechaEntrada;
	}
	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Integer getValor() {
		return valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	
	 @Override
	    public String toString() {
	        return String.format(
	                "{ id: %d, Fecha Entrada: %s, Fecha Salida: %s, Valor Estadia: %d, Forma Pago: %s }",
	                this.id, this.fechaEntrada, this.fechaSalida, this.valor, this.formaPago);
	    }
	
	
}
