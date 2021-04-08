package com.popov.web_shop.service;

import com.popov.web_shop.entity.Model;
import com.popov.web_shop.repo.ModelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {
    @Autowired
    private ModelRepo modelRepo;

    public void create(Model model){modelRepo.save(model);}

    public void update(Model model){modelRepo.save(model);}

    public void delete(Model model){modelRepo.delete(model);}

    public Optional<Model> find(Long id){return modelRepo.findById(id);}

    public List<Model> findAll(){return modelRepo.findAll();}
}
