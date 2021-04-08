package com.popov.web_shop.service;

import com.popov.web_shop.entity.Client;
import com.popov.web_shop.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepo clientRepo;

    public void create(Client client){clientRepo.save(client);}

    public void update(Client client){clientRepo.save(client);}

    public void delete(Client client){clientRepo.delete(client);}

    public Optional<Client> find(Long id){return clientRepo.findById(id);}

    public List<Client> findAll(){return clientRepo.findAll();}
}
