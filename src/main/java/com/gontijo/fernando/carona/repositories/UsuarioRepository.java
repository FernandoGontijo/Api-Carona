package com.gontijo.fernando.carona.repositories;

import com.gontijo.fernando.carona.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT COUNT(email) FROM carona.tb_usuario WHERE email like ?1", nativeQuery = true)
    Integer verificarEmail(String email);

    @Query(value = "SELECT COUNT(telefone) FROM carona.tb_usuario WHERE telefone like ?1", nativeQuery = true)
    Integer verificarTelefone(Long telefone);

    @Query(value = "SELECT * FROM carona.tb_usuario WHERE email = ?1", nativeQuery = true)
    Usuario findByEmail(String email);



}
