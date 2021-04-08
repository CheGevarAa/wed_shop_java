package com.popov.web_shop.service;

import com.popov.web_shop.entity.ModelInfo;
import com.popov.web_shop.repo.ModelInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelInfoService {
    @Autowired
    private ModelInfoRepo modelInfoRepo;

    public void create(ModelInfo modelInfo){modelInfoRepo.save(modelInfo);}

    public void update(ModelInfo modelInfo){modelInfoRepo.save(modelInfo);}

    public void delete(ModelInfo modelInfo){modelInfoRepo.delete(modelInfo);}

    public Optional<ModelInfo> find(Long id){return modelInfoRepo.findById(id);}

    public List<ModelInfo> findAll(){return modelInfoRepo.findAll();}
}
