package com.controllers;

import com.models.*;
import com.services.CallHuntingService;
import com.services.DecoratorService;
import com.services.LockedNumberService;
import com.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;
    @Autowired
    private CallHuntingService callHuntingService;
    @Autowired
    private DecoratorService decoratorService;
    @Autowired
    private LockedNumberService lockedNumberService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getAll() {
        List<SubscriberEntity> subscribers = subscriberService.getAll();
        return new ResponseEntity<>(new ResponseDATA<>(subscribers, subscribers.size()), HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SubscriberEntity> create(@RequestBody SubscriberEntity subscriber) {
        if (subscriberService.exists(subscriber))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        SubscriberEntity toReturn = subscriberService.create(subscriber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        subscriberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriberEntity> read(@PathVariable("id") Long id) {
        SubscriberEntity toReturn = subscriberService.getOne(id);
        if (toReturn != null)
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubscriberEntity> update(@PathVariable("id") long id, @RequestBody SubscriberEntity entry) {
        SubscriberEntity current = subscriberService.getOne(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SubscriberEntity toReturn = subscriberService.update(entry, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/lockedNumber", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<LockedNumberEntity>>> getLockedNumberList(@PathVariable("id") long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        List<LockedNumberEntity> toRet = lockedNumberService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/call_hunting", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<CallHuntingEntity>>> getcallHuntingList(@PathVariable("id") long id) {
        CallHuntingEntity subscriber = callHuntingService.getOne(id);
        List<CallHuntingEntity> toRet = callHuntingService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/black_white_list", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<BlackWhiteListEntity>>> getBlackWhiteList(@PathVariable("id") long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        List<BlackWhiteListEntity> toRet = decoratorService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}



