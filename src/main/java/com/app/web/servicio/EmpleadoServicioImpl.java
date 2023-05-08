package com.app.web.servicio;

import com.app.web.entidad.Empleado;
import com.app.web.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServicioImpl implements EmpleadoServicio {

	@Autowired
	private EmpleadoRepositorio repositorio;

	@Override
	public List<Empleado> listarTodosLosEmpleados() {
		List<Empleado> list= repositorio.findAll();
		return list;
	}

	@Override
	public Empleado guardarEmpleado(Empleado empleado) {
		if(empleado != null) {
			return repositorio.save(empleado);
		} else {
			return null;
		}
	}

	@Override
	public Empleado obtenerEmpleadoPorId(Long id) {
		if (id!=null){
		return repositorio.findById(id).get();
		} else {
			return null;
		}
	}

	@Override
	public Empleado obtenerEmpleadoPorCorreo(String correo) {
		if (correo != null){
			return repositorio.getEmpleadoPorCorreo(correo);
		}
		return null;
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		if(empleado!=null){
		return repositorio.save(empleado);
		} else {
			return null;
		}
	}

	@Override
	public String eliminarEmpleado(Long id) {
		if(id!=null) {
			try {
			repositorio.deleteById(id);
			return "Borrado Exitoso";
			}
			catch (Exception e){
				return "Borrado Fallido";
			}
		}
		return "Borrado Fallido";
	}

}
