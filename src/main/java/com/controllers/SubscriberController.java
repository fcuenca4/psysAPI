package com.controllers;

import com.controllers.util.ResponseDATA;
import com.exceptions.EntityAlreadyExistsException;
import com.models.*;
import com.controllers.crud.subscriberModule;
import com.controllers.crud.lockedNumberModule;
import com.controllers.crud.decoratorModule;
import com.controllers.crud.callHuntingModule;

import org.springframework.beans.factory.annotation.Autowired;
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
    /*
    * TODO: VER FILTROS
    * */
    @RequestMapping(value = "/dn/{id}", method = RequestMethod.GET)
    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getSubscriberByScbDn(@PathVariable("id") String ScbDn) {
        return subscriberModule.getSubscriberByScbDn(ScbDn);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<SubscriberEntity> createSubscriber(@RequestBody SubscriberEntity subscriber) throws EntityAlreadyExistsException {
        return subscriberModule.createOne(subscriber);
    }

//    @RequestMapping(value = "", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> deleteSubscriber(@RequestBody List<Long> subscriberDELETEList) {
//        return subscriberModule.delete(subscriberDELETEList,null);
//    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOneSubscriber(@PathVariable("id") Long subscriberID) {
        return subscriberModule.deleteOne(null,subscriberID);
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

//    @RequestMapping(value = "/{id}/lockedNumber/", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> deleteLockedNumber(@PathVariable("id") Long subscriberId, @RequestBody List<Long> lockedNumberDELETEList) {
//        return lockedNumberModule.delete(lockedNumberDELETEList,subscriberId);
//    }
    @RequestMapping(value = "/{id}/lockedNumber/{lockedNumber}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLockedNumber(@PathVariable("id") long subscriberID, @PathVariable("lockedNumber") long lockedNumberID) {
    return lockedNumberModule.deleteOne(lockedNumberID,subscriberID);
}

    @RequestMapping(value = "/{id}/lockedNumber", method = RequestMethod.POST)
    public ResponseEntity<LockedNumberEntity> createlockedNumber(@RequestBody LockedNumberEntity entity) {
        return lockedNumberModule.createOne(entity);
    }
    /* public ResponseEntity<ResponseDATA<List<LockedNumberEntity>>> createLockedNumber(@RequestBody List<LockedNumberEntity> lockedNumberCREATEList) {
    return lockedNumberModule.create(lockedNumberCREATEList);
    }*/


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

//    @RequestMapping(value = "/{id}/call_hunting/", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> deleteCallHunting(@PathVariable("id") Long subscriberID, @RequestBody List<Long> callHuntingDELETEList) {
//        return callHuntingModule.delete(callHuntingDELETEList,subscriberID);
//    }
    @RequestMapping(value = "/{id}/call_hunting/{call_huntingID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteCall_hunting(@PathVariable("id") long subscriberID, @PathVariable("call_huntingID") long call_huntingID) {
    return callHuntingModule.deleteOne(call_huntingID,subscriberID);
}


    @RequestMapping(value = "/{id}/call_hunting", method = RequestMethod.POST)
    public ResponseEntity<CallHuntingEntity> createCallHunting(@RequestBody CallHuntingEntity entity) {
        return callHuntingModule.createOne(entity);
    }
//        public ResponseEntity<ResponseDATA<List<CallHuntingEntity>>> createCallHunting(@RequestBody List<CallHuntingEntity> call_huntingCREATEList) {
//        return callHuntingModule.create(call_huntingCREATEList);
//    }

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
//    @RequestMapping(value = "/{id}/black_white_list", method = RequestMethod.DELETE)
//    public ResponseEntity<Void> deleteBlackWhiteList(@PathVariable("id") Long subscriberID, @RequestBody List<Long> blackWhiteDELETEList) {
//        return decoratorModule.delete(blackWhiteDELETEList,subscriberID);
//    }
    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBlackWhiteList(@PathVariable("id") long subscriberID, @PathVariable("black_white_listID") long black_white_listID) {
        return decoratorModule.deleteOne(black_white_listID,subscriberID);
    }


    @RequestMapping(value = "/{id}/black_white_list", method = RequestMethod.POST)
    public ResponseEntity<BlackWhiteListEntity> createBlackWhiteList(@RequestBody BlackWhiteListEntity entity) {
        return decoratorModule.createOne(entity);
    }
    //    public ResponseEntity<ResponseDATA<List<BlackWhiteListEntity>>> createBlackWhiteList(@RequestBody List<BlackWhiteListEntity> black_white_listCREATEList) {
    //        return decoratorModule.create(black_white_listCREATEList);
    //    }

    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BlackWhiteListEntity> getBlackWhiteList(@PathVariable("id") Long subscriberID, @PathVariable("black_white_listID") Long black_white_listID) {
        return decoratorModule.getOne(subscriberID,black_white_listID);
    }
    @RequestMapping(value = "/{id}/black_white_list/{black_white_listID}", method = RequestMethod.PUT)
    public ResponseEntity<BlackWhiteListEntity> updateBlackWhiteList(@PathVariable("black_white_listID") long black_white_listID, @RequestBody BlackWhiteListEntity entry) {
        return decoratorModule.update(black_white_listID,entry);
    }


}



