package com.services;
import com.models.SubscriberEntity;

import java.util.List;

public interface SubscriberService {
     List<SubscriberEntity>  getAll();
     SubscriberEntity getOne(Long id) ;
     void delete(Long id);
     SubscriberEntity create(SubscriberEntity subscriber);
     boolean exists(SubscriberEntity subscriber);
     //boolean existsDN(SubscriberEntity subscriber);
     SubscriberEntity update(SubscriberEntity entry, SubscriberEntity persisted);
     List<SubscriberEntity> getAllByScbDn(String scbDn);
}
