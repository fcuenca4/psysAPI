package com.controllers;

import com.models.BlackWhiteListEntity;
import com.services.DecoratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/black_white_list")
public class DecoratorController {

    @Autowired
    private DecoratorService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BlackWhiteListEntity>> getAll() {
        List<BlackWhiteListEntity> toReturn = service.getAll();
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<BlackWhiteListEntity> read(@PathVariable("id") Integer id) {
        BlackWhiteListEntity toReturn = service.read(id);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<BlackWhiteListEntity> create( @RequestBody BlackWhiteListEntity decorator) {
        BlackWhiteListEntity toReturn = service.create(decorator);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }
}


