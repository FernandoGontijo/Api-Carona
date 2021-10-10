package com.gontijo.fernando.carona.service;

import com.gontijo.fernando.carona.model.Veiculo;
import com.gontijo.fernando.carona.repositories.VeiculoRepository;
import com.gontijo.fernando.carona.service.exceptions.DataIntegrityException;
import com.gontijo.fernando.carona.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    public Veiculo find(Integer id) {

        Optional<Veiculo> veiculo = repo.findById(id);
        return veiculo.orElseThrow(() -> new ObjectNotFoundException(
                "Veiculo não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
    }

    public Veiculo update(Veiculo veiculo) {
        Veiculo veiculoAtualizado = find(veiculo.getId());
        atualizarDadosVeiculo(veiculoAtualizado, veiculo);
        return repo.save(veiculoAtualizado);
    }

    private void atualizarDadosVeiculo(Veiculo veiculoAtualizado, Veiculo veiculo) {  // Atualiza somente algums atributos do objeto Cliente
        veiculoAtualizado.setCapacidade(veiculo.getCapacidade());
        veiculoAtualizado.setModelo(veiculo.getModelo());
        veiculoAtualizado.setAno(veiculo.getAno());
        veiculoAtualizado.setUsuario(veiculo.getUsuario());
    }


    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }

    }

    public List<Veiculo> findAll(){
        return repo.findAll();
    }

}
