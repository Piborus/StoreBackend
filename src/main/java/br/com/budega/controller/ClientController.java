package br.com.budega.controller;

import br.com.budega.domain.client.Client;
import br.com.budega.domain.client.dto.RegisterClient;
import br.com.budega.service.ClientService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("client")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping()
    @Transactional
    public ResponseEntity<Void> addClient(@RequestBody @Valid RegisterClient client) {
        service.addCliente(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity detailsClient(@PathVariable UUID id){
        var client = service.getClient(id);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
