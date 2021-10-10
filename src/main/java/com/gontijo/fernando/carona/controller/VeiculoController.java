package com.gontijo.fernando.carona.controller;

import com.gontijo.fernando.carona.model.Veiculo;
import com.gontijo.fernando.carona.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value="/veiculo")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Veiculo> find(@PathVariable Integer id) {
        Veiculo veiculo = service.find(id);
        return ResponseEntity.ok().body(veiculo);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Veiculo veiculo, @PathVariable Integer id){
        service.update(veiculo);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Veiculo>> findAll() {
        List<Veiculo> listaVeiculo = service.findAll();
        return ResponseEntity.ok().body(listaVeiculo);
    }
}
