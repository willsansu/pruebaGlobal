package com.prueba.global.dto;

import java.io.Serializable;

import com.prueba.global.entities.DatosPersonales;

public class DtoDatosPersonales implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DatosPersonales datosPersonales;
	public boolean salida;
	public String mensaje;
	
	public DatosPersonales getDatosPersonales() {
		return datosPersonales;
	}
	public void setDatosPersonales(DatosPersonales datosPersonales) {
		this.datosPersonales = datosPersonales;
	}
	public boolean isSalida() {
		return salida;
	}
	public void setSalida(boolean salida) {
		this.salida = salida;
	}
	
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public DtoDatosPersonales(DatosPersonales datosPersonales, boolean salida) {
		super();
		this.datosPersonales = datosPersonales;
		this.salida = salida;
	}
	
	public DtoDatosPersonales() {}
	
}
