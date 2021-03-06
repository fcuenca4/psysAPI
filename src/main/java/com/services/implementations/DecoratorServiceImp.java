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
    public List<BlackWhiteListEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public BlackWhiteListEntity getOne(Long id) {
        if (!repository.exists(id))
            throw new EntityNotFoundException("BlackWhiteList not found");
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        if (!repository.exists(id))
            throw new EntityNotFoundException("BlackWhiteList not found");
        repository.delete(id);
    }

    @Override
    public BlackWhiteListEntity create(BlackWhiteListEntity decorator) {
        if (!this.exists(decorator))
            return repository.save(decorator);
        return null;
    }

    @Override
    //TODO INSERT REPEATED ENTRY
    public boolean exists(BlackWhiteListEntity blackwhite) {
        return false;
    }

    @Override
    public BlackWhiteListEntity update(BlackWhiteListEntity entry, BlackWhiteListEntity persisted) {
        BlackWhiteListEntity toSave = updateModelData(entry, persisted);
        return repository.save(toSave);
    }

    @Override
    public List<BlackWhiteListEntity> findAllByLckScbId(Long id) {
        return repository.findAllByBwlScbId(id);
    }

    @Override
    public BlackWhiteListEntity findByBwlIdAndBwlScbId(Long subscriberID, Long black_white_listID) {
        return repository.findByBwlIdAndBwlScbId(subscriberID, black_white_listID);
    }

    private BlackWhiteListEntity updateModelData(BlackWhiteListEntity entry, BlackWhiteListEntity persisted) {
        persisted.setBwlBlackWhiteList(entry.getBwlBlackWhiteList());
        persisted.setBwlDn(entry.getBwlDn());
        persisted.setBwlLastUpdateUtc(entry.getBwlLastUpdateUtc());
        persisted.setBwlScbId(entry.getBwlScbId());
        persisted.setBwlSvtId(entry.getBwlSvtId());
        persisted.setBwlDescription(entry.getBwlDescription());
        return persisted;
    }
}
