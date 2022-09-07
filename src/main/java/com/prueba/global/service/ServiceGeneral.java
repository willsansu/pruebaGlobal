package com.prueba.global.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

import com.prueba.global.dto.DtoDatosPersonales;
import com.prueba.global.entities.DatosPersonales;
import com.prueba.global.repository.DatosPersonalesRepository;

@Service
public class ServiceGeneral {
	
	@Autowired
	private DatosPersonalesRepository datosPersonalesRepository;
	
	public List<DatosPersonales> listadoPersonas(){
		try {
			return  null;//datosPersonalesRepository.findAll();

		} catch (Exception e) {
			e.printStackTrace();
			return null;
			// TODO: handle exception
		}
	}
	
	@Transactional(rollbackFor = { Exception.class})
	public DtoDatosPersonales registrarActualizarPersona(String json) {
		try {
			DatosPersonales datos=new DatosPersonales(json);
			DatosPersonales salidaP=datosPersonalesRepository.save(datos);
            DtoDatosPersonales dto=new DtoDatosPersonales();
            dto.setSalida(true);
            dto.setDatosPersonales(salidaP);
            return dto;

		} catch (Exception e) {
            DtoDatosPersonales dto=new DtoDatosPersonales();
            dto.setSalida(false);
            dto.setMensaje(e.getMessage());
            return dto;
			// TODO: handle exception
		}
	}
	
	public DtoDatosPersonales eliminarPersona(String identificacion) {
		DtoDatosPersonales salida=new DtoDatosPersonales();
		try {
			List<Object[]> salPer=datosPersonalesRepository.getByIdenti(identificacion);
			
					//findById(identificacion);
			if(salPer!=null && salPer.size()>0) {
				for(Object[] m:salPer) {
					DatosPersonales persona=new DatosPersonales();
					persona.setIdentificacion(m[0].toString());
					persona.setNombres(m[1].toString());
					persona.setApellidos(m[2].toString());
					persona.setEdad(Integer.parseInt(m[3].toString()));
					persona.setDireccion(m[4].toString());
					persona.setCelular(m[5].toString());

					datosPersonalesRepository.delete(persona);
					salida.setMensaje("Se elimino");
					salida.setSalida(true);
				}
				
			}else {
				salida.setMensaje("No se encontro el usuario");
				salida.setSalida(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			salida=new DtoDatosPersonales();
			salida.setMensaje(e.getMessage());
			salida.setSalida(false);
			e.printStackTrace();
		}
		return salida;
	}

}
