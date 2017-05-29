package com.controllers.crud;

import com.models.CallHuntingEntity;
import com.controllers.util.ResponseDATA;
import com.models.SubscriberEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class callHuntingModule extends baseModule<CallHuntingEntity> {
    @Override
    public ResponseEntity<ResponseDATA<List<CallHuntingEntity>>> getAll(Long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        if (subscriber != null) {
            List<CallHuntingEntity> toRet = callHuntingService.findAllByLckScbId(id);
            if (subscriber != null)
                return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ResponseDATA<List<CallHuntingEntity>>> create(List<CallHuntingEntity> entity) {
        boolean _CONFLICT = false;
        List<CallHuntingEntity> toReturn = new LinkedList<>();
        if (!entity.isEmpty()) {
            for (CallHuntingEntity e : entity) {
                if (e.getChtId() != 0 && callHuntingService.exists(e))
                    _CONFLICT = true;
                else
                    toReturn.add(callHuntingService.create(e));
            }
        }
        if (_CONFLICT)
            return new ResponseEntity<>(new ResponseDATA<>(toReturn, toReturn.size()), HttpStatus.CONFLICT);
        return new ResponseEntity<>(new ResponseDATA<>(toReturn, toReturn.size()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CallHuntingEntity> createOne(CallHuntingEntity entity) {
        if (callHuntingService.exists(entity))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        CallHuntingEntity toReturn = callHuntingService.create(entity);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(List<Long> idList, Long lockedNumberID) {
        for (Long id : idList) {
            CallHuntingEntity toRet = callHuntingService.findByChtIdAndChtScbId(id, lockedNumberID);
            if (toRet != null)
                callHuntingService.delete(toRet.getChtId());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<CallHuntingEntity> getOne(Long id, Long call_huntingID) {
        CallHuntingEntity toRet = callHuntingService.findByChtIdAndChtScbId(id, call_huntingID);
        if (toRet != null)
            return new ResponseEntity<>(toRet, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<CallHuntingEntity> update(Long call_huntingID, CallHuntingEntity entity) {
        CallHuntingEntity current = callHuntingService.getOne(call_huntingID);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        CallHuntingEntity toReturn = callHuntingService.update(entity, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}