package com.app.web;

import com.app.web.entidad.Empleado;
import com.app.web.repositorio.EmpleadoRepositorio;
import com.app.web.servicio.EmpleadoServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServicio {
    @InjectMocks
    EmpleadoServicioImpl empleadoServicio;
    @Mock
    EmpleadoRepositorio repositorio;

    @Test
    public void obtenerEmpleadoPorId() {
        Mockito.when(repositorio.findById(Mockito.anyLong())).thenReturn(
                Optional.of((new Empleado("Daniel", "Gomez", "danielos.gomez@pragma.com.co")))

        );
        Empleado empleado = empleadoServicio.obtenerEmpleadoPorId(1L);

        Assertions.assertEquals(empleado.getNombre(), "Daniel");
        Assertions.assertEquals(empleado.getApellido(), "Gomez");
    }

    @Test
    public void listarTodosLosEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        empleados.add(new Empleado("Daniel", "Gomez", "danielos.gomez@pragma.com.co"));
        empleados.add(new Empleado("Juan", "Perez", "juan.perez@pragma.com.co"));
        empleados.add(new Empleado("Maria", "Rodriguez", "maria.rodriguez@pragma.com.co"));
        Mockito.when(repositorio.findAll()).thenReturn(empleados);

        List<Empleado> listaDeEmpleados = empleadoServicio.listarTodosLosEmpleados();

        Assertions.assertEquals(3, listaDeEmpleados.size());
        Assertions.assertEquals("Daniel", listaDeEmpleados.get(0).getNombre());
        Assertions.assertEquals("Perez", listaDeEmpleados.get(1).getApellido());
        Assertions.assertEquals("maria.rodriguez@pragma.com.co", listaDeEmpleados.get(2).getEmail());
    }

    @Test
    public void crearEmpleado() {
        // Creamos un objeto Empleado sin ID
        Empleado empleadoACrear = new Empleado("Juan", "Perez", "juan.perez@pragma.com.co");

        // Verificamos que el método save() del repositorio haya sido llamado con el objeto Empleado correcto
        Mockito.when(
                repositorio.save
                        (empleadoACrear)).thenReturn(empleadoACrear);

        // Llamamos al método crearEmpleado() del servicio
        Empleado empleadoCreado = empleadoServicio.guardarEmpleado(empleadoACrear);

        // Verificamos que el objeto devuelto tenga un ID generado automáticamente
        Assertions.assertNotNull(empleadoCreado.getId());

        // Verificamos que el objeto devuelto tenga los mismos valores que el objeto original
        Assertions.assertEquals(empleadoCreado.getNombre(), empleadoACrear.getNombre());
        Assertions.assertEquals(empleadoCreado.getApellido(), empleadoACrear.getApellido());
        Assertions.assertEquals(empleadoCreado.getEmail(), empleadoACrear.getEmail());
    }

    @Test
    public void editarEmpleado() {
        // Editamos un objeto Empleado sin ID
        Empleado empleadoAEditar = new Empleado("Juan", "Perez", "juan.perez@pragma.com.co");

        // Verificamos que el método edit() del repositorio haya sido llamado con el objeto Empleado correcto
        Mockito.when(
                repositorio.save
                        (empleadoAEditar)).thenReturn(empleadoAEditar);

        // Llamamos al método editarEmpleado() del servicio
        Empleado empleadoEditado = empleadoServicio.actualizarEmpleado(empleadoAEditar);

        // Verificamos que el objeto devuelto tenga los mismos valores que el objeto original
        Assertions.assertEquals(empleadoEditado.getNombre(), empleadoAEditar.getNombre());
        Assertions.assertEquals(empleadoEditado.getApellido(), empleadoAEditar.getApellido());
        Assertions.assertEquals(empleadoEditado.getEmail(), empleadoAEditar.getEmail());
    }

}
