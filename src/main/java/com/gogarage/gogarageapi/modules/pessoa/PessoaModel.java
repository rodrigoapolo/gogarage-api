package com.gogarage.gogarageapi.modules.pessoa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.gogarage.gogarageapi.modules.agendamento.AgendamentoModel;
import com.gogarage.gogarageapi.modules.email.EmailModel;
import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_pessoa")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PessoaModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private String phone;
    private Boolean status;
    @JsonIgnore
    @OneToMany(mappedBy = "pessoa")
    private Set<GaragemModel> garagemModels = new HashSet<>();
    @JsonIgnore()
    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Set<AgendamentoModel> agendamento = new HashSet<>();
    @JsonIgnore()
    @OneToMany(mappedBy = "ownerRef")
    private Set<EmailModel> emails = new HashSet<>();
    private String cpf;
    private String cnpj;
    public PessoaModel() {}

    public PessoaModel(Long id, String name, String email, String password, String phone, Boolean status, String cpf, String cnpj) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

    private void setGaragemModels(Set<GaragemModel> garagemModels) {
        this.garagemModels = garagemModels;
    }

    private void setEmails(Set<EmailModel> emails) {
        this.emails = emails;
    }
}
