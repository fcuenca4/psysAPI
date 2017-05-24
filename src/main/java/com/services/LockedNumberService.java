package com.services;

import com.models.LockedNumberEntity;

import java.util.List;

public interface LockedNumberService {
    List<LockedNumberEntity>  getAll();
    LockedNumberEntity read(Integer id);
    void delete(Integer id);
    LockedNumberEntity create(LockedNumberEntity lockedNumber);
}

