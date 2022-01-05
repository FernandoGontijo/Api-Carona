package com.gontijo.fernando.carona.controller;

import com.gontijo.fernando.carona.dto.VeiculoDTO;
import com.gontijo.fernando.carona.model.Veiculo;
import com.gontijo.fernando.carona.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value="/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @RequestMapping(value="/adicionar", method= RequestMethod.POST)
    public ResponseEntity<String> insert(@RequestBody VeiculoDTO veiculoDTO) {
        Veiculo veiculo = service.fromDTO(veiculoDTO);
        return ResponseEntity.ok(service.cadastrarVeiculo(veiculo));
    }

    @RequestMapping(value="/buscar/{id}", method= RequestMethod.GET)
    public ResponseEntity<Veiculo> find(@PathVariable Integer id) {
        Veiculo veiculo = service.buscarVeiculo(id);
        return ResponseEntity.ok().body(veiculo);

    }

    @RequestMapping(value="/atualizar/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Veiculo veiculo, @PathVariable Integer id){
        service.atualizarVeiculo(veiculo);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/excluir/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.excuirVeiculo(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/todos", method=RequestMethod.GET)
    public ResponseEntity<List<VeiculoDTO>> findAll() {
        List<Veiculo> listaVeiculo = service.findAll();
        List<VeiculoDTO> listaVeiculoDTO = listaVeiculo.stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaVeiculoDTO);
    }
}
