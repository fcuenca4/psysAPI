package com.services.implementations;
import com.models.LockedNumberEntity;
import com.repositories.LockedNumberRepository;
import com.services.LockedNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LockedNumberServiceImp implements LockedNumberService {

    @Autowired
    LockedNumberRepository repository;
    @Override
    public List<LockedNumberEntity> getAll(){
        return repository.findAll();
    }

    @Override
    public LockedNumberEntity read(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("LockedNumber not found");
        return repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("LockedNumber not found");
        repository.delete(id);
    }

    @Override
    public LockedNumberEntity create(LockedNumberEntity lockedNumber) {

        return repository.save(lockedNumber);
    }
}
