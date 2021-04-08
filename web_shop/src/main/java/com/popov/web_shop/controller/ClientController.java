package com.popov.web_shop.controller;

import com.popov.web_shop.entity.Client;
import com.popov.web_shop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @PostMapping("/api/client")
    public ResponseEntity<?> create(@RequestBody Client client){
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/client")
    public ResponseEntity<List<Client>> findALL(){
        final List<Client> clientList = clientService.findAll();
        return clientList != null && !clientList.isEmpty()
                ? new ResponseEntity<>(clientList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/client/{id}")
    public ResponseEntity<Optional<Client>> find(@PathVariable(name = "id")Long id){
        final Optional<Client> client = clientService.find(id);
        return client!=null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/client/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(name = "id")Long id, @RequestBody Client clientUpdate){
        return clientService.find(id).map(client -> {
            //here must be setters
            clientService.update(client);
            return new ResponseEntity<>(client, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }
}
