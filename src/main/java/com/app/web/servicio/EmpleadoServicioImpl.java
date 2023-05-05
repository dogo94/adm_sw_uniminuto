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
		return repositorio.save(empleado);
	}

	@Override
	public Empleado obtenerEmpleadoPorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public Empleado actualizarEmpleado(Empleado empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public void eliminarEmpleado(Long id) {
		repositorio.deleteById(id);

	}

}
