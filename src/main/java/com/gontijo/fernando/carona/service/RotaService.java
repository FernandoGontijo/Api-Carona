package com.gontijo.fernando.carona.service;

import com.gontijo.fernando.carona.model.Rota;
import com.gontijo.fernando.carona.model.Veiculo;
import com.gontijo.fernando.carona.repositories.RotaRepository;
import com.gontijo.fernando.carona.service.exceptions.DataIntegrityException;
import com.gontijo.fernando.carona.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaService {

    @Autowired
    private RotaRepository repo;

    public Rota insert(Rota rota) {
        return repo.save(rota);
    }

    public Rota find(Integer id) {
        Optional<Rota> rota = repo.findById(id);
        return rota.orElseThrow(() -> new ObjectNotFoundException(
                "Rota não encontrado! Id: " + id + ", Tipo: " + Rota.class.getName()));
    }

    public Rota update(Rota rota) {
        Rota rotaAtualizada = find(rota.getId());
        atualizarDadosRota(rotaAtualizada, rota);
        return repo.save(rotaAtualizada);
    }

    private void atualizarDadosRota(Rota rotaAtualizada, Rota rota) {
        rotaAtualizada.setOrigem(rota.getOrigem());
        rotaAtualizada.setDestino(rota.getDestino());
        rotaAtualizada.setVagas(rota.getVagas());
        rotaAtualizada.setUsuario(rota.getUsuario());

        if(rota.getHorario() != null){
            rotaAtualizada.setHorario(rota.getHorario());
        }

        if(rota.getPreco() != null){
            rotaAtualizada.setPreco(rota.getPreco());
        }

    }

    public void delete(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possível excluir porque há entidades relacionadas");
        }
    }

    public List<Rota> findAll(){
        return repo.findAll();
    }
}
