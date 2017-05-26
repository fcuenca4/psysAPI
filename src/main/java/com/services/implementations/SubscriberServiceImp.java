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
        if (!repository.exists(id))
            throw new EntityNotFoundException("Subscriber not found");
        repository.delete(id);
    }

    @Override
    public SubscriberEntity create(SubscriberEntity subscriber) {
        return repository.save(subscriber);
    }

    @Override
    public boolean exists(SubscriberEntity subscriber) {
        return repository.exists(subscriber.getScbId());
    }

    @Override
    public SubscriberEntity update(SubscriberEntity entry, SubscriberEntity persisted) {
        SubscriberEntity toSave = updateModelData(entry, persisted);
        return repository.save(toSave);
    }

    @Override
    public SubscriberEntity getOneByScbDn(Long scbDn) {
        return repository.findByScbDn(scbDn);
    }

    private SubscriberEntity updateModelData(SubscriberEntity entry, SubscriberEntity persisted) {
        persisted.setScbAddressDepartment(entry.getScbAddressDepartment());
        persisted.setScbAddressFloor(entry.getScbAddressFloor());
        persisted.setScbAddressNumber(entry.getScbAddressNumber());
        persisted.setScbAddressStreet(entry.getScbAddressStreet());
        persisted.setScbCmmId(entry.getScbCmmId());
        persisted.setScbDn(entry.getScbDn());
        persisted.setScbFirstName(entry.getScbFirstName());
        persisted.setScbHzsId(entry.getScbHzsId());
        persisted.setScbIdentificationNumber(entry.getScbIdentificationNumber());
        persisted.setScbImsi(entry.getScbImsi());
        persisted.setScbLastName(entry.getScbLastName());
        persisted.setScbLastUpdateUtc(entry.getScbLastUpdateUtc());
        persisted.setScbLggId(entry.getScbLggId());
        persisted.setScbModel(entry.getScbModel());
        persisted.setScbPassword(entry.getScbPassword());
        persisted.setScbPingPokeCall(entry.getScbPingPokeCall());
        persisted.setScbRplId(entry.getScbRplId());
        persisted.setScbSclId(entry.getScbSclId());
        return persisted;
    }
}
