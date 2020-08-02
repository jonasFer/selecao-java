package com.selecaojava.rest.controller.usuario;

import com.selecaojava.domain.entity.Usuario;
import com.selecaojava.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario byId(@PathVariable Long id) {
        return service.byId(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> all() {
        return service.all();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.update(id, usuario);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario usuario) {
        return service.save(usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
