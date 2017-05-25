package com.controllers;

import com.models.SubscriberEntity;
import com.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberService service;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<SubscriberEntity>> getAll() {
        List<SubscriberEntity> subscribers = service.getAll();
        return new ResponseEntity<>(subscribers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriberEntity> read(@PathVariable("id") Long id) {
        SubscriberEntity toReturn = service.getOne(id);
        if (toReturn != null)
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SubscriberEntity> create(@RequestBody SubscriberEntity subscriber) {
        if (service.exists(subscriber))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        SubscriberEntity toReturn = service.create(subscriber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubscriberEntity> update(@PathVariable("id") long id, @RequestBody SubscriberEntity entry) {
        SubscriberEntity current = service.getOne(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SubscriberEntity toReturn =service.update(entry,current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}


