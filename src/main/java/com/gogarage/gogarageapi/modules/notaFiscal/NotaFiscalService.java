package com.gogarage.gogarageapi.modules.notaFiscal;

import com.gogarage.gogarageapi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository repository;

    public List<NotaFiscalModel> findAll() {
        return repository.findAll();
    }

    public NotaFiscalModel findById(Long id) {
        Optional<NotaFiscalModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public NotaFiscalModel insert(NotaFiscalModel obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        //TODO: fazer delete
    }

    public NotaFiscalModel update(Long id, NotaFiscalModel obj) {
        try {
            NotaFiscalModel entity = repository.getReferenceById(id);
            updateDate(entity, obj);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(NotaFiscalModel entity, NotaFiscalModel obj) {
        //todo; Fazer atualização da notafiscal

    }
}
