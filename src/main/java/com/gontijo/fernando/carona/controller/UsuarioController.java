package com.gontijo.fernando.carona.controller;

import com.gontijo.fernando.carona.dto.UsuarioDTO;
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

    @RequestMapping(value="/adicionar",method= RequestMethod.POST)
    public ResponseEntity<String> adicionar(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        Usuario usuario = service.fromDTO(usuarioDTO);
        return ResponseEntity.ok(service.cadastrarUsuario(usuario));
    }

    @RequestMapping(value="/buscar/{id}", method= RequestMethod.GET)
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer id) {
        Usuario usuario = service.buscarUsuarioPorId(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(value="/atualizar/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> atualizarUsuario(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Integer id){
        Usuario usuario = service.fromDTO(usuarioDTO);
        usuario.setId(id);
        service.atualizarUsuario(usuario);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/excluir/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> excluirUsuario(@PathVariable Integer id) {
        service.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/todos",method=RequestMethod.GET)
    public ResponseEntity<List<UsuarioDTO>> buscarTodos() {
        List<Usuario> listaUsuario = service.buscarTodos();
        List<UsuarioDTO> listaUsuarioDTO = listaUsuario.stream().map(usuario -> new UsuarioDTO(usuario)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaUsuarioDTO);
    }

}
