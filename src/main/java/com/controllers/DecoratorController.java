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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<BlackWhiteListEntity>> getAll() {
        List<BlackWhiteListEntity> blackWhiteList = service.getAll();
        return new ResponseEntity<>(blackWhiteList, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlackWhiteListEntity> read(@PathVariable("id") Long id) {
        BlackWhiteListEntity toReturn = service.getOne(id);
        if (toReturn != null)
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<BlackWhiteListEntity> create(@RequestBody BlackWhiteListEntity blackWhiteList) {
        if (service.exists(blackWhiteList))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        BlackWhiteListEntity toReturn = service.create(blackWhiteList);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BlackWhiteListEntity> update(@PathVariable("id") long id, @RequestBody BlackWhiteListEntity entry) {
        BlackWhiteListEntity current = service.getOne(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BlackWhiteListEntity toReturn =service.update(entry,current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}


