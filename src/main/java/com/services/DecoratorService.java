package com.services;
import com.models.BlackWhiteListEntity;

import java.util.List;

public interface DecoratorService {
    List<BlackWhiteListEntity>  getAll();
    BlackWhiteListEntity read(Integer id);
    void delete(Integer id);
    BlackWhiteListEntity create(BlackWhiteListEntity decorator);
}