package com.controllers;

import com.models.*;
import com.controllers.Modules.subscriberModule;
import com.controllers.Modules.lockedNumberModule;
import com.controllers.Modules.decoratorModule;
import com.controllers.Modules.callHuntingModule;

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
    private subscriberModule subscriberModule;
    @Autowired
    private lockedNumberModule lockedNumberModule;
    @Autowired
    private decoratorModule decoratorModule;
    @Autowired
    private callHuntingModule callHuntingModule;



    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getAllSubscribers() {

        return subscriberModule.getAll(null);
    }
    @RequestMapping(value = "/dn/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getSubscriberByScbDn(@PathVariable("id") Long ScbDn) {
        return subscriberModule.getSubscriberByScbDn(ScbDn);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SubscriberEntity> createSubscriber(@RequestBody SubscriberEntity subscriber) {
        return subscriberModule.create(subscriber);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteSubscriber(@PathVariable("id") Long id) {
        return subscriberModule.delete(id,null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SubscriberEntity> getSubscriber(@PathVariable("id") Long id) {
        return subscriberModule.getOne(id,null);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SubscriberEntity> updateSubscriber(@PathVariable("id") long id, @RequestBody SubscriberEntity entry) {
        return subscriberModule.update(id,entry);
    }

    @RequestMapping(value = "/{id}/lockedNumber", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<LockedNumberEntity>>> getLockedNumberList(@PathVariable("id") long id) {
        return lockedNumberModule.getAll(id);
    }

    @RequestMapping(value = "/{id}/lockedNumber/{lockedNumberID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLockedNumber(@PathVariable("id") Long id, @PathVariable("lockedNumberID") Long lockedNumberID) {
        return lockedNumberModule.delete(id,lockedNumberID);
    }
    @RequestMapping(value = "/{id}/lockedNumber/", method = RequestMethod.POST)
    public ResponseEntity<LockedNumberEntity> createLockedNumber(@RequestBody LockedNumberEntity lockedNumber) {
    return lockedNumberModule.create(lockedNumber);
    }

    @RequestMapping(value = "/{id}/lockedNumber/{lockedNumberID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LockedNumberEntity> getLockedNumber(@PathVariable("id") Long subscriberID, @PathVariable("lockedNumberID") Long lockedNumberID) {
        return lockedNumberModule.getOne(subscriberID,lockedNumberID);
    }
    @RequestMapping(value = "/{id}/lockedNumber/{lockedNumberID}", method = RequestMethod.PUT)
    public ResponseEntity<LockedNumberEntity> updateLockedNumber(@PathVariable("lockedNumberID") long lockedNumberID, @RequestBody LockedNumberEntity entry) {
        return lockedNumberModule.update(lockedNumberID,entry);
    }

    @RequestMapping(value = "/{id}/call_hunting", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<CallHuntingEntity>>> getCallHuntingList(@PathVariable("id") long id) {
    return callHuntingModule.getAll(id);
    }

    @RequestMapping(value = "/{id}/call_hunting/{call_huntingID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCallHunting(@PathVariable("id") Long id, @PathVariable("call_huntingID") Long call_huntingID) {
        return callHuntingModule.delete(id,call_huntingID);
    }
    @RequestMapping(value = "/{id}/call_hunting/", method = RequestMethod.POST)
    public ResponseEntity<CallHuntingEntity> createCallHunting(@RequestBody CallHuntingEntity call_hunting) {
        return callHuntingModule.create(call_hunting);

    }

    @RequestMapping(value = "/{id}/call_hunting/{call_huntingID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CallHuntingEntity> getCallHunting(@PathVariable("id") Long subscriberID, @PathVariable("call_huntingID") Long call_huntingID) {
        return callHuntingModule.getOne(subscriberID,call_huntingID);

    }
    @RequestMapping(value = "/{id}/call_hunting/{call_huntingID}", method = RequestMethod.PUT)
    public ResponseEntity<CallHuntingEntity> updateCallHunting(@PathVariable("call_huntingID") long call_huntingID, @RequestBody CallHuntingEntity entry) {
        return callHuntingModule.update(call_huntingID,entry);

    }
    @RequestMapping(value = "/{id}/black_white_list", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<BlackWhiteListEntity>>> getBlackWhiteList(@PathVariable("id") long id) {
    return decoratorModule.getAll(id);
    }
    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBlackWhiteList(@PathVariable("id") Long id, @PathVariable("black_white_listID") Long black_white_listID) {
        return decoratorModule.delete(id,black_white_listID);
    }
    @RequestMapping(value = "/{id}/black_white_list/", method = RequestMethod.POST)
    public ResponseEntity<BlackWhiteListEntity> createBlackWhiteList(@RequestBody BlackWhiteListEntity black_white_list) {
        return decoratorModule.create(black_white_list);
    }

    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlackWhiteListEntity> getBlackWhiteList(@PathVariable("id") Long subscriberID, @PathVariable("black_white_listID") Long black_white_listID) {
        return decoratorModule.getOne(subscriberID,black_white_listID);
    }
    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.PUT)
    public ResponseEntity<BlackWhiteListEntity> updateBlackWhiteList(@PathVariable("black_white_listID") long black_white_listID, @RequestBody BlackWhiteListEntity entry) {
        return decoratorModule.update(black_white_listID,entry);
    }


}



