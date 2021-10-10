package com.gontijo.fernando.carona.repositories;

import com.gontijo.fernando.carona.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
