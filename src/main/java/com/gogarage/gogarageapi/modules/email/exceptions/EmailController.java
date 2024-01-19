package com.gogarage.gogarageapi.modules.email.exceptions;

import com.gogarage.gogarageapi.modules.email.dtos.EmailDTO;
import com.gogarage.gogarageapi.modules.email.EmailModel;
import com.gogarage.gogarageapi.modules.email.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "email")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping("/sending-email")
    public ResponseEntity<EmailDTO> sendingEmail(@RequestBody @Valid EmailDTO emailDTO) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDTO, emailModel);
        service.sendEmail(emailDTO,emailModel);
        return new ResponseEntity<>(emailDTO, HttpStatus.CREATED);
    }
}
