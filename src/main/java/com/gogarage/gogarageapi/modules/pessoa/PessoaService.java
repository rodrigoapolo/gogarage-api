package com.gogarage.gogarageapi.modules.pessoa;

import com.gogarage.gogarageapi.modules.pessoa.dtos.EmailPessoaDTO;
import com.gogarage.gogarageapi.modules.pessoa.dtos.IdPessoaDTO;
import com.gogarage.gogarageapi.modules.pessoa.dtos.LoginPessoaDTO;
import com.gogarage.gogarageapi.modules.pessoa.dtos.UpdatePessoaDTO;
import com.gogarage.gogarageapi.services.exceptions.DatabaseException;
import com.gogarage.gogarageapi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public List<PessoaModel> findAll() {
        return repository.getPessoaByAndStatusIsTrue();
    }

    public PessoaModel findById(Long id) {
        Optional<PessoaModel> obj = repository.findByIdAndStatusIsTrue(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public IdPessoaDTO getEmailPassword(LoginPessoaDTO obj) {
        Optional<PessoaModel> p1 = repository.getPessoaByEmailAndPasswordAndStatusIsTrue(obj.getEmail().toLowerCase(), obj.getPassword());
        return new IdPessoaDTO(p1.orElseThrow(() -> new ResourceNotFoundException(obj)));
    }

    public EmailPessoaDTO getEmail(EmailPessoaDTO obj){
        Optional<PessoaModel> p1 = repository.getPessoaByEmailAndStatusIsTrue(obj.getEmail().toLowerCase());
        return new EmailPessoaDTO(p1.orElseThrow(() -> new ResourceNotFoundException(obj)));
    }

    public PessoaModel insert(PessoaModel obj) {
        obj.setEmail(obj.getEmail().toLowerCase());
        return repository.save(obj);
    }

    public void delete(Long id) {
        try {
            PessoaModel myPessoaModel = findById(id);
            myPessoaModel.setStatus(false);
            repository.save(myPessoaModel);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UpdatePessoaDTO update(UpdatePessoaDTO obj) {
        PessoaModel pessoa = repository.findById(obj.getId()).get();
        BeanUtils.copyProperties(obj, pessoa);
        repository.save(pessoa);
        return obj;
    }

    public EmailPessoaDTO updateEmailPessoa(Long id, EmailPessoaDTO newEmail){
        PessoaModel pessoa = repository.findById(id).get();
        pessoa.setEmail(newEmail.getEmail());
        repository.save(pessoa);
        return newEmail;
    }

    private void updateDate(PessoaModel entity, PessoaModel obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPassword(obj.getPassword());
        entity.setPhone(obj.getPhone());
        entity.setStatus(obj.getStatus());
        entity.setCpf(obj.getCpf());
        entity.setCnpj(obj.getCnpj());
    }
}
