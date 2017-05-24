package com.repositories;

import com.models.CallHuntingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallHuntingRepository extends JpaRepository<CallHuntingEntity,Integer> {
}

