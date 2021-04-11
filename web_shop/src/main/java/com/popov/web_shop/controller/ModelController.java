package com.popov.web_shop.controller;

import com.popov.web_shop.entity.Model;
import com.popov.web_shop.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ModelController {
    private final ModelService modelService;

    @Autowired
    public ModelController(ModelService modelService){
        this.modelService = modelService;
    }
    @PostMapping("/api/model")
    public ResponseEntity<?> create(@RequestBody Model model){
        modelService.create(model);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/model")
    public ResponseEntity<List<Model>> findALL(){
        final List<Model> modelList = modelService.findAll();
        return modelList != null && !modelList.isEmpty()
                ? new ResponseEntity<>(modelList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/model/{id}")
    public ResponseEntity<Optional<Model>> find(@PathVariable(name = "id")Long id){
        final Optional<Model> model = modelService.find(id);
        return model!=null
                ? new ResponseEntity<>(model, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/model/{id}")
    public ResponseEntity<?> updateModel(@PathVariable(name = "id")Long id, @RequestBody Model modelUpdate){
        return modelService.find(id).map(model -> {
            model.setArticleNumber(modelUpdate.getArticleNumber());
            model.setCountry(modelUpdate.getCountry());
            model.setName(modelUpdate.getName());
            model.setManufacturer(modelUpdate.getManufacturer());
            modelService.update(model);
            return new ResponseEntity<>(model, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }
}
