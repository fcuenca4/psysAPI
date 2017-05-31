package com.repositories;

import com.models.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity,Long> {
    List<SubscriberEntity> findAllByScbDn(String ScbDn);
    SubscriberEntity findFirstByScbDn(String ScbDn);
}

