package com.gogarage.gogarageapi.modules.email;

import com.gogarage.gogarageapi.modules.email.dtos.EmailDTO;
import com.gogarage.gogarageapi.modules.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private JavaMailSender sender;

    public EmailDTO sendEmail(EmailDTO emailDTO, EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        emailModel.setOwnerRef(pessoaService.findById(emailDTO.getOwnerRef()));
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            sender.send(message);

            emailModel.setStatusEmailEnum(StatusEmailEnum.SENT);
        } catch (MailException e) {
            emailModel.setStatusEmailEnum(StatusEmailEnum.ERROR);
        } finally {
            emailRepository.save(emailModel);
            return emailDTO;
        }
    }
}
