package com.gogarage.gogarageapi.modules.pessoa;

import com.gogarage.gogarageapi.modules.pessoa.dtos.EmailPessoaDTO;
import com.gogarage.gogarageapi.modules.pessoa.dtos.IdPessoaDTO;
import com.gogarage.gogarageapi.modules.pessoa.dtos.LoginPessoaDTO;
import com.gogarage.gogarageapi.modules.pessoa.dtos.UpdatePessoaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaModel> findById(@PathVariable long id) {
        PessoaModel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
    public ResponseEntity<IdPessoaDTO> getEmailPassword(@RequestBody LoginPessoaDTO obj) {
        return ResponseEntity.ok().body(service.getEmailPassword(obj));
    }

    @PostMapping(value = "/valid-email", consumes = "application/json;charset=UTF-8")
    public ResponseEntity<EmailPessoaDTO> getEmail(@RequestBody EmailPessoaDTO obj) {
        return ResponseEntity.ok().body(service.getEmail(obj));
    }

    @PostMapping
    public ResponseEntity<PessoaModel> insert(@RequestBody PessoaModel obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping()
    public ResponseEntity<UpdatePessoaDTO> updatePessoa(@RequestBody UpdatePessoaDTO obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping("/upadate/email/{id}")
    public ResponseEntity<EmailPessoaDTO> updateEmail(@PathVariable Long id, @RequestBody EmailPessoaDTO obj) {
        obj = service.updateEmailPessoa(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
