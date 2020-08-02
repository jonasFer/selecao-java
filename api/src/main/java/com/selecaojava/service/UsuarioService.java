package com.selecaojava.service;

import com.selecaojava.domain.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    public Usuario byId(Long id);
    public List<Usuario> all();
    public Usuario update(Long id, Usuario usuario);
    public Usuario save(Usuario usuario);
    public void delete(Long id);

}
