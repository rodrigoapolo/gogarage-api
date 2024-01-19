package com.gogarage.gogarageapi.modules.garagem;

import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface GaragemRepository extends JpaRepository<GaragemModel, Long> {

    Optional<List<GaragemModel>> getGaragemBySituacaoAndDisponibilidadeAndStatusIsTrue(@Param("situacao")Integer situacao,
                                                                                       @Param("disponibilidade") Boolean disponibilidade);

    Set<GaragemModel> getByPessoa(@Param("pessoa") PessoaModel pessoa);

    @Query(value = "select\n" +
            "    g.id,\n" +
            "    g.altura_vaga,\n" +
            "    g.cobertura,\n" +
            "    g.disponibilidade,\n" +
            "    g.bairro,\n" +
            "    g.cep,\n" +
            "    g.cidade,\n" +
            "    g.complemento,\n" +
            "    g.logradouro,\n" +
            "    g.numero,\n" +
            "    g.uf,\n" +
            "    g.foto,\n" +
            "    g.horario_inicio,\n" +
            "    g.horario_termino,\n" +
            "    g.largura_vaga,\n" +
            "    g.latitude,\n" +
            "    g.longitude,\n" +
            "    g.pessoa_id,\n" +
            "    g.situacao,\n" +
            "    g.status,\n" +
            "    g.taxa_horario,\n" +
            "    g.valor_hora\n" +
            "    from\n" +
            "    tb_garagem g\n" +
            "    where\n" +
            "    g.situacao= :situacao \n" +
            "    and g.disponibilidade= :disponibilidade\n" +
            "    and g.bairro = :bairro\n" +
            "    and g.status = :status",nativeQuery = true)

    Optional<List<GaragemModel>> getGaragemByBairro(Integer situacao, Boolean disponibilidade, String bairro, Boolean status);
}
