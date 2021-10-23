package com.gontijo.fernando.carona.service;

import com.gontijo.fernando.carona.dto.UsuarioDTO;
import com.gontijo.fernando.carona.model.Usuario;
import com.gontijo.fernando.carona.repositories.UsuarioRepository;
import com.gontijo.fernando.carona.exceptions.DataIntegrityException;
import com.gontijo.fernando.carona.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    public String cadastrarUsuario(Usuario usuario) throws Exception {
        usuario.setId(null);
        try {
            if (!isValidEmailAddress(usuario.getEmail())) {
                return "Email Inválido!";
            }
            if (repo.verificarEmail(usuario.getEmail()) > 0) {
                return "Email já Cadastrado!";
            }
            if (repo.verificarTelefone(usuario.getTelefone()) > 0) {
                return "Telefone já Cadastrado!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        BCryptPasswordEncoder criptografar = new BCryptPasswordEncoder();
        String senhaCriptografada = criptografar.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        repo.save(usuario);
        return "Usuário criado com sucesso!";
    }


    public Usuario getByEmail(String email) {
        return repo.findByEmail(email);
    }


    public Usuario buscarUsuarioPorId(Integer id) {
        Optional<Usuario> usuario = repo.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException(
                "Usuario não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        Usuario usuarioAtualizado = buscarUsuarioPorId(usuario.getId());
        atualizarDadosUsuario(usuarioAtualizado, usuario);
        return repo.save(usuarioAtualizado);
    }

    private void atualizarDadosUsuario(Usuario usuarioAtualizado, Usuario usuario) {  // Atualiza somente algums atributos do objeto Cliente
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setTelefone(usuario.getTelefone());
        usuarioAtualizado.setSenha(usuario.getSenha());
    }


    public void excluirUsuario(Integer id) {
        buscarUsuarioPorId(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }

    }

    public List<Usuario> buscarTodos(){
        return repo.findAll();
    }

    public Usuario fromDTO(UsuarioDTO usuarioDto) {

        return new Usuario(usuarioDto.getId(),
                           usuarioDto.getEmail(),
                           usuarioDto.getNome(),
                           usuarioDto.getSenha(),
                           usuarioDto.getTelefone());

    }


    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }

}
