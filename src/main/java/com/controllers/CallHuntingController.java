package com.controllers;
import com.models.CallHuntingEntity;
import com.services.CallHuntingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/call_hunting")
public class CallHuntingController {

    @Autowired
    private CallHuntingService service;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CallHuntingEntity>> getAll() {
        List<CallHuntingEntity> toReturn = service.getAll();
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<CallHuntingEntity> read(@PathVariable("id") Integer id) {
        CallHuntingEntity toReturn = service.read(id);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<CallHuntingEntity> create( @RequestBody CallHuntingEntity callhunting) {
        CallHuntingEntity toReturn = service.create(callhunting);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

}


