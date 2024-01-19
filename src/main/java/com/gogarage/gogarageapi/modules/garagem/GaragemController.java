package com.gogarage.gogarageapi.modules.garagem;

import com.gogarage.gogarageapi.modules.garagem.dtos.GaragemDTO;
import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/garagens")
public class GaragemController {

    @Autowired
    private GaragemService service;

    @GetMapping(value = "/get-bairro/{bairro}")
    public ResponseEntity<List<GaragemModel>> findAll(@PathVariable String bairro){
        List<GaragemModel> list = service.findAll(bairro);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/pessoa/{idPessoa}")
    public ResponseEntity<Set<GaragemModel>> getGaragePessoa(@PathVariable long idPessoa){
        Set<GaragemModel> obj = service.getGaragePessoa(idPessoa);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<GaragemDTO> insert(@RequestBody GaragemDTO obj){
        obj = service.insert(obj);
/*        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);*/
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GaragemModel> update(@PathVariable long id, @RequestBody GaragemModel obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
