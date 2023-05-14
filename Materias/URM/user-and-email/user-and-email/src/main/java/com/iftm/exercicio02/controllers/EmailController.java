package com.iftm.exercicio02.controllers;

import com.iftm.exercicio02.data.vo.EmailVO;
import com.iftm.exercicio02.services.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/email")
@Api(value = "Email Endpoint", tags = {"Email"})
public class EmailController {

    @Autowired
    private EmailService service;

    @GetMapping
    @ApiOperation(value = "Lista todos os emails", notes = "Retorna uma lista com todos os emails cadastrados")
    public ResponseEntity<List<EntityModel<EmailVO>>> findAll() {
        List<EmailVO> emails = service.findAll();
        List<EntityModel<EmailVO>> emailModels = emails.stream()
                .map(email -> EntityModel.of(email,
                        Link.of(String.format("/api/v1/email/%d", email.getId())).withSelfRel(),
                        Link.of("/api/v1/email").withRel("emails")))
                .collect(Collectors.toList());
        return ResponseEntity.ok(emailModels);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Busca um email por ID", notes = "Retorna um email pelo seu ID")
    public ResponseEntity<EntityModel<EmailVO>> findById(@PathVariable("id") Long id) {
        EmailVO email = service.findById(id);
        EntityModel<EmailVO> emailModel = EntityModel.of(email,
                Link.of(String.format("/api/v1/email/%d", email.getId())).withSelfRel(),
                Link.of("/api/v1/email").withRel("emails"));
        return ResponseEntity.ok(emailModel);
    }

    @PostMapping
    @ApiOperation(value = "Cria um novo email", notes = "Cria um novo email no sistema")
    public ResponseEntity<EntityModel<EmailVO>> save(@RequestBody EmailVO emailVO) {
        EmailVO email = service.save(emailVO);
        EntityModel<EmailVO> emailModel = EntityModel.of(email,
                Link.of(String.format("/api/v1/email/%d", email.getId())).withSelfRel(),
                Link.of("/api/v1/email").withRel("emails"));
        return ResponseEntity.ok(emailModel);
    }

    @PutMapping
    @ApiOperation(value = "Atualiza um email", notes = "Atualiza as informações de um email já existente")
    public ResponseEntity<EntityModel<EmailVO>> update(@RequestBody EmailVO emailVO) {
        EmailVO email = service.update(emailVO);
        EntityModel<EmailVO> emailModel = EntityModel.of(email,
                Link.of(String.format("/api/v1/email/%d", email.getId())).withSelfRel(),
                Link.of("/api/v1/email").withRel("emails"));
        return ResponseEntity.ok(emailModel);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Deleta um email", notes = "Deleta um email do sistema")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok("Email deleted");
    }
}
