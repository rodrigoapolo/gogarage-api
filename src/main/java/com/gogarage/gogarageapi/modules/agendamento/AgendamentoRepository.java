package com.gogarage.gogarageapi.modules.agendamento;

import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface AgendamentoRepository extends JpaRepository<AgendamentoModel, Long>{

    Set<AgendamentoModel> getByPessoa(@Param("pessoa")PessoaModel pessoa);
    
}
