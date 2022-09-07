package com.prueba.global.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;



@Entity
@Table(name="datos_personales")
public class DatosPersonales implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="identificacion")
	private String identificacion;

	@Column(name="nombres")
	private String nombres;

	@Column(name="apellidos")
	private String apellidos;

	@Column(name="edad")
	private int edad;

	@Column(name="direccion")
	private String direccion;
	
	@Column(name="celular")
	private String celular;

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public DatosPersonales() {
		
	}
	
	public DatosPersonales(String json) {
		try {
			JSONObject obj=new JSONObject(json);

			this.identificacion=obj.getString("identificacion");
			this.nombres=obj.getString("nombres");
			this.apellidos=obj.getString("apellidos");
			this.edad=obj.getInt("edad");
			this.direccion=obj.getString("direccion");
			this.celular=obj.getString("celular");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   
	}

}
