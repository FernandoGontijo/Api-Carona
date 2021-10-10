package com.gontijo.fernando.carona.controller;

import com.gontijo.fernando.carona.model.Usuario;
import com.gontijo.fernando.carona.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Usuario> find(@PathVariable Integer id) {
        Usuario usuario = service.find(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Usuario usuario, @PathVariable Integer id){
        service.update(usuario);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> listaUsuario = service.findAll();
        return ResponseEntity.ok().body(listaUsuario);
    }

}
