package com.controllers;

import com.exceptions.EntityAlreadyExistsException;
import com.exceptions.EntityNotFoundException;
import com.models.LockedNumberEntity;
import com.services.LockedNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/lockedNumbers")
public class LockedNumberController {

    @Autowired
    private LockedNumberService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<LockedNumberEntity>> getAll() {
        List<LockedNumberEntity> lockedNumbers = service.getAll();
        return new ResponseEntity<>(lockedNumbers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LockedNumberEntity> read(@PathVariable("id") Long id) {
        LockedNumberEntity toReturn = service.getOne(id);
        if (toReturn != null)
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        else
            throw new EntityNotFoundException("locked number not found",null);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<LockedNumberEntity> create(@RequestBody LockedNumberEntity lockedNumber) {
        if (service.exists(lockedNumber))
            throw new EntityAlreadyExistsException("locked number already exists",null);
        LockedNumberEntity toReturn = service.create(lockedNumber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LockedNumberEntity> update(@PathVariable("id") long id, @RequestBody LockedNumberEntity entry) {
        LockedNumberEntity current = service.getOne(id);
        if (current == null) {
            throw new EntityNotFoundException("locked number not found",null);
        }
        LockedNumberEntity toReturn = service.update(entry, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}


