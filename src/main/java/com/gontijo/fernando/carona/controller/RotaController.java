package com.gontijo.fernando.carona.controller;

import com.gontijo.fernando.carona.model.Rota;
import com.gontijo.fernando.carona.model.Veiculo;
import com.gontijo.fernando.carona.service.RotaService;
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
@RequestMapping(value="/rota")
public class RotaController {

    @Autowired
    private RotaService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Rota> find(@PathVariable Integer id) {
        Rota rota = service.find(id);
        return ResponseEntity.ok().body(rota);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Rota rota, @PathVariable Integer id){
        service.update(rota);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Rota>> findAll() {
        List<Rota> listaRota = service.findAll();
        return ResponseEntity.ok().body(listaRota);
    }
}
