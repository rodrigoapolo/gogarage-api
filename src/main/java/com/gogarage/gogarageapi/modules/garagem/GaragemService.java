package com.gogarage.gogarageapi.modules.garagem;

import com.gogarage.gogarageapi.modules.garagem.dtos.GaragemDTO;
import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaRepository;
import com.gogarage.gogarageapi.services.exceptions.DatabaseException;
import com.gogarage.gogarageapi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class GaragemService {

    @Autowired
    private GaragemRepository garagemRepository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<GaragemModel> findAll(String bairro) {
        Optional<List<GaragemModel>> obj = garagemRepository.getGaragemByBairro(SituacaoEnum.APROVADO.getCod(), true, bairro,true);
        return obj.orElseThrow(() -> new ResourceNotFoundException(obj));
    }

    public Set<GaragemModel> getGaragePessoa(Long idPessoa) {
        Set<GaragemModel> garagemModelList = garagemRepository.getByPessoa(
                pessoaRepository.findById(idPessoa).get());

//        List<GaragemDTO> garagemDTOS = new LinkedList<>();
//
//        for (GaragemModel g : garagemModelList) {
//            GaragemDTO aux = new GaragemDTO();
//            BeanUtils.copyProperties(g,aux);
//            aux.setIdPssoa(g.getId());
//            aux.setEndereco(g.getEnderecoModel());
//            garagemDTOS.add(aux);
//        }
        return garagemModelList;
    }

    public GaragemDTO insert(GaragemDTO obj) {
        GaragemModel garagemModel = new GaragemModel();
        BeanUtils.copyProperties(obj, garagemModel);
        PessoaModel p = pessoaRepository.getReferenceById(obj.getIdPssoa());
        garagemModel.setPessoa(p);
        garagemModel.setDisponibilidade(true);
        garagemModel.setStatus(true);
        garagemModel.setSituacao(SituacaoEnum.APROVADO);
        garagemModel.setEnderecoModel(obj.getEndereco());
        obj.setId(garagemRepository.save(garagemModel).getId());
        return obj;
    }

    public void delete(Long id) {
        try {
            garagemRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public GaragemModel update(Long id, GaragemModel obj) {
        try {
            GaragemModel entity = garagemRepository.getReferenceById(id);
            updateDate(entity, obj);
            return garagemRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateDate(GaragemModel entity, GaragemModel obj) {
        entity.setCobertura(obj.getCobertura());
        entity.setFoto(obj.getFoto());
        entity.setHorarioInicio(obj.getHorarioInicio());
        entity.setHorarioTermino(obj.getHorarioTermino());
        entity.setTaxaHorario(obj.getTaxaHorario());
        entity.setValorHora(obj.getValorHora());
        entity.setAlturaVaga(obj.getAlturaVaga());
        entity.setLarguraVaga(obj.getLarguraVaga());
        entity.setDisponibilidade(obj.getDisponibilidade());
        entity.setStatus(obj.getStatus());
        entity.setSituacao(obj.getSituacao());
        entity.setLatitude(obj.getLatitude());
        entity.setLongitude(obj.getLongitude());
    }
}
