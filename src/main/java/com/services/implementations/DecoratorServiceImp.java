package com.services.implementations;
import com.models.BlackWhiteListEntity;
import com.repositories.DecoratorRepository;
import com.services.DecoratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DecoratorServiceImp implements DecoratorService {

    @Autowired
    DecoratorRepository repository;
    @Override
    public List<BlackWhiteListEntity> getAll(){
        return repository.findAll();
    }

    @Override
    public BlackWhiteListEntity read(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("BlackWhiteList not found");
        return repository.findOne(id);
    }

    @Override
    public void delete(Integer id) {
        if(!repository.exists(id))
            throw new EntityNotFoundException("BlackWhiteList not found");
        repository.delete(id);
    }

    @Override
    public BlackWhiteListEntity create(BlackWhiteListEntity decorator) {
        return repository.save(decorator);
    }
}
