package com.gontijo.fernando.carona.service;

import com.gontijo.fernando.carona.model.Usuario;
import com.gontijo.fernando.carona.model.Veiculo;
import com.gontijo.fernando.carona.repositories.UsuarioRepository;
import com.gontijo.fernando.carona.repositories.VeiculoRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class VeiculoServiceTest {



    @TestConfiguration
    static class veiculoServieTestConfiguration{
        @Bean
        public VeiculoService veiculoService(){
            return new VeiculoService();
        }
    }


    @Autowired
    VeiculoService veiculoService;

    @MockBean
    VeiculoRepository veiculoRepository;


    Usuario usuario = new Usuario(1, "fernando.gontijos@hotmail.com", "Fernando Gontijo",
            "senhaTeste", 38999380626L);

    Veiculo veiculo = new Veiculo(2,4, "Honda Civic", "2008","PLACA", usuario);

    Veiculo veiculoTeste = new Veiculo(2,4, "Honda Civic", "2008","PLACA", usuario);


    @Before
    public void setup(){
        Mockito.when(veiculoRepository.save(veiculoTeste)).thenReturn(veiculo);
        Mockito.when(veiculoRepository.findById(2)).thenReturn(java.util.Optional.ofNullable(veiculo));
    }






}
