package com.services.implementations;
import com.models.SubscriberEntity;
import com.repositories.SubscriberRepository;
import com.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SubscriberServiceImp implements SubscriberService {

    @Autowired
    SubscriberRepository repository;
    @Override
    public List<SubscriberEntity> getAll(){
        return repository.findAll();
    }

    @Override
    public SubscriberEntity read(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("Subscriber not found");
        return repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("Subscriber not found");
        repository.delete(id);
    }

    @Override
    public SubscriberEntity create(SubscriberEntity subscriber) {
        return repository.save(subscriber);
    }
}
