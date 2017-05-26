package com.repositories;

import com.models.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity,Long> {
    SubscriberEntity findByScbDn(Long ScbDn);
}

