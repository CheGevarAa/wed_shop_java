package com.popov.web_shop.controller;

import com.popov.web_shop.entity.ClientRole;
import com.popov.web_shop.service.ClientRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class ClientRoleController {
    private final ClientRoleService clientRoleService;

    @Autowired
    public ClientRoleController(ClientRoleService clientService){
        this.clientRoleService = clientService;
    }
    @PostMapping("/api/clientRole")
    public ResponseEntity<?> create(@RequestBody ClientRole clientRole){
        clientRoleService.create(clientRole);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/clientRole")
    public ResponseEntity<List<ClientRole>> findALL(){
        final List<ClientRole> clientRoleList = clientRoleService.findAll();
        return clientRoleList != null && !clientRoleList.isEmpty()
                ? new ResponseEntity<>(clientRoleList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/clientRole/{id}")
    public ResponseEntity<Optional<ClientRole>> find(@PathVariable(name = "id")Long id){
        final Optional<ClientRole> clientRole = clientRoleService.find(id);
        return clientRole!=null
                ? new ResponseEntity<>(clientRole, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/clientRole/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(name = "id")Long id, @RequestBody ClientRole clientRoleUpdate){
        return clientRoleService.find(id).map(clientRole -> {
            //here must be setters
            clientRoleService.update(clientRole);
            return new ResponseEntity<>(clientRole, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }
}
