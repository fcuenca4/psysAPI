package com.services.implementations;

import com.models.SubscriberEntity;
import com.repositories.SubscriberRepository;
import com.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberServiceImp implements SubscriberService {

    @Autowired
    SubscriberRepository repository;

    @Override
    public List<SubscriberEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public SubscriberEntity getOne(Long id) {
        if (!repository.exists(id))
            return null;
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        try {
            repository.delete(id);
        } catch (EmptyResultDataAccessException e) {

        }
    }

    @Override
    public SubscriberEntity create(SubscriberEntity subscriber) {
        if (!this.exists(subscriber))
            return repository.save(subscriber);
        else
            return null;
    }

    @Override
    public boolean exists(SubscriberEntity subscriber) {
//        return repository.exists(subscriber.getScbId()) || this.existsDN(subscriber);
        return this.existsDN(subscriber);

    }

    private boolean existsDN(SubscriberEntity subscriber) {
        return (repository.findFirstByScbDn(subscriber.getScbDn()) != null);
    }

    @Override
    public SubscriberEntity update(SubscriberEntity entry, SubscriberEntity persisted) {
        SubscriberEntity toSave = updateModelData(entry, persisted);
        return repository.save(toSave);
    }

    @Override
    public List<SubscriberEntity> getAllByScbDn(String scbDn) {
        return repository.findAllByScbDn(scbDn);
    }

    private SubscriberEntity updateModelData(SubscriberEntity entry, SubscriberEntity persisted) {
        persisted.setScbAddressDepartment(entry.getScbAddressDepartment());
        persisted.setScbAddressFloor(entry.getScbAddressFloor());
        persisted.setScbAddressNumber(entry.getScbAddressNumber());
        persisted.setScbAddressStreet(entry.getScbAddressStreet());
        persisted.setScbCommunityId(entry.getScbCommunityId());
        persisted.setScbDn(entry.getScbDn());
        persisted.setScbFirstName(entry.getScbFirstName());
        persisted.setScbHzRplanId(entry.getScbHzRplanId());
        persisted.setScbIdentificationNumber(entry.getScbIdentificationNumber());
        persisted.setScbImsi(entry.getScbImsi());
        persisted.setScbLastName(entry.getScbLastName());
        persisted.setScbLastUpdateUtc(entry.getScbLastUpdateUtc());
        persisted.setScbLggId(entry.getScbLggId());
        persisted.setScbModel(entry.getScbModel());
        persisted.setScbPassword(entry.getScbPassword());
        persisted.setScbPingPokeCall(entry.getScbPingPokeCall());
        persisted.setScbRplanId(entry.getScbRplanId());
        persisted.setScbSclassId(entry.getScbSclassId());
        persisted.setScbHomeZone(entry.getScbHomeZone());
        return persisted;
    }
}
