package com.prueba.global.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.global.dto.DtoDatosPersonales;
import com.prueba.global.entities.DatosPersonales;
import com.prueba.global.repository.DatosPersonalesRepository;
import com.prueba.global.service.ServiceGeneral;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:9091")
public class DatosPersonalesController {

	@Autowired
	private ServiceGeneral serviceGeneral;
	
	@Autowired
	private DatosPersonalesRepository datos;
	
	@GetMapping(value="/listadoPersonas",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<DatosPersonales> listadoPersonas() {	
		List<DatosPersonales> lsDatos=new ArrayList<>();
		try 
		{
			List<Object[]> ls= datos.lsDatos();
			for(Object[] m:ls) {
				DatosPersonales dt=new DatosPersonales();
				dt.setIdentificacion(m[0].toString());
				dt.setNombres(m[1].toString());
				dt.setApellidos(m[2].toString());
				dt.setEdad(Integer.parseInt(m[3].toString()));
				dt.setDireccion(m[4].toString());
				dt.setCelular(m[5].toString());
				lsDatos.add(dt);

			}
			return lsDatos;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
	

	@PostMapping(value="/guardarPersona", produces=MediaType.APPLICATION_JSON_VALUE)
	public DtoDatosPersonales guardarPersona(@RequestBody String jsonDatos) {
		DtoDatosPersonales salida=null;
		try {
			salida=serviceGeneral.registrarActualizarPersona(jsonDatos);	        
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();		
		}
		return salida;
		
	}
	
	@DeleteMapping(value = "/eliminarPersona/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public DtoDatosPersonales eliminarPersona(@PathVariable(value="id") String id) {
		DtoDatosPersonales salida=null;
		salida=serviceGeneral.eliminarPersona(id);
		return salida;
	}
	
}
