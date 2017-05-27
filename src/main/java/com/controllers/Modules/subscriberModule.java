package com.controllers.Modules;

import com.models.ResponseDATA;
import com.models.SubscriberEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Component
public class subscriberModule extends baseModule<SubscriberEntity> {

    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getSubscriberByScbDn(@PathVariable("id") Long ScbDn) {
        List<SubscriberEntity> toReturn = subscriberService.getAllByScbDn(ScbDn);
        if (toReturn != null)
            return new ResponseEntity<>(new ResponseDATA<>(toReturn, toReturn.size()), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<ResponseDATA<List<SubscriberEntity>>> getAll(Long not_used_here) {
        List<SubscriberEntity> subscribers = subscriberService.getAll();
        return new ResponseEntity<>(new ResponseDATA<>(subscribers, subscribers.size()), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SubscriberEntity> create(SubscriberEntity entity) {
        if (entity.getScbId() != 0 && subscriberService.exists(entity))
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        SubscriberEntity toReturn = subscriberService.create(entity);
        return new ResponseEntity<>(toReturn, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> delete(Long id,Long not_used_here) {
        subscriberService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<SubscriberEntity> getOne(Long id, Long not_used_here) {
        SubscriberEntity toReturn = subscriberService.getOne(id);
        if (toReturn != null)
            return new ResponseEntity<>(toReturn, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<SubscriberEntity> update(Long id, SubscriberEntity entity) {
        SubscriberEntity current = subscriberService.getOne(id);
        if (current == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        SubscriberEntity toReturn = subscriberService.update(entity, current);
        return new ResponseEntity<>(toReturn, HttpStatus.OK);
    }
}
