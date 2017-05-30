package com.controllers;

import com.controllers.util.ResponseDATA;
import com.models.ZoneCellEntity;
import com.repositories.ZoneCellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/zonecell")

public class ZoneCellController {
    @Autowired
    ZoneCellRepository repository;
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<ZoneCellEntity>>> getAll(){
        List<ZoneCellEntity> allObjects= this.repository.findAll();
        return new ResponseEntity<>(new ResponseDATA<>(allObjects,allObjects.size()), HttpStatus.OK);
    }
}