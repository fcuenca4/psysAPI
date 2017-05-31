package com.controllers;

import com.exceptions.EntityAlreadyExistsException;
import com.exceptions.EntityNotFoundException;
import com.models.CallHuntingEntity;
import com.services.CallHuntingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/call_hunting")
public class CallHuntingController {

    @Autowired
    private CallHuntingService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CallHuntingEntity>> getAll() {
        List<CallHuntingEntity> callHunting = service.getAll();
        return new ResponseEntity<>(callHunting, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CallHuntingEntity> read(@PathVariable("id") Long id) {
        CallHuntingEntity toReturn = service.getOne(id);
        if (toReturn != null)
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        else
            throw new EntityNotFoundException("call hunting not found",null);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CallHuntingEntity> create(@RequestBody CallHuntingEntity callHunting) {
        if (service.exists(callHunting))
            throw new EntityAlreadyExistsException("call hunting already exists",null);
        CallHuntingEntity toReturn = service.create(callHunting);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<CallHuntingEntity> update(@PathVariable("id") long id, @RequestBody CallHuntingEntity entry) {
        CallHuntingEntity current = service.getOne(id);
        if (current == null) {
            throw new EntityNotFoundException("call hunting not found",null);
        }
        CallHuntingEntity toReturn = service.update(entry, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}


