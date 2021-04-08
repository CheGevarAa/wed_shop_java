package com.popov.web_shop.service;

import com.popov.web_shop.entity.ClientRole;
import com.popov.web_shop.repo.ClientRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientRoleService {
    @Autowired
    private ClientRoleRepo clientRoleRepo;

    public void create(ClientRole clientRole){clientRoleRepo.save(clientRole);}

    public void update(ClientRole clientRole){clientRoleRepo.save(clientRole);}

    public void delete(ClientRole clientRole){clientRoleRepo.delete(clientRole);}

    public Optional<ClientRole> find(Long id){return clientRoleRepo.findById(id);}

    public List<ClientRole> findAll(){return clientRoleRepo.findAll();}
}
