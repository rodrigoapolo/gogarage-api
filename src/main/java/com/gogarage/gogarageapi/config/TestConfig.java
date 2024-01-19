package com.gogarage.gogarageapi.config;

import com.gogarage.gogarageapi.modules.garagem.GaragemRepository;
import com.gogarage.gogarageapi.modules.garagem.SituacaoEnum;
import com.gogarage.gogarageapi.modules.garagem.model.EnderecoModel;
import com.gogarage.gogarageapi.modules.garagem.model.GaragemModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaModel;
import com.gogarage.gogarageapi.modules.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private GaragemRepository garagemRepository;

    @Override
    public void run(String... args) throws Exception {

        PessoaModel a1 = new PessoaModel(null, "Rodrigo", "rodrigoapolodev@gmail.com", "20eabe5d64b0e216796e834f52d61fd0b70332fc", "11956191856",
                true, "10736479350", null);

        PessoaModel a2 = new PessoaModel(null, "Cesar", "cesar@gmail.com", "1234567", "11956191856",
                true, "54854816858", null);

        PessoaModel a3 = new PessoaModel(null, "Carol", "carol@gmail.com", "1234567", "11956191856",
                true, null, "54854816858");

        pessoaRepository.saveAll(Arrays.asList(a1, a2, a3));

        GaragemModel g1 = new GaragemModel(null, true, "foto1", "09:00", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);


        GaragemModel g2 = new GaragemModel(null, true, "foto2", "15:45", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);

        GaragemModel g3 = new GaragemModel(null, true, "foto3", "15:45", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);

        GaragemModel g4 = new GaragemModel(null, true, "foto3", "15:45", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);

        GaragemModel g5 = new GaragemModel(null, true, "foto3", "15:45", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);

        GaragemModel g6 = new GaragemModel(null, true, "foto3", "15:45", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);
        GaragemModel g7 = new GaragemModel(null, true, "foto3", "15:45", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);
        GaragemModel g8 = new GaragemModel(null, true, "foto3", "15:45", "18:00",
                10.0, 13.0, 1.8, 3.0, true, true,
                SituacaoEnum.APROVADO, "654654646546", "6541321", a1);


        EnderecoModel endereco1 = new EnderecoModel();
        endereco1.setBairro("Jardim Helena");
        endereco1.setCep("08420201");
        endereco1.setCidade("SP");
        endereco1.setComplemento("estacionamento");
        endereco1.setLogradouro("Rua Frei");
        endereco1.setNumero("4565");
        endereco1.setUf("");

        EnderecoModel endereco2 = new EnderecoModel();
        endereco2.setBairro("Jardim Helena");
        endereco2.setCep("08420400");
        endereco2.setCidade("SP");
        endereco2.setComplemento("estacionamento");
        endereco2.setLogradouro("Rua Santa Edith");
        endereco2.setNumero("8965");
        endereco2.setUf("");

        EnderecoModel endereco3 = new EnderecoModel();
        endereco3.setBairro("Conj. Res. José Bonifácio");
        endereco3.setCep("08420130");
        endereco3.setCidade("SP");
        endereco3.setComplemento("estacionamento");
        endereco3.setLogradouro("Av. Nossa Sra. de Guadalupe");
        endereco3.setNumero("2654");
        endereco3.setUf("");

        g1.setEnderecoModel(endereco1);
        g2.setEnderecoModel(endereco2);
        g3.setEnderecoModel(endereco3);
        g4.setEnderecoModel(endereco1);
        g5.setEnderecoModel(endereco2);
        g6.setEnderecoModel(endereco3);
        g7.setEnderecoModel(endereco1);
        g8.setEnderecoModel(endereco2);

        garagemRepository.saveAll(Arrays.asList(g1, g2, g3));

    }
}
