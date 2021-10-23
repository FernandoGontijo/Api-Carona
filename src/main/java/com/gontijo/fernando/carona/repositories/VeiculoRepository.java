package com.gontijo.fernando.carona.repositories;

import com.gontijo.fernando.carona.model.Usuario;
import com.gontijo.fernando.carona.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    @Query(value = "SELECT COUNT(placa) FROM carona.tb_veiculo WHERE placa like ?1", nativeQuery = true)
    Integer findVeiculoByPlaca(String placa);

    @Query(value = "SELECT COUNT(id_usuario) FROM carona.tb_veiculo WHERE id_usuario like ?1", nativeQuery = true)
    Integer findVeiculoByUsuario(Integer id);

}
