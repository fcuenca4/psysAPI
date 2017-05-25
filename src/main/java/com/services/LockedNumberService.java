package com.services;

import com.models.LockedNumberEntity;

import java.util.List;

public interface LockedNumberService {
    List<LockedNumberEntity>  getAll();
    LockedNumberEntity getOne(Long id);
    void delete(Long id);
    LockedNumberEntity create(LockedNumberEntity lockedNumber);
    boolean exists(LockedNumberEntity lockedNumber);
    LockedNumberEntity update(LockedNumberEntity entry, LockedNumberEntity persisted);
}

