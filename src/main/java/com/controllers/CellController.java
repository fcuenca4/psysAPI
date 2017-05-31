package com.controllers;

/**
 * Created by fcuenca on 5/31/17.
 */

import com.controllers.util.ResponseDATA;
import com.models.CellEntity;
import com.repositories.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cell")
public class CellController {
    @Autowired
    CellRepository repository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<CellEntity>>> getAll(){
        List<CellEntity> allObjects= this.repository.findAll();
        return new ResponseEntity<>(new ResponseDATA<>(allObjects,allObjects.size()), HttpStatus.OK);
    }
}
