package com.pragma.crud.controlador;

import com.pragma.crud.modelo.Usuario;
import com.pragma.crud.servicio.ServicioUsuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    @PostMapping("/crear")
    public ResponseEntity guardarUsuario(@RequestBody Usuario usuario){
        try {
            return new ResponseEntity(servicioUsuario.guardarUsuario(usuario), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/buscar/{correo}")
    public String obtenerUsuario(@PathVariable("correo") String correo){
        return servicioUsuario.obternerUsuario(correo);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity modificarUsuario(@PathVariable("id") Long idUsuario, @RequestBody Usuario usuario){
        return new ResponseEntity(servicioUsuario.usuarioAModificar(idUsuario, usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/id")
    public ResponseEntity eliminarUsuario(@PathVariable("id") Long idUsuario){
        boolean respuesta = servicioUsuario.eliminarUsuario(idUsuario);
        if(respuesta == true){
        return new ResponseEntity(HttpStatus.OK);
        }
        else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
