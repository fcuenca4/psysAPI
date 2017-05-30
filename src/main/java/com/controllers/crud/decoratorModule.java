package com.controllers.crud;

import com.controllers.util.ResponseDATA;
import com.models.BlackWhiteListEntity;
import com.models.SubscriberEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class decoratorModule extends baseModule<BlackWhiteListEntity> {
    @Override
    public ResponseEntity<ResponseDATA<List<BlackWhiteListEntity>>> getAll(Long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        if (subscriber != null) {

            List<BlackWhiteListEntity> toRet = decoratorService.findAllByLckScbId(id);
            if (subscriber != null)
                return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Deprecated
    public ResponseEntity<ResponseDATA<List<BlackWhiteListEntity>>> create(List<BlackWhiteListEntity> entity) {
        boolean _CONFLICT = false;
        List<BlackWhiteListEntity> toReturn = new LinkedList<>();
        if (!entity.isEmpty()) {
            for (BlackWhiteListEntity e : entity) {
                if (decoratorService.exists(e))
                    _CONFLICT = true;
                else
                    toReturn.add(decoratorService.create(e));
            }
        }
        if (_CONFLICT)
            return new ResponseEntity<>(new ResponseDATA<>(toReturn, toReturn.size()), HttpStatus.CONFLICT);
        return new ResponseEntity<>(new ResponseDATA<>(toReturn, toReturn.size()), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BlackWhiteListEntity> createOne(BlackWhiteListEntity entity) {
        if (decoratorService.exists(entity))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        BlackWhiteListEntity toReturn = decoratorService.create(entity);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(List<Long> idList, Long lockedNumberID) {
        for (Long id : idList) {
            BlackWhiteListEntity toRet = decoratorService.findByBwlIdAndBwlScbId(id, lockedNumberID);
            if (toRet != null)
                decoratorService.delete(toRet.getBwlId());
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<BlackWhiteListEntity> getOne(Long subscriberID, Long black_white_listID) {
        BlackWhiteListEntity toRet = decoratorService.findByBwlIdAndBwlScbId(subscriberID, black_white_listID);
        if (toRet != null)
            return new ResponseEntity<>(toRet, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<BlackWhiteListEntity> update(Long black_white_listID, BlackWhiteListEntity entity) {
        BlackWhiteListEntity current = decoratorService.getOne(black_white_listID);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        BlackWhiteListEntity toReturn = decoratorService.update(entity, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}
