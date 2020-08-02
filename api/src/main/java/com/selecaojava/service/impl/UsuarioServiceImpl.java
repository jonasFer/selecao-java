package com.selecaojava.service.impl;

import com.selecaojava.domain.entity.Usuario;
import com.selecaojava.domain.repository.UsuarioRepository;
import com.selecaojava.exception.RegisterNotFoundException;
import com.selecaojava.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario byId(Long id) {
        return usuarioRepository
                .findById(id)
                .orElseThrow(()
                        -> new RegisterNotFoundException("Usuário não encontrado")
                );
    }

    @Override
    public List<Usuario> all() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario update(Long id, Usuario usuario) {
        return usuarioRepository
                .findById(id)
                .map(usuarioBanco -> {
                    usuario.setId(usuarioBanco.getId());
                    usuarioRepository.save(usuario);

                    return usuario;
                })
                .orElseThrow(()
                        -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Usuário não encontrado"
                        )
                );
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long id) {
        usuarioRepository
                .findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return Void.TYPE;
                })
                .orElseThrow(()
                        -> new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Usuário não encontrado"
                        )
                );
    }
}
