package com.popov.web_shop.controller;

import com.popov.web_shop.entity.ModelInfo;
import com.popov.web_shop.service.ModelInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ModelInfoController {
    private final ModelInfoService modelInfoService;

    @Autowired
    public ModelInfoController(ModelInfoService modelInfoService){
        this.modelInfoService = modelInfoService;
    }
    @PostMapping("/api/modelInfo")
    public ResponseEntity<?> create(@RequestBody ModelInfo modelInfo){
        modelInfoService.create(modelInfo);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/api/modelInfo")
    public ResponseEntity<List<ModelInfo>> findALL(){
        final List<ModelInfo> modelInfoList = modelInfoService.findAll();
        return modelInfoList != null && !modelInfoList.isEmpty()
                ? new ResponseEntity<>(modelInfoList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/api/modelInfo/{id}")
    public ResponseEntity<Optional<ModelInfo>> find(@PathVariable(name = "id")Long id){
        final Optional<ModelInfo> modelInfo = modelInfoService.find(id);
        return modelInfo!=null
                ? new ResponseEntity<>(modelInfo, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/api/modelInfo/{id}")
    public ResponseEntity<?> updateModelInfo(@PathVariable(name = "id")Long id, @RequestBody ModelInfo modelInfoUpdate){
        return modelInfoService.find(id).map(modelInfo -> {
            modelInfo.setAmount(modelInfoUpdate.getAmount());
            modelInfo.setColour(modelInfoUpdate.getColour());
            modelInfo.setModel(modelInfoUpdate.getModel());
            modelInfo.setPrice(modelInfoUpdate.getPrice());
            modelInfoService.update(modelInfo);
            return new ResponseEntity<>(modelInfo, HttpStatus.OK);
        }).orElseThrow(() -> new IllegalArgumentException());
    }
}
