package com.services;

import com.models.BlackWhiteListEntity;

import java.util.List;

public interface DecoratorService {
    List<BlackWhiteListEntity>  getAll();
    BlackWhiteListEntity getOne(Long id);
    void delete(Long id);
    BlackWhiteListEntity create(BlackWhiteListEntity blackwhite);
    boolean exists(BlackWhiteListEntity blackwhite);
    BlackWhiteListEntity update(BlackWhiteListEntity entry, BlackWhiteListEntity persisted);
}

