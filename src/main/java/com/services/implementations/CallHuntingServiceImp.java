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
    public CallHuntingEntity getOne(Long id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("CallHunting not found");
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("CallHunting not found");
        repository.delete(id);
    }

    @Override
    public CallHuntingEntity create(CallHuntingEntity callhunting) {
        return repository.save(callhunting);
    }

    @Override
    public boolean exists(CallHuntingEntity callHunting) {
        return repository.exists(callHunting.getChtId());
    }

    @Override
    public CallHuntingEntity update(CallHuntingEntity entry, CallHuntingEntity persisted) {
        persisted.setChtDn(entry.getChtDn());
        persisted.setChtLastUpdateUtc(entry.getChtLastUpdateUtc());
        persisted.setChtPriority(entry.getChtPriority());
        persisted.setChtScbId(entry.getChtScbId());
        return persisted;
    }

    @Override
    public List<CallHuntingEntity> findAllByLckScbId(Long id) {
        return repository.findAllByChtScbId(id);
    }

    @Override
    public CallHuntingEntity findByChtIdAndChtScbId(Long id, Long call_huntingID) {
        return repository.findByChtIdAndChtScbId(id,call_huntingID);
    }
}