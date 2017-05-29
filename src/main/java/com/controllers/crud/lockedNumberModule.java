package com.controllers.crud;

import com.models.LockedNumberEntity;
import com.controllers.util.ResponseDATA;
import com.models.SubscriberEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class lockedNumberModule extends baseModule<LockedNumberEntity> {
    @Override
    public ResponseEntity<ResponseDATA<List<LockedNumberEntity>>> getAll(Long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        if (subscriber != null) {
            List<LockedNumberEntity> toRet = lockedNumberService.findAllByLckScbId(id);
            if (subscriber != null)
                return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ResponseDATA<List<LockedNumberEntity>>> create(List<LockedNumberEntity> entity) {
        boolean _CONFLICT = false;
        List<LockedNumberEntity> toReturn = new LinkedList<>();
        if (!entity.isEmpty()) {
            for (LockedNumberEntity e : entity) {
                if (e.getLckId() != 0 && lockedNumberService.exists(e)) {
                    _CONFLICT = true;
                } else
                    toReturn.add(lockedNumberService.create(e));
            }
        }
        if (_CONFLICT)
            return new ResponseEntity<>(new ResponseDATA<>(toReturn, toReturn.size()), HttpStatus.CONFLICT);
        return new ResponseEntity<>(new ResponseDATA<>(toReturn, toReturn.size()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<LockedNumberEntity> createOne(LockedNumberEntity entity) {
        if (lockedNumberService.exists(entity))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        LockedNumberEntity toReturn = lockedNumberService.create(entity);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(List<Long> idList, Long lockedNumberID) {
        for (Long id : idList) {
            LockedNumberEntity toRet = lockedNumberService.findByLckIdAndLckScbId(id, lockedNumberID);
            if (toRet != null)
                lockedNumberService.delete(toRet.getLckId());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<LockedNumberEntity> getOne(Long subscriberID, Long lockedNumberID) {
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
