package com.services;

import com.models.CallHuntingEntity;

import java.util.List;

public interface CallHuntingService {
    List<CallHuntingEntity>  getAll();
    CallHuntingEntity getOne(Long id);
    void delete(Long id);
    CallHuntingEntity create(CallHuntingEntity callHunting);
    boolean exists(CallHuntingEntity callHunting);
    CallHuntingEntity update(CallHuntingEntity entry, CallHuntingEntity persisted);
}

