package com.controllers.Modules;

import com.models.LockedNumberEntity;
import com.models.ResponseDATA;
import com.models.SubscriberEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by frcue on 26/5/2017.
 */
@Component
public class lockedNumberModule extends baseModule<LockedNumberEntity>{
    @Override
    public ResponseEntity<ResponseDATA<List<LockedNumberEntity>>> getAll(Long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        List<LockedNumberEntity> toRet = lockedNumberService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @Override
    public ResponseEntity<LockedNumberEntity> create( LockedNumberEntity lockedNumber ) {
        if (lockedNumberService.exists(lockedNumber))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        LockedNumberEntity toReturn = lockedNumberService.create(lockedNumber);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(Long id,Long lockedNumberID) {
        LockedNumberEntity toRet = lockedNumberService.findByLckIdAndLckScbId(id, lockedNumberID);
        if (toRet != null)
            lockedNumberService.delete(toRet.getLckId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<LockedNumberEntity> getOne(Long subscriberID,Long lockedNumberID) {
        LockedNumberEntity toRet = lockedNumberService.findByLckIdAndLckScbId(subscriberID, lockedNumberID);
        if (toRet != null)
            return new ResponseEntity<>(toRet, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<LockedNumberEntity> update(Long lockedNumberID, LockedNumberEntity entity) {
        LockedNumberEntity current = lockedNumberService.getOne(lockedNumberID);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        LockedNumberEntity toReturn = lockedNumberService.update(entity, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);

    }
}
