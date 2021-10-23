package com.gontijo.fernando.carona.controller;

import com.gontijo.fernando.carona.dto.RotaDTO;
import com.gontijo.fernando.carona.model.Rota;
import com.gontijo.fernando.carona.service.RotaService;
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
@RequestMapping(value="/rota")
public class RotaController {

    @Autowired
    private RotaService service;

    @RequestMapping(value="/adicionar", method= RequestMethod.POST)
    public ResponseEntity<Rota> insert(@RequestBody RotaDTO rotaDTO) {
        Rota rota = service.fromDTO(rotaDTO);
        rota = service.insert(rota);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/buscar/{id}").buildAndExpand(rota.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/buscar/{id}", method= RequestMethod.GET)
    public ResponseEntity<Rota> find(@PathVariable Integer id) {
        Rota rota = service.find(id);
        return ResponseEntity.ok().body(rota);
    }

    @RequestMapping(value="/atualizar/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Rota rota, @PathVariable Integer id){
        service.update(rota);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/excluir/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/todos",method=RequestMethod.GET)
    public ResponseEntity<List<RotaDTO>> findAll() {
        List<Rota> listaRota = service.findAll();
        List<RotaDTO> listaRotaDTO = listaRota.stream().map(rota -> new RotaDTO(rota)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listaRotaDTO);
    }
}
