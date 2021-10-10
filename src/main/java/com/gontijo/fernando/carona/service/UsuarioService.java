package com.gontijo.fernando.carona.service;

import com.gontijo.fernando.carona.model.Usuario;
import com.gontijo.fernando.carona.repositories.UsuarioRepository;
import com.gontijo.fernando.carona.service.exceptions.DataIntegrityException;
import com.gontijo.fernando.carona.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public Usuario insert(Usuario usuario) {
       repo.save(usuario);
       return repo.save(usuario);
    }

    public Usuario find(Integer id) {

        Optional<Usuario> usuario = repo.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException(
                "Usuario não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    public Usuario update(Usuario usuario) {
        Usuario usuarioAtualizado = find(usuario.getId());
        atualizarDadosUsuario(usuarioAtualizado, usuario);
        return repo.save(usuarioAtualizado);
    }

    private void atualizarDadosUsuario(Usuario usuarioAtualizado, Usuario usuario) {  // Atualiza somente algums atributos do objeto Cliente
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setTelefone(usuario.getTelefone());
        usuarioAtualizado.setSenha(usuario.getSenha());
    }


    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }

    }

    public List<Usuario> findAll(){
        return repo.findAll();
    }


}
