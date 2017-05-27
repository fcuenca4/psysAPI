package com.controllers.Modules;

import com.models.CallHuntingEntity;
import com.models.ResponseDATA;
import org.apache.tomcat.util.modeler.BaseModelMBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by frcue on 26/5/2017.
 */
@Component
public class callHuntingModule extends baseModule<CallHuntingEntity>{
    @Override
    public ResponseEntity<ResponseDATA<List<CallHuntingEntity>>> getAll(Long id) {
        CallHuntingEntity subscriber = callHuntingService.getOne(id);
        List<CallHuntingEntity> toRet = callHuntingService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<CallHuntingEntity> create(CallHuntingEntity entity) {
        if (callHuntingService.exists(entity))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        CallHuntingEntity toReturn = callHuntingService.create(entity);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(Long id, Long call_huntingID) {
        CallHuntingEntity toRet = callHuntingService.findByChtIdAndChtScbId(id, call_huntingID);
        if (toRet != null)
            callHuntingService.delete(toRet.getChtId());
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
