package com.popov.web_shop.controller;

import com.popov.web_shop.entity.ClientProfile;
import com.popov.web_shop.service.ClientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientProfileController {
    private final ClientProfileService clientProfileService;

    @Autowired
    public ClientProfileController(ClientProfileService clientProfileService){
        this.clientProfileService = clientProfileService;
    }
    @PostMapping("/api/clientProfile")
    public ResponseEntity<?> create(@RequestBody ClientProfile clientProfile){
        clientProfileService.create(clientProfile);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/clientProfile")
    public ResponseEntity<List<ClientProfile>> findALL(){
        final List<ClientProfile> clientProfileList = clientProfileService.findAll();
        return clientProfileList != null && !clientProfileList.isEmpty()
                ? new ResponseEntity<>(clientProfileList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/clientProfile/{id}")
    public ResponseEntity<Optional<ClientProfile>> find(@PathVariable(name = "id")Long id){
        final Optional<ClientProfile> clientProfile = clientProfileService.find(id);
        return clientProfile!=null
                ? new ResponseEntity<>(clientProfile, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/clientProfile/{id}")
    public ResponseEntity<?> updateClient(@PathVariable(name = "id")Long id, @RequestBody ClientProfile clientProfileUpdate){
        return clientProfileService.find(id).map(clientProfile -> {
            clientProfile.setBirthday(clientProfileUpdate.getBirthday());
            clientProfile.setFlat(clientProfileUpdate.getFlat());
            clientProfile.setHouse(clientProfileUpdate.getHouse());
            clientProfile.setHousing(clientProfileUpdate.getHousing());
            clientProfile.setStreet(clientProfileUpdate.getStreet());
            clientProfile.setFirstName(clientProfileUpdate.getFirstName());
            clientProfile.setSecondName(clientProfileUpdate.getSecondName());
            clientProfile.setLastName(clientProfileUpdate.getLastName());
            clientProfileService.update(clientProfile);
            return new ResponseEntity<>(clientProfile, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }
}
