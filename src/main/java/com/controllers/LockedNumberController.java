package com.controllers;
import com.models.LockedNumberEntity;
import com.services.LockedNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lockedNumbers")
public class LockedNumberController {

    @Autowired
    private LockedNumberService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LockedNumberEntity>> getAll() {
        List<LockedNumberEntity> toReturn = service.getAll();
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<LockedNumberEntity> read(@PathVariable("id") Integer id) {
        LockedNumberEntity toReturn = service.read(id);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<LockedNumberEntity> create( @RequestBody LockedNumberEntity lockedNumber) {
        LockedNumberEntity toReturn = service.create(lockedNumber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

}