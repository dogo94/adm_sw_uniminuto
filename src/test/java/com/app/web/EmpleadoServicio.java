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
            Optional.of((new Empleado
                    ("Daniel", "Gomez", "danielos.gomez@pragma.com.co")))

    );
       Empleado empleado = empleadoServicio.obtenerEmpleadoPorId(1L);

    Assertions.assertEquals(empleado.getNombre(),"Daniel");
        Assertions.assertEquals(empleado.getApellido(),"Gomez");
    }



}
