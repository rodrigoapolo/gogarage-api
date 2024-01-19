package com.gogarage.gogarageapi.modules.agendamento;

import com.gogarage.gogarageapi.modules.agendamento.dtos.AgendamentoDTO;
import com.gogarage.gogarageapi.modules.garagem.GaragemRepository;
import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaRepository;
import com.gogarage.gogarageapi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Set;

@Service
public class AgendamentoService implements Serializable {
    private static final long serialVersionUID = 1L;
    @Autowired
    private AgendamentoRepository agendamentoRepository;
    @Autowired
    private GaragemRepository garagemRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public Set<AgendamentoModel> getAgendamentoPessoa(Long idPessoa) {
        PessoaModel p = pessoaRepository.findById(idPessoa).get();
        Set<AgendamentoModel> agendamentos = agendamentoRepository.getByPessoa(p);
        return agendamentos;
    }

    public AgendamentoDTO insert(AgendamentoDTO obj) {
        PessoaModel p = pessoaRepository.findById(obj.getIdPessoa()).get();
        GaragemModel g = garagemRepository.findById(obj.getIdGaragem()).get();
        AgendamentoModel agendamento = new AgendamentoModel();
        agendamento.setPessoa(p);
        agendamento.setGarage(g);
        agendamento.setData_inicio(obj.getData_inicio());
        agendamento.setData_final(obj.getData_final());
       agendamentoRepository.save(agendamento);
       return obj;
    }

    public void delete(Long id) {
        agendamentoRepository.delete(agendamentoRepository.findById(id).get());
    }

    public AgendamentoModel update(AgendamentoModel obj) {
        try {
            AgendamentoModel entity = agendamentoRepository.findById(obj.getId()).get();
            updateDate(entity, obj);
            return agendamentoRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj.getId());
        }
    }

    private void updateDate(AgendamentoModel entity, AgendamentoModel obj) {
        entity.setData_inicio(obj.getData_inicio());
        entity.setData_final(obj.getData_final());
    }
}
