package com.gogarage.gogarageapi.modules.tipoPagamento;

import com.gogarage.gogarageapi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoPagamentoService {

    @Autowired
    private TipoPagamentoRepository repository;

    public List<TipoPagamentoModel> findAll() {
        return repository.findAll();
    }

    public TipoPagamentoModel findById(Long id) {
        Optional<TipoPagamentoModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public TipoPagamentoModel insert(TipoPagamentoModel obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        //TODO: fazer delete
    }

    public TipoPagamentoModel update(Long id, TipoPagamentoModel obj) {
        try {
            TipoPagamentoModel entity = repository.getReferenceById(id);
            updateDate(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(TipoPagamentoModel entity, TipoPagamentoModel obj) {
        //todo; Fazer atualização da Tipo Pagamento

    }
}
