package com.app.web.repositorio;

import com.app.web.entidad.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long>{
    Empleado getEmpleadoPorCorreo (String correo);

}
