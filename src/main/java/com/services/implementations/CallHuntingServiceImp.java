package com.services.implementations;
import com.models.CallHuntingEntity;
import com.repositories.CallHuntingRepository;
import com.services.CallHuntingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CallHuntingServiceImp implements CallHuntingService {

    @Autowired
    CallHuntingRepository repository;
    @Override
    public List<CallHuntingEntity> getAll(){
        return repository.findAll();
    }

    @Override
    public CallHuntingEntity read(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("CallHunting not found");
        return repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("CallHunting not found");
        repository.delete(id);
    }

    @Override
    public CallHuntingEntity create(CallHuntingEntity callhunting) {
        return repository.save(callhunting);
    }
}