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

    @GetMapping
    @RequestMapping(value = "")
    public ResponseEntity<List<SubscriberEntity>> getAll() {
        List<SubscriberEntity> subscribers = subscriberService.getAll();
        return new ResponseEntity<>(subscribers, HttpStatus.OK);
    }

    @DeleteMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        subscriberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriberEntity> read(@PathVariable("id") Integer id) {
        SubscriberEntity toReturn = subscriberService.read(id);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SubscriberEntity> create( @RequestBody SubscriberEntity subscriber) {
        SubscriberEntity toReturn = subscriberService.create(subscriber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

}


