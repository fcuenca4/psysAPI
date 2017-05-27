package com.controllers.Modules;

import com.models.ResponseDATA;
import com.models.SubscriberEntity;
import com.services.CallHuntingService;
import com.services.DecoratorService;
import com.services.LockedNumberService;
import com.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public abstract class baseModule<T> {
    @Autowired
    protected SubscriberService subscriberService;
    @Autowired
    protected CallHuntingService callHuntingService;
    @Autowired
    protected DecoratorService decoratorService;
    @Autowired
    protected LockedNumberService lockedNumberService;

    public abstract ResponseEntity<ResponseDATA<List<T>>> getAll(Long id);
    public abstract ResponseEntity<T> create(T entity);
    public abstract ResponseEntity<Void> delete(Long id, Long extraID);
    public abstract ResponseEntity<T> getOne(Long id, Long extraID);
    public abstract ResponseEntity<T> update(Long id, T entity);

}

