package com.gogarage.gogarageapi.modules.agendamento;

import com.gogarage.gogarageapi.modules.agendamento.dtos.AgendamentoDTO;
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

import java.util.Set;

@RestController
@RequestMapping(value = "/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping(value = "/{idPessoa}")
    public ResponseEntity<Set<AgendamentoModel>> findById(@PathVariable long idPessoa) {
        Set<AgendamentoModel> obj = service.getAgendamentoPessoa(idPessoa);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<AgendamentoDTO> insert(@RequestBody AgendamentoDTO obj) {
        AgendamentoDTO agendamento = service.insert(obj);
        return ResponseEntity.ok().body(agendamento);
    }

    @PutMapping
    public ResponseEntity<AgendamentoModel> update(@RequestBody AgendamentoModel obj) {
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
