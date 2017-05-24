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
    private SubscriberService subscriberService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SubscriberEntity>> getAll() {
        List<SubscriberEntity> subscribers = subscriberService.getAll();
        return new ResponseEntity<>(subscribers, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        subscriberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<SubscriberEntity> read(@PathVariable("id") Integer id) {
        SubscriberEntity toReturn = subscriberService.read(id);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public ResponseEntity<SubscriberEntity> create( @RequestBody SubscriberEntity subscriber) {
        SubscriberEntity toReturn = subscriberService.create(subscriber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

}


