package com.repositories;

import com.models.LockedNumberEntity;
import com.models.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LockedNumberRepository extends JpaRepository<LockedNumberEntity,Long> {
    List<LockedNumberEntity> findAllByLckScbId(Long id);
}

