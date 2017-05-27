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
    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getAllSubscribers() {
        List<SubscriberEntity> subscribers = subscriberService.getAll();
        return new ResponseEntity<>(new ResponseDATA<>(subscribers, subscribers.size()), HttpStatus.OK);
    }
    @RequestMapping(value = "/dn/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getSubscriberByScbDn(@PathVariable("id") Long ScbDn) {
        List<SubscriberEntity> toReturn = subscriberService.getAllByScbDn(ScbDn);
        if (toReturn != null)
            return new ResponseEntity<>(new ResponseDATA<>(toReturn,toReturn.size()), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SubscriberEntity> createSubscriber(@RequestBody SubscriberEntity subscriber) {
        if (subscriber.getScbId() != 0 && subscriberService.exists(subscriber))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        SubscriberEntity toReturn = subscriberService.create(subscriber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubscriber(@PathVariable("id") Long id) {
        subscriberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriberEntity> getSubscriber(@PathVariable("id") Long id) {
        SubscriberEntity toReturn = subscriberService.getOne(id);
        if (toReturn != null)
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubscriberEntity> updateSubscriber(@PathVariable("id") long id, @RequestBody SubscriberEntity entry) {
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

    @RequestMapping(value = "/{id}/lockedNumber/{lockedNumberID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLockedNumber(@PathVariable("id") Long id, @PathVariable("lockedNumberID") Long lockedNumberID) {
        LockedNumberEntity toRet = lockedNumberService.findByLckIdAndLckScbId(id, lockedNumberID);
        if (toRet != null)
            lockedNumberService.delete(toRet.getLckId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/{id}/lockedNumber/", method = RequestMethod.POST)
    public ResponseEntity<LockedNumberEntity> createLockedNumber(@RequestBody LockedNumberEntity lockedNumber) {
        if (lockedNumberService.exists(lockedNumber))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        LockedNumberEntity toReturn = lockedNumberService.create(lockedNumber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/lockedNumber/{lockedNumberID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LockedNumberEntity> getLockedNumber(@PathVariable("id") Long subscriberID, @PathVariable("lockedNumberID") Long lockedNumberID) {
        LockedNumberEntity toRet = lockedNumberService.findByLckIdAndLckScbId(subscriberID, lockedNumberID);
        if (toRet != null)
            return new ResponseEntity<>(toRet, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}/lockedNumber/{lockedNumberID}", method = RequestMethod.PUT)
    public ResponseEntity<LockedNumberEntity> updateLockedNumber(@PathVariable("lockedNumberID") long lockedNumberID, @RequestBody LockedNumberEntity entry) {
        LockedNumberEntity current = lockedNumberService.getOne(lockedNumberID);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LockedNumberEntity toReturn = lockedNumberService.update(entry, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/call_hunting", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<CallHuntingEntity>>> getCallHuntingList(@PathVariable("id") long id) {
        CallHuntingEntity subscriber = callHuntingService.getOne(id);
        List<CallHuntingEntity> toRet = callHuntingService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/call_hunting/{call_huntingID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCallHunting(@PathVariable("id") Long id, @PathVariable("call_huntingID") Long call_huntingID) {
        CallHuntingEntity toRet = callHuntingService.findByChtIdAndChtScbId(id, call_huntingID);
        if (toRet != null)
            callHuntingService.delete(toRet.getChtId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/{id}/call_hunting/", method = RequestMethod.POST)
    public ResponseEntity<CallHuntingEntity> createCallHunting(@RequestBody CallHuntingEntity call_hunting) {
        if (callHuntingService.exists(call_hunting))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        CallHuntingEntity toReturn = callHuntingService.create(call_hunting);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/call_hunting/{call_huntingID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CallHuntingEntity> getCallHunting(@PathVariable("id") Long subscriberID, @PathVariable("call_huntingID") Long call_huntingID) {
        CallHuntingEntity toRet = callHuntingService.findByChtIdAndChtScbId(subscriberID, call_huntingID);
        if (toRet != null)
            return new ResponseEntity<>(toRet, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}/call_hunting/{call_huntingID}", method = RequestMethod.PUT)
    public ResponseEntity<CallHuntingEntity> updateCallHunting(@PathVariable("call_huntingID") long call_huntingID, @RequestBody CallHuntingEntity entry) {
        CallHuntingEntity current = callHuntingService.getOne(call_huntingID);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CallHuntingEntity toReturn = callHuntingService.update(entry, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
    @RequestMapping(value = "/{id}/black_white_list", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<BlackWhiteListEntity>>> getBlackWhiteList(@PathVariable("id") long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        List<BlackWhiteListEntity> toRet = decoratorService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBlackWhiteList(@PathVariable("id") Long id, @PathVariable("black_white_listID") Long black_white_listID) {
        BlackWhiteListEntity toRet = decoratorService.findByBwlIdAndBwlScbId(id, black_white_listID);
        if (toRet != null)
            decoratorService.delete(toRet.getBwlId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @RequestMapping(value = "/{id}/black_white_list/", method = RequestMethod.POST)
    public ResponseEntity<BlackWhiteListEntity> createBlackWhiteList(@RequestBody BlackWhiteListEntity black_white_list) {
        if (decoratorService.exists(black_white_list))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        BlackWhiteListEntity toReturn = decoratorService.create(black_white_list);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlackWhiteListEntity> getBlackWhiteList(@PathVariable("id") Long subscriberID, @PathVariable("black_white_listID") Long black_white_listID) {
        BlackWhiteListEntity toRet = decoratorService.findByBwlIdAndBwlScbId(subscriberID, black_white_listID);
        if (toRet != null)
            return new ResponseEntity<>(toRet, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.PUT)
    public ResponseEntity<BlackWhiteListEntity> updateBlackWhiteList(@PathVariable("black_white_listID") long black_white_listID, @RequestBody BlackWhiteListEntity entry) {
        BlackWhiteListEntity current = decoratorService.getOne(black_white_listID);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BlackWhiteListEntity toReturn = decoratorService.update(entry, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }


}



