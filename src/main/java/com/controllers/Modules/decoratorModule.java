package com.controllers.Modules;

import com.models.BlackWhiteListEntity;
import com.models.ResponseDATA;
import com.models.SubscriberEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class decoratorModule extends baseModule<BlackWhiteListEntity> {
    @Override
    public ResponseEntity<ResponseDATA<List<BlackWhiteListEntity>>> getAll(Long id) {
        SubscriberEntity subscriber = subscriberService.getOne(id);
        List<BlackWhiteListEntity> toRet = decoratorService.findAllByLckScbId(id);
        if (subscriber != null)
            return new ResponseEntity<>(new ResponseDATA<>(toRet, toRet.size()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<BlackWhiteListEntity> create(BlackWhiteListEntity entity) {
        if (decoratorService.exists(entity))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        BlackWhiteListEntity toReturn = decoratorService.create(entity);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(Long id, Long black_white_listID) {
        BlackWhiteListEntity toRet = decoratorService.findByBwlIdAndBwlScbId(id, black_white_listID);
        if (toRet != null)
            decoratorService.delete(toRet.getBwlId());
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
