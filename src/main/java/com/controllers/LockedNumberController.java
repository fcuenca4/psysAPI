package com.controllers;

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
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
//        service.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<LockedNumberEntity> read(@PathVariable("id") Long id) {
//        LockedNumberEntity toReturn = service.getOne(id);
//        if (toReturn != null)
//            return new ResponseEntity<>(toReturn, HttpStatus.OK);
//        else
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<LockedNumberEntity> create(@RequestBody LockedNumberEntity lockedNumber) {
        if (service.exists(lockedNumber))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        LockedNumberEntity toReturn = service.create(lockedNumber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<LockedNumberEntity> update(@PathVariable("id") long id, @RequestBody LockedNumberEntity entry) {
        LockedNumberEntity current = service.getOne(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LockedNumberEntity toReturn = service.update(entry, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}


