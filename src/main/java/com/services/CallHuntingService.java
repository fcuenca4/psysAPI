package com.services;
import com.models.CallHuntingEntity;

import java.util.List;

public interface CallHuntingService {
    List<CallHuntingEntity>  getAll();
    CallHuntingEntity read(Integer id);
    void delete(Integer id);
    CallHuntingEntity create(CallHuntingEntity CallHunting);
}
