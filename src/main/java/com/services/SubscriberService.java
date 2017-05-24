package com.services;
import com.models.SubscriberEntity;

import java.util.List;

public interface SubscriberService {
     List<SubscriberEntity>  getAll();
     SubscriberEntity read(Integer id);
     void delete(Integer id);
     SubscriberEntity create(SubscriberEntity subscriber);
}
