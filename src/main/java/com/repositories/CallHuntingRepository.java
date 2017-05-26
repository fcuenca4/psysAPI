package com.repositories;

import com.models.CallHuntingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallHuntingRepository extends JpaRepository<CallHuntingEntity,Long> {
    List<CallHuntingEntity> findAllByChtScbId(Long id);

}

