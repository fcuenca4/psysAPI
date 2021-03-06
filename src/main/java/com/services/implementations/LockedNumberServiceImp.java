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
    public List<LockedNumberEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public LockedNumberEntity getOne(Long id) {
        if (!repository.exists(id))
            return null;
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        if (!repository.exists(id))
            throw new EntityNotFoundException("LockedNumber not found");
        repository.delete(id);
    }

    @Override
    public LockedNumberEntity create(LockedNumberEntity lockedNumber) {
        if (!this.exists(lockedNumber))
            return repository.save(lockedNumber);
        else return null;
    }

    @Override
    //TODO INSERT REPEATED ENTRY
    public boolean exists(LockedNumberEntity lockedNumber) {
        return false;
    }

    @Override
    public LockedNumberEntity update(LockedNumberEntity entry, LockedNumberEntity persisted) {
        LockedNumberEntity toSave = updateModelData(entry, persisted);
        return repository.save(toSave);
    }

    @Override
    public List<LockedNumberEntity> findAllByLckScbId(Long id) {
        return repository.findAllByLckScbId(id);
    }

    @Override
    public LockedNumberEntity findByLckIdAndLckScbId(Long LckId, Long ScbId) {
        return repository.findByLckIdAndLckScbId(LckId, ScbId);
    }


    private LockedNumberEntity updateModelData(LockedNumberEntity entry, LockedNumberEntity persisted) {

        persisted.setLckDn(entry.getLckDn());
        persisted.setLckLastUpdateUtc(entry.getLckLastUpdateUtc());
        persisted.setLckScbId(entry.getLckScbId());
        persisted.setLckSvtId(entry.getLckSvtId());
        persisted.setLckDn(entry.getLckDn());
        return persisted;
    }
}
