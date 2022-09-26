package com.pragma.crud.servicio;

import com.pragma.crud.modelo.Usuario;

import java.util.Optional;

public interface ServicioUsuario {
    Usuario guardarUsuario(Usuario usuario);

    String obternerUsuario(String correo);

    Usuario usuarioAModificar(Long id, Usuario usuarioModificar);

    boolean eliminarUsuario(Long id);
}
