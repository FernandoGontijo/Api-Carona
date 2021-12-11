package com.gontijo.fernando.carona.service;

import com.gontijo.fernando.carona.model.Usuario;
import com.gontijo.fernando.carona.repositories.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class UsuarioServiceTest {


    @TestConfiguration
    static class usuarioServieTestConfiguration{
        @Bean
        public UsuarioService usuarioService(){
            return new UsuarioService();
        }
    }

    @Autowired
    UsuarioService usuarioService;

    @MockBean
    UsuarioRepository usuarioRepository;

    Usuario usuario = new Usuario(1, "fernando.gontijos@hotmail.com", "Fernando Gontijo",
            "senhaTeste", 38999380626L);

    Usuario usuarioTeste = new Usuario(null, "fernando.gontijos@hotmail.com", "Fernando Gontijo",
            "senhaTeste", 38999380626L);



    @Before
    public void setup(){
        Mockito.when(usuarioRepository.save(usuarioTeste)).thenReturn(usuario);
        Mockito.when(usuarioRepository.findById(1)).thenReturn(java.util.Optional.ofNullable(usuario));
        Mockito.when(usuarioRepository.findByEmail("fernando.gontijos@hotmail.com")).thenReturn(usuario);
    }

    @Test
    public void cadastrarUsuarioTest() throws Exception {
        String resultado = usuarioService.cadastrarUsuario(usuarioTeste);
        Assertions.assertEquals( "Usuário criado com sucesso!",resultado);
    }

    @Test
    public void buscarUsuarioPorIdTest(){
        usuarioService.buscarUsuarioPorId(1);
        Assertions.assertEquals(usuario,usuario);
    }

    @Test
    public void getByEmailTest(){
        Usuario usuarioEmail = usuarioService.getByEmail("fernando.gontijos@hotmail.com");
        Assertions.assertEquals(usuarioEmail,usuario);
    }

    @Test
    public void atualizarUsuarioTest(){
        Mockito.when(usuarioRepository.save(usuario)).thenReturn(usuario);
        Usuario usuarioAtualizado  = usuarioService.atualizarUsuario(usuario);
        Assertions.assertEquals(usuarioAtualizado,usuario);
    }




}
