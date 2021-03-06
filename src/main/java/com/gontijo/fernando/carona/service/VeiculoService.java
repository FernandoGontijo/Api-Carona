package com.gontijo.fernando.carona.service;

import com.gontijo.fernando.carona.dto.VeiculoDTO;
import com.gontijo.fernando.carona.model.Veiculo;
import com.gontijo.fernando.carona.repositories.VeiculoRepository;
import com.gontijo.fernando.carona.exceptions.DataIntegrityException;
import com.gontijo.fernando.carona.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repo;

    public String cadastrarVeiculo(Veiculo veiculo) {

        veiculo.setId(null);
        try {
            if (repo.findVeiculoByPlaca(veiculo.getPlaca()) > 0 ) {
                return "Veículo já cadastrado!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        repo.save(veiculo);
        return "Veículo cadastrado com sucesso!";
    }

    public Veiculo buscarVeiculo(Integer id) {
        Optional<Veiculo> veiculo = repo.findById(id);
        return veiculo.orElseThrow(() -> new ObjectNotFoundException(
                "Veiculo não encontrado! Id: " + id + ", Tipo: " + Veiculo.class.getName()));
    }

    public Veiculo atualizarVeiculo(Veiculo veiculo) {
        Veiculo veiculoAtualizado = buscarVeiculo(veiculo.getId());
        atualizarDadosVeiculo(veiculoAtualizado, veiculo);
        return repo.save(veiculoAtualizado);
    }

    private void atualizarDadosVeiculo(Veiculo veiculoAtualizado, Veiculo veiculo) {  // Atualiza somente algums atributos do objeto Cliente
        veiculoAtualizado.setCapacidade(veiculo.getCapacidade());
        veiculoAtualizado.setModelo(veiculo.getModelo());
        veiculoAtualizado.setAno(veiculo.getAno());
        veiculoAtualizado.setUsuario(veiculo.getUsuario());
    }


    public void excuirVeiculo(Integer id) {
        buscarVeiculo(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }
    }

    public List<Veiculo> findAll(){
        return repo.findAll();
    }

    public Veiculo fromDTO(VeiculoDTO veiculoDto) {
        return new Veiculo(veiculoDto.getId(),
                           veiculoDto.getCapacidade(),
                           veiculoDto.getModelo(),
                           veiculoDto.getAno(),
                           veiculoDto.getPlaca(),
                           veiculoDto.getUsuario());
    }
}
