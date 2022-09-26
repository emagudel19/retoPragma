package com.pragma.crud.servicio;

import com.pragma.crud.modelo.Usuario;
import com.pragma.crud.repositorio.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class ServicioUsuarioImpl implements ServicioUsuario{

    private final RepositorioUsuario repositorioUsuario;

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public String obternerUsuario(String correo) {
        List<Usuario> usuarios = repositorioUsuario.findAll();
        Usuario user = null;
        for (Usuario us:usuarios) {
            if (us.getCorreo().equals(correo))
                user = us;
        }
        if (user == null)
            return "Registro no encontrado";
        return user.toString();

    }

    @Override
    public Usuario usuarioAModificar(Long id, Usuario usuarioModificar) {
        Usuario usuarioBuscado = repositorioUsuario.findById(id).get();
        usuarioBuscado.setDireccion(usuarioModificar.getDireccion());
        return repositorioUsuario.save(usuarioBuscado);
    }

    @Override
    public boolean eliminarUsuario(Long id) {

        try {
            repositorioUsuario.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
