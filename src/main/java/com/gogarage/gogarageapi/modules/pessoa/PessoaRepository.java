package com.gogarage.gogarageapi.modules.pessoa;

import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

    //@Query(value = "SELECT ID, EMAIL, PASSWORD FROM TB_PESSOA WHERE EMAIL = '?1'  and PASSWORD = '?2'",nativeQuery = true)
    Optional<PessoaModel> getPessoaByEmailAndPasswordAndStatusIsTrue(@Param("email") String email, @Param("password") String password);

    Optional<PessoaModel> getPessoaByEmailAndStatusIsTrue(@Param("email") String email);

    Optional<PessoaModel> findByIdAndStatusIsTrue(@Param("id") Long id);

    List<PessoaModel> getPessoaByAndStatusIsTrue();

}
